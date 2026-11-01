package net.veroxuniverse.samurai_dynasty.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.veroxuniverse.samurai_dynasty.block.blockstate.RoofShape;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class RoofSlopeBlock extends HorizontalDirectionalBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<RoofShape> SHAPE = EnumProperty.create("shape", RoofShape.class);

    private static final VoxelShape SHAPE_STRAIGHT = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 5, 16, 8, 16),
            Block.box(0, 8, 9, 16, 12, 16),
            Block.box(0, 12, 13, 16, 16, 16)
    );

    private static final VoxelShape SHAPE_SIDE_EAST = rotateShape(SHAPE_STRAIGHT, 1);
    private static final VoxelShape SHAPE_SIDE_WEST = rotateShape(SHAPE_STRAIGHT, 3);

    private static final VoxelShape SHAPE_INNER_LEFT = Shapes.or(SHAPE_STRAIGHT, SHAPE_SIDE_WEST);
    private static final VoxelShape SHAPE_INNER_RIGHT = Shapes.or(SHAPE_STRAIGHT, SHAPE_SIDE_EAST);
    private static final VoxelShape SHAPE_OUTER_LEFT = Shapes.joinUnoptimized(SHAPE_STRAIGHT, SHAPE_SIDE_WEST, BooleanOp.AND);
    private static final VoxelShape SHAPE_OUTER_RIGHT = Shapes.joinUnoptimized(SHAPE_STRAIGHT, SHAPE_SIDE_EAST, BooleanOp.AND);

    private static final Map<BlockState, VoxelShape> SHAPES_BY_STATE = new HashMap<>();

    public static final MapCodec<RoofSlopeBlock> CODEC = simpleCodec(RoofSlopeBlock::new);

    public RoofSlopeBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SHAPE, RoofShape.STRAIGHT));

        this.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction dir = state.getValue(FACING);
            RoofShape shape = state.getValue(SHAPE);
            int rot = getRotationTimes(dir);

            VoxelShape base = switch (shape) {
                case STRAIGHT -> SHAPE_STRAIGHT;
                case INNER_LEFT -> SHAPE_INNER_LEFT;
                case INNER_RIGHT -> SHAPE_INNER_RIGHT;
                case OUTER_LEFT -> SHAPE_OUTER_LEFT;
                case OUTER_RIGHT -> SHAPE_OUTER_RIGHT;
            };

            SHAPES_BY_STATE.put(state, rotateShape(base, rot));
        });
    }

    private static int getRotationTimes(Direction dir) {
        return switch (dir) {
            case EAST -> 1;
            case SOUTH -> 2;
            case WEST -> 3;
            default -> 0;
        };
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return SHAPES_BY_STATE.getOrDefault(blockState, SHAPE_STRAIGHT);
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return getShape(pState, pLevel, pPos, CollisionContext.empty());
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        return state.setValue(SHAPE, getRoofShape(state, pContext.getLevel(), pContext.getClickedPos()));
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pDirection.getAxis().isHorizontal()) {
            return pState.setValue(SHAPE, getRoofShape(pState, pLevel, pPos));
        }
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    protected void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
        if (!pLevel.isClientSide) {
            BlockState newState = pState.setValue(SHAPE, getRoofShape(pState, pLevel, pPos));
            if (newState != pState) {
                pLevel.setBlock(pPos, newState, 3);
            }
        }
    }

    public static RoofShape getRoofShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        Direction facing = pState.getValue(FACING);

        BlockPos behindPos = pPos.relative(facing.getOpposite());
        BlockState behindState = pLevel.getBlockState(behindPos);
        if (isRoof(behindState)) {
            Direction behindFacing = behindState.getValue(FACING);
            if (behindFacing.getAxis() != facing.getAxis() && canTakeShape(pState, pLevel, pPos, behindFacing)) {
                if (behindFacing == facing.getCounterClockWise()) {
                    return RoofShape.OUTER_LEFT;
                }
                return RoofShape.OUTER_RIGHT;
            }
        }

        BlockPos frontPos = pPos.relative(facing);
        BlockState frontState = pLevel.getBlockState(frontPos);
        if (isRoof(frontState)) {
            Direction frontFacing = frontState.getValue(FACING);
            if (frontFacing.getAxis() != facing.getAxis() && canTakeShape(pState, pLevel, pPos, frontFacing.getOpposite())) {
                if (frontFacing == facing.getCounterClockWise()) {
                    return RoofShape.INNER_LEFT;
                }
                return RoofShape.INNER_RIGHT;
            }
        }

        return RoofShape.STRAIGHT;
    }

    private static boolean canTakeShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFace) {
        BlockState neighborState = pLevel.getBlockState(pPos.relative(pFace));
        return !isRoof(neighborState) || neighborState.getValue(FACING) != pState.getValue(FACING);
    }

    private static VoxelShape rotateShape(VoxelShape pShape, int pTimes) {
        VoxelShape current = pShape;
        for (int i = 0; i < pTimes; i++) {
            VoxelShape[] rotated = new VoxelShape[]{Shapes.empty()};
            current.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) ->
                    rotated[0] = Shapes.or(rotated[0], Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            current = rotated[0];
        }
        return current;
    }

    private static boolean isRoof(BlockState pState) {
        return pState.getBlock() instanceof RoofSlopeBlock;
    }

    public @NotNull BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState pState, Mirror pMirror) {
        Direction facing = pState.getValue(FACING);
        RoofShape shape = pState.getValue(SHAPE);

        if (pMirror == Mirror.LEFT_RIGHT && facing.getAxis() == Direction.Axis.Z) {
            return pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, mirrorShape(shape));
        }
        if (pMirror == Mirror.FRONT_BACK && facing.getAxis() == Direction.Axis.X) {
            return pState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, mirrorShape(shape));
        }

        return super.mirror(pState, pMirror);
    }

    private static RoofShape mirrorShape(RoofShape pShape) {
        if (pShape == RoofShape.OUTER_LEFT) return RoofShape.OUTER_RIGHT;
        if (pShape == RoofShape.OUTER_RIGHT) return RoofShape.OUTER_LEFT;
        if (pShape == RoofShape.INNER_LEFT) return RoofShape.INNER_RIGHT;
        if (pShape == RoofShape.INNER_RIGHT) return RoofShape.INNER_LEFT;
        return RoofShape.STRAIGHT;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, SHAPE);
    }
}