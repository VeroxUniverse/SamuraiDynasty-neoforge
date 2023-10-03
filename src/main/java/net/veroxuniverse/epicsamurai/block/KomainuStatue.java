package net.veroxuniverse.epicsamurai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class KomainuStatue extends Block {
    public KomainuStatue(Properties pProperties) {
        super(pProperties);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(0.0625, 0, 0.0625, 0.9375, 0.375, 0.9375),
            Block.box(0.0625, 0, 0.0625, 0.9375, 0.375, 0.9375), 
            Block.box(0.25, 0.375, 0.0625, 0.4375, 0.5, 0.1875),
            Block.box(0.5625, 0.375, 0.0625, 0.75, 0.5, 0.1875),
            Block.box(0.25, 0.375, 0.1875, 0.75, 0.875, 0.375),
            Block.box(0.125, 0.375, 0.5625, 0.875, 0.75, 0.875),
            Block.box(0.375, 1.3125, 0.1875, 0.625, 1.4375, 0.625),
            Block.box(0.3125, 0.9375, 0, 0.6875, 1.125, 0.1875),
            Block.box(0.375, 0.875, 0.0625, 0.625, 0.9375, 0.1875),
            Block.box(0.125, 1, 0.3125, 0.25, 1.1875, 0.5),
            Block.box(0.125, 0.875, 0.125, 0.3125, 1.0625, 0.3125),
            Block.box(0.1875, 0.8125, 0.0625, 0.3125, 0.9375, 0.1875),
            Block.box(0.6875, 0.8125, 0.0625, 0.8125, 0.9375, 0.1875),
            Block.box(0.6875, 0.875, 0.125, 0.875, 1.0625, 0.3125),
            Block.box(0.75, 1, 0.3125, 0.875, 1.1875, 0.5),
            Block.box(0.25, 0.875, 0.1875, 0.75, 1.3125, 0.5),
            Block.box(0.375, 1.4375, 0.5, 0.625, 1.5625, 0.625),
            Block.box(0.25, 1.1875, 0.125, 0.4375, 1.3125, 0.1875),
            Block.box(0.4375, 1.125, 0.0625, 0.5625, 1.3125, 0.1875),
            Block.box(0.625, 1.1875, 0.5, 0.75, 1.3125, 0.625),
            Block.box(0.625, 1.1875, 0.625, 0.75, 1.4375, 0.75),
            Block.box(0.25, 1.1875, 0.625, 0.375, 1.4375, 0.75),
            Block.box(0.25, 1.1875, 0.5, 0.375, 1.3125, 0.625),
            Block.box(0.125, 0.375, 0.4375, 0.3125, 0.5, 0.5625),
            Block.box(0.6875, 0.375, 0.4375, 0.875, 0.5, 0.5625),
            Block.box(0.375, 0.375, 0.6875, 0.625, 0.875, 1),
            Block.box(0.375, 0.875, 0.6875, 0.625, 1.0625, 0.875),
            Block.box(0.375, 0.9375, 0.5, 0.625, 1.3125, 0.625),
            Block.box(0.5625, 1.1875, 0.125, 0.75, 1.3125, 0.1875),
            Block.box(0.3125, 0.375, 0.375, 0.6875, 0.9375, 0.6875)

    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return SHAPE;
    }

}
