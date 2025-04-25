package net.veroxuniverse.samurai_dynasty.block;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.veroxuniverse.samurai_dynasty.block.blockstate.FlameType;
import net.veroxuniverse.samurai_dynasty.block.blockstate.SupportType;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LampBlock extends Block {

    public static final VoxelShape SHAPE_BASE = Block.box(3.0D, 0.01D, 3.0D, 13.0D, 16.0D, 13.0D);
    public static final VoxelShape SHAPE_WALL = Block.box(3.0D, 0.01D, 3.0D, 13.0D, 16.0D, 13.0D);
    public static final VoxelShape SHAPE_HANGING = Block.box(3.0D, 3.01D, 3.0D, 13.0D, 16.0D, 13.0D);
    public static final EnumProperty<SupportType> SUPPORT_TYPE = EnumProperty.create("support_type", SupportType.class);
    public static final EnumProperty<FlameType> FLAME_TYPE = EnumProperty.create("flame_type", FlameType.class);;

    public LampBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SUPPORT_TYPE, SupportType.NORMAL)
                .setValue(FLAME_TYPE, FlameType.NORMAL));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState below = context.getLevel().getBlockState(context.getClickedPos().below());
        return this.defaultBlockState().setValue(SUPPORT_TYPE, getSupportTypeFor(below));
    }

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        switch (blockState.getValue(SUPPORT_TYPE)) {
            case WALL -> {
                return SHAPE_WALL;
            }
            case HANGING -> {
                return SHAPE_HANGING;
            }
            default -> {
                return SHAPE_BASE;
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN) {
            return state.setValue(SUPPORT_TYPE, getSupportTypeFor(neighborState));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    private SupportType getSupportTypeFor(BlockState below) {
        if (below.is(BlockTags.WALLS)) {
            return SupportType.WALL;
        } else if (!below.isAir() && below.isSolid()) {
            return SupportType.NORMAL;
        } else {
            return SupportType.HANGING;
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double d0 = pos.getX() + 0.5;
        double d1 = pos.getY() + 0.55;
        double d2 = pos.getZ() + 0.5;

        SimpleParticleType particle = state.getValue(FLAME_TYPE) == FlameType.SOUL
                ? ParticleTypes.SOUL_FIRE_FLAME
                : ParticleTypes.FLAME;

        level.addParticle(particle, d0, d1, d2, 0.0, 0.01, 0.0);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            FlameType currentFlame = state.getValue(FLAME_TYPE);

            if (stack.is(ItemsRegistry.SPIRIT_FLAME.get()) && currentFlame != FlameType.SOUL) {
                level.setBlock(pos, state.setValue(FLAME_TYPE, FlameType.SOUL), 3);
                level.playSound(null, pos, SoundEvents.WITHER_AMBIENT, SoundSource.BLOCKS, 0.1f, 1.2f);
                if (!player.isCreative()) stack.shrink(1);
                return ItemInteractionResult.SUCCESS;

            } else if ((stack.is(Items.COAL) || stack.is(Items.CHARCOAL)) && currentFlame != FlameType.NORMAL) {
                level.setBlock(pos, state.setValue(FLAME_TYPE, FlameType.NORMAL), 3);
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 0.5f, 1.2f);
                if (!player.isCreative()) stack.shrink(1);
                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockState blockBelow = level.getBlockState(pos.below());

        if (!level.isClientSide && player.isCrouching() && blockBelow.isAir()) {
            SupportType currentSupportType = state.getValue(SUPPORT_TYPE);
            SupportType newSupportType = (currentSupportType == SupportType.NORMAL) ? SupportType.HANGING : SupportType.NORMAL;
            level.setBlock(pos, state.setValue(SUPPORT_TYPE, newSupportType), 3);
            level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, 1.0F);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SUPPORT_TYPE, FLAME_TYPE);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("info.samurai_dynasty.summary.text"));
            tooltipComponents.add(Component.literal(""));
            tooltipComponents.add(Component.translatable("info.samurai_dynasty.summary.lamp"));
            tooltipComponents.add(Component.translatable("info.samurai_dynasty.summary.flame_toggle"));

        } else {
            tooltipComponents.add(Component.translatable("info.samurai_dynasty.summary.text"));
        }
    }
}

