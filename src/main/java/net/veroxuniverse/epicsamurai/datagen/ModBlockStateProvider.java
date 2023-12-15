package net.veroxuniverse.epicsamurai.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EpicSamuraiMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem((DeferredBlock<Block>) BlocksRegistry.SPIRIT_STONE);
        stairsBlock(BlocksRegistry.SPIRIT_STONE_STAIRS.get(), blockTexture(BlocksRegistry.SPIRIT_STONE.get()));
        slabBlock(BlocksRegistry.SPIRIT_STONE_SLAB.get(), blockTexture(BlocksRegistry.SPIRIT_STONE.get()), blockTexture(BlocksRegistry.SPIRIT_STONE.get()));
        wallBlock((WallBlock) BlocksRegistry.SPIRIT_STONE_WALL.get(), blockTexture(BlocksRegistry.SPIRIT_STONE.get()));

        blockItem(BlocksRegistry.SPIRIT_STONE_STAIRS);
        blockItem(BlocksRegistry.SPIRIT_STONE_SLAB);

        blockWithItem((DeferredBlock<Block>) BlocksRegistry.CHISELED_SPIRIT_STONE_BRICKS);
        blockWithItem((DeferredBlock<Block>) BlocksRegistry.CHISELED_PATTERN_SPIRIT_STONE_BRICKS);
        blockWithItem((DeferredBlock<Block>) BlocksRegistry.MOSAIC_SPIRIT_STONE_BRICKS);

        blockWithItem((DeferredBlock<Block>) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS);
        stairsBlock((StairBlock) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS.get(), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB.get()), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()));
        wallBlock((WallBlock) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL.get(), blockTexture(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get()));

        blockItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS);
        blockItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB);


        blockWithItem((DeferredBlock<Block>) BlocksRegistry.PATH_SPIRIT_STONE_BRICKS);
        blockWithItem((DeferredBlock<Block>) BlocksRegistry.PATTERN_MOSSY_SPIRIT_STONE_BRICKS);
        blockWithItem((DeferredBlock<Block>) BlocksRegistry.PATTERN_SPIRIT_STONE_BRICKS);

        blockWithItem((DeferredBlock<Block>) BlocksRegistry.POLISHED_SPIRIT_STONE);
        stairsBlock((StairBlock) BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS.get(), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()));
        slabBlock(((SlabBlock) BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB.get()), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()));
        wallBlock((WallBlock) BlocksRegistry.POLISHED_SPIRIT_STONE_WALL.get(), blockTexture(BlocksRegistry.POLISHED_SPIRIT_STONE.get()));

        blockItem(BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS);
        blockItem(BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB);
    }


    private void blockItem(DeferredHolder<Block, ?> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("epicsamurai:block/" + BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath()) {
        });
    }

    private void blockWithItem(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}