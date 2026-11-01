package net.veroxuniverse.samurai_dynasty.block;

import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FamilyFenceBlock extends FenceBlock {

    private final TagKey<Block> familyTag;

    public FamilyFenceBlock(TagKey<Block> familyTag, BlockBehaviour.Properties properties) {
        super(properties);
        this.familyTag = familyTag;
    }

    @Override
    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        return state.is(this.familyTag);
    }
}