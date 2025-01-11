package net.veroxuniverse.samurai_dynasty.worldgen.features.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LeavesAwareAttachedToLogsDecorator extends TreeDecorator {

    public static final MapCodec<LeavesAwareAttachedToLogsDecorator> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(LeavesAwareAttachedToLogsDecorator::getProbability),
                    Codec.intRange(0, 16).fieldOf("exclusion_radius_xz").forGetter(LeavesAwareAttachedToLogsDecorator::getExclusionRadiusXZ),
                    Codec.intRange(0, 16).fieldOf("exclusion_radius_y").forGetter(LeavesAwareAttachedToLogsDecorator::getExclusionRadiusY),
                    BlockStateProvider.CODEC.fieldOf("block_provider").forGetter(LeavesAwareAttachedToLogsDecorator::getBlockProvider),
                    Codec.intRange(1, 16).fieldOf("required_empty_blocks").forGetter(LeavesAwareAttachedToLogsDecorator::getRequiredEmptyBlocks),
                    ExtraCodecs.nonEmptyList(Direction.CODEC.listOf()).fieldOf("directions").forGetter(LeavesAwareAttachedToLogsDecorator::getDirections)
            ).apply(builder, LeavesAwareAttachedToLogsDecorator::new)
    );

    protected final float probability;
    protected final int exclusionRadiusXZ;
    protected final int exclusionRadiusY;
    protected final BlockStateProvider blockProvider;
    protected final int requiredEmptyBlocks;
    protected final List<Direction> directions;

    public LeavesAwareAttachedToLogsDecorator(float probability, int exclusionRadiusXZ, int exclusionRadiusY,
                                              BlockStateProvider blockProvider, int requiredEmptyBlocks, List<Direction> directions) {
        this.probability = probability;
        this.exclusionRadiusXZ = exclusionRadiusXZ;
        this.exclusionRadiusY = exclusionRadiusY;
        this.blockProvider = blockProvider;
        this.requiredEmptyBlocks = requiredEmptyBlocks;
        this.directions = directions;
    }

    @Override
    public void place(Context context) {
        Set<BlockPos> processedPositions = new HashSet<>();
        RandomSource random = context.random();
        Iterator<BlockPos> logs = Util.shuffledCopy(context.logs(), random).iterator();

        while (logs.hasNext()) {
            BlockPos logPos = logs.next();
            Direction direction = Util.getRandom(this.directions, random);
            BlockPos relative = logPos.relative(direction);

            if (processedPositions.contains(relative)) {
                continue;
            }

            if (!(random.nextFloat() < this.probability)) {
                continue;
            }

            if (!this.hasRequiredEmptyBlocks(context, logPos, direction, this.requiredEmptyBlocks)) {
                continue;
            }

            BlockPos above = relative.above();
            boolean isLeavesAbove = context.level().isStateAtPosition(above, state -> state.is(BlockTags.LEAVES));
            if (!isLeavesAbove) {
                continue;
            }

            BlockPos offsetMin = relative.offset(-this.exclusionRadiusXZ, -this.exclusionRadiusY, -this.exclusionRadiusXZ);
            BlockPos offsetMax = relative.offset(this.exclusionRadiusXZ, this.exclusionRadiusY, this.exclusionRadiusXZ);
            for (BlockPos pos : BlockPos.betweenClosed(offsetMin, offsetMax)) {
                processedPositions.add(pos.immutable());
            }

            BlockState state = this.blockProvider.getState(random, relative);
            if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                state = state.setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
            }

            context.setBlock(relative, state);
        }
    }

    private boolean hasRequiredEmptyBlocks(Context context, BlockPos pos, Direction direction, int requiredEmptyBlocks) {
        for (int i = 1; i <= requiredEmptyBlocks; i++) {
            BlockPos checkPos = pos.relative(direction, i);
            if (!context.isAir(checkPos)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModDecoratorTypes.LEAVES_ATTACHED_TO_LOGS.get();
    }

    public float getProbability() {
        return probability;
    }

    public int getExclusionRadiusXZ() {
        return exclusionRadiusXZ;
    }

    public int getExclusionRadiusY() {
        return exclusionRadiusY;
    }

    public BlockStateProvider getBlockProvider() {
        return blockProvider;
    }

    public int getRequiredEmptyBlocks() {
        return requiredEmptyBlocks;
    }

    public List<Direction> getDirections() {
        return directions;
    }
}