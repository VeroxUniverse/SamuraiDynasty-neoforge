package net.veroxuniverse.samurai_dynasty.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;

import javax.annotation.Nullable;
import java.util.Optional;

public class CloudBlock extends Block implements BucketPickup {

    public static final MapCodec<CloudBlock> CODEC = simpleCodec(CloudBlock::new);

    private static final VoxelShape FALLING_COLLISION_SHAPE = Shapes.box(0.0, 0.0, 0.0, 1.0, 0.8999999761581421, 1.0);

    public MapCodec<CloudBlock> codec() {
        return CODEC;
    }

    public CloudBlock(Properties properties) {
        super(properties);
    }

    protected boolean skipRendering(BlockState state, BlockState adjacentState, Direction direction) {
        return adjacentState.is(this) ? true : super.skipRendering(state, adjacentState, direction);
    }

    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getInBlockState().is(this)) {
            entity.makeStuckInBlock(state, new Vec3(0.8999999761581421, 1.5, 0.8999999761581421));
            if (level.isClientSide) {
                RandomSource randomsource = level.getRandom();
                boolean flag = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
                if (flag && randomsource.nextBoolean()) {
                    level.addParticle(ParticleTypes.CLOUD, entity.getX(), (double)(pos.getY() + 1), entity.getZ(), (double)(Mth.randomBetween(randomsource, -1.0F, 1.0F) * 0.083333336F), 0.05000000074505806, (double)(Mth.randomBetween(randomsource, -1.0F, 1.0F) * 0.083333336F));
                    if (entity instanceof Player player) {
                        level.playSound(player, pos, SoundEvents.POWDER_SNOW_FALL, SoundSource.BLOCKS, 0.8F,0.6F);
                    }
                }
            }
        }

        if (!level.isClientSide) {
            if (entity.isOnFire() && (level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) || entity instanceof Player) && entity.mayInteract(level, pos)) {
                level.destroyBlock(pos, false);
            }

            entity.setSharedFlagOnFire(false);
        }

    }

    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entitycollisioncontext) {
            Entity entity = entitycollisioncontext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F) {
                    return FALLING_COLLISION_SHAPE;
                }

                boolean flag = entity instanceof FallingBlockEntity;
                if (flag || canEntityWalkOnCloud(entity) && context.isAbove(Shapes.block(), pos, false) && !context.isDescending()) {
                    return super.getCollisionShape(state, level, pos, context);
                }
            }
        }

        return Shapes.empty();
    }

    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!((double)fallDistance < 4.0) && entity instanceof LivingEntity livingentity) {
            LivingEntity.Fallsounds $$7 = livingentity.getFallSounds();
            SoundEvent soundevent = (double)fallDistance < 7.0 ? $$7.small() : $$7.big();
            entity.playSound(soundevent, 1.0F, 1.0F);
        }

    }

    protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public static boolean canEntityWalkOnCloud(Entity entity) {
        if (entity.getType().is(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS)) {
            return true;
        } else {
            return entity instanceof LivingEntity ? ((LivingEntity)entity).getItemBySlot(EquipmentSlot.FEET).canWalkOnPowderedSnow((LivingEntity)entity) : false;
        }
    }

    public ItemStack pickupBlock(@Nullable Player player, LevelAccessor level, BlockPos pos, BlockState state) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
        if (!level.isClientSide()) {
            level.levelEvent(2001, pos, Block.getId(state));
        }

        return new ItemStack(ItemsRegistry.CLOUD_BUCKET.get());
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_POWDER_SNOW);
    }
}
