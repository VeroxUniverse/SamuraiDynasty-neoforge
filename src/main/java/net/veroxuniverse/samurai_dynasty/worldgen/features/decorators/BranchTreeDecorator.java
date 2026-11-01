package net.veroxuniverse.samurai_dynasty.worldgen.features.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.ArrayList;
import java.util.List;

public class BranchTreeDecorator extends TreeDecorator {

    public static final MapCodec<BranchTreeDecorator> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(BranchTreeDecorator::getProbability),
                    BlockStateProvider.CODEC.fieldOf("block_provider").forGetter(BranchTreeDecorator::getBlockProvider),
                    Codec.BOOL.fieldOf("require_leaves_above").forGetter(BranchTreeDecorator::isRequireLeavesAbove),
                    Codec.INT.fieldOf("min_count").forGetter(BranchTreeDecorator::getMinCount),
                    Codec.INT.fieldOf("max_count").forGetter(BranchTreeDecorator::getMaxCount)
            ).apply(builder, BranchTreeDecorator::new)
    );

    protected final float probability;
    protected final BlockStateProvider blockProvider;
    protected final boolean requireLeavesAbove;
    protected final int minCount;
    protected final int maxCount;

    public BranchTreeDecorator(float probability, BlockStateProvider blockProvider, boolean requireLeavesAbove, int minCount, int maxCount) {
        this.probability = probability;
        this.blockProvider = blockProvider;
        this.requireLeavesAbove = requireLeavesAbove;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    @Override
    public void place(Context context) {
        List<BlockPos> logs = context.logs();
        List<BlockPos> leaves = context.leaves();
        RandomSource random = context.random();

        int minY = logs.stream().mapToInt(BlockPos::getY).min().orElse(0);
        int maxY = logs.stream().mapToInt(BlockPos::getY).max().orElse(0);

        boolean capped = this.maxCount >= 0;
        int targetCount = capped ? this.minCount + random.nextInt(Math.max(1, this.maxCount - this.minCount + 1)) : -1;
        int placed = 0;

        List<BlockPos> shuffledLogs = this.shuffle(logs, random);

        for (BlockPos logPos : shuffledLogs) {
            if (capped && placed >= targetCount) {
                return;
            }

            if (this.requireLeavesAbove) {
                if (logPos.getY() < maxY - 2) {
                    continue;
                }
            } else {
                if (logPos.getY() <= minY || logPos.getY() >= maxY - 2) {
                    continue;
                }
            }

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (capped && placed >= targetCount) {
                    return;
                }

                if (random.nextFloat() > this.probability) {
                    continue;
                }

                BlockPos branchPos = logPos.relative(direction);

                if (!context.isAir(branchPos)) {
                    continue;
                }

                if (this.requireLeavesAbove && !this.hasLeavesAbove(context, leaves, branchPos.above())) {
                    continue;
                }

                BlockState branchState = this.blockProvider.getState(random, branchPos);
                if (branchState.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    branchState = branchState.setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
                }

                context.setBlock(branchPos, branchState);
                placed++;
            }
        }
    }

    private List<BlockPos> shuffle(List<BlockPos> positions, RandomSource random) {
        List<BlockPos> shuffled = new ArrayList<>(positions);
        for (int i = shuffled.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            BlockPos temp = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, temp);
        }
        return shuffled;
    }

    private boolean hasLeavesAbove(Context context, List<BlockPos> leaves, BlockPos pos) {
        return leaves.contains(pos) || context.level().isStateAtPosition(pos, state -> state.is(BlockTags.LEAVES));
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModDecoratorTypes.BRANCH_DECORATOR.get();
    }

    public float getProbability() {
        return probability;
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }

    public boolean isRequireLeavesAbove() {
        return requireLeavesAbove;
    }

    public int getMinCount() {
        return minCount;
    }

    public int getMaxCount() {
        return maxCount;
    }
}