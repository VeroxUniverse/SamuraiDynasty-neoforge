package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, net.neoforged.neoforge.common.data.ExistingFileHelper exFileHelper) {
        super(output, SamuraiDynastyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlocksRegistry.SPIRIT_STONE);
        stairsBlock((StairBlock) BlocksRegistry.SPIRIT_STONE_STAIRS.get(), blockTexture(BlocksRegistry.SPIRIT_STONE.get()));
        slabBlock(((SlabBlock) BlocksRegistry.SPIRIT_STONE_SLAB.get()), blockTexture(BlocksRegistry.SPIRIT_STONE.get()), blockTexture(BlocksRegistry.SPIRIT_STONE.get()));
        wallBlock((WallBlock) BlocksRegistry.SPIRIT_STONE_WALL.get(), blockTexture(BlocksRegistry.SPIRIT_STONE.get()));

        blockItem(BlocksRegistry.SPIRIT_STONE_STAIRS);
        blockItem(BlocksRegistry.SPIRIT_STONE_SLAB);

        blockWithItem(BlocksRegistry.CHISELED_SPIRIT_STONE_BRICKS);
        blockWithItem(BlocksRegistry.CHISELED_PATTERN_SPIRIT_STONE_BRICKS);
        blockWithItem(BlocksRegistry.MOSAIC_SPIRIT_STONE_BRICKS);

        blockWithItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS);
        stairsBlock((StairBlock) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS.get(), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB.get()), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()));
        wallBlock((WallBlock) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL.get(), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()));

        blockItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS);
        blockItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB);


        blockWithItem(BlocksRegistry.PATH_SPIRIT_STONE_BRICKS);
        blockWithItem(BlocksRegistry.PATTERN_MOSSY_SPIRIT_STONE_BRICKS);
        blockWithItem(BlocksRegistry.PATTERN_SPIRIT_STONE_BRICKS);

        blockWithItem(BlocksRegistry.POLISHED_SPIRIT_STONE);
        stairsBlock((StairBlock) BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS.get(), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()));
        slabBlock(((SlabBlock) BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB.get()), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()));
        wallBlock((WallBlock) BlocksRegistry.POLISHED_SPIRIT_STONE_WALL.get(), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()));

        blockItem(BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS);
        blockItem(BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB);
    }


    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("samurai_dynasty:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("samurai_dynasty:block/" + deferredBlock.getId().getPath() + appendix));
    }

}