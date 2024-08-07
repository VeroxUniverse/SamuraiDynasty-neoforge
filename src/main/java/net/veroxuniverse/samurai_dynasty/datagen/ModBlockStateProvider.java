package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
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


    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("samurai_dynasty:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}