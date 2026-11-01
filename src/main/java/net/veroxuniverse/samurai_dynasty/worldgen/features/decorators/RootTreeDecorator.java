package net.veroxuniverse.samurai_dynasty.worldgen.features.decorators;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;

public class RootTreeDecorator extends TreeDecorator {

    public static final MapCodec<RootTreeDecorator> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    com.mojang.serialization.Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(RootTreeDecorator::getProbability),
                    BlockStateProvider.CODEC.fieldOf("block_provider").forGetter(RootTreeDecorator::getBlockProvider)
            ).apply(builder, RootTreeDecorator::new)
    );

    protected final float probability;
    protected final BlockStateProvider blockProvider;

    public RootTreeDecorator(float probability, BlockStateProvider blockProvider) {
        this.probability = probability;
        this.blockProvider = blockProvider;
    }

    @Override
    public void place(Context context) {
        List<BlockPos> logs = context.logs();
        RandomSource random = context.random();

        int minY = logs.stream().mapToInt(BlockPos::getY).min().orElse(0);

        for (BlockPos logPos : logs) {
            if (logPos.getY() != minY) {
                continue;
            }

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (random.nextFloat() > this.probability) {
                    continue;
                }

                BlockPos rootPos = logPos.relative(direction);

                if (!context.isAir(rootPos)) {
                    continue;
                }

                if (!this.isValidGround(context, rootPos.below())) {
                    continue;
                }

                BlockState rootState = this.blockProvider.getState(random, rootPos);
                if (rootState.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    rootState = rootState.setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
                }

                context.setBlock(rootPos, rootState);
            }
        }
    }

    private boolean isValidGround(Context context, BlockPos pos) {
        return context.level().isStateAtPosition(pos, state ->
                state.is(BlockTags.DIRT)
                        || state.is(Blocks.MOSS_BLOCK)
                        || state.is(Blocks.MUD)
                        || state.is(Blocks.GRASS_BLOCK));
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModDecoratorTypes.ROOT_DECORATOR.get();
    }

    public float getProbability() {
        return probability;
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }
}