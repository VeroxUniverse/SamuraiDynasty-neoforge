package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {
        super(output, SamuraiDynastyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        wallItem(BlocksRegistry.SPIRIT_STONE_WALL, BlocksRegistry.SPIRIT_STONE);
        wallItem(BlocksRegistry.POLISHED_SPIRIT_STONE_WALL, BlocksRegistry.POLISHED_SPIRIT_STONE);
        wallItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL, BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS);
    }

    public void flowerItem(DeferredBlock<Block> block) {
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0",  ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}