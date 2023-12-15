package net.veroxuniverse.epicsamurai.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EpicSamuraiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        wallItem(BlocksRegistry.SPIRIT_STONE_WALL, (DeferredBlock<Block>) BlocksRegistry.SPIRIT_STONE);
        wallItem(BlocksRegistry.POLISHED_SPIRIT_STONE_WALL, (DeferredBlock<Block>) BlocksRegistry.POLISHED_SPIRIT_STONE);
        wallItem(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL, (DeferredBlock<Block>) BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS);
    }

    public void wallItem(DeferredHolder<Block, WallBlock> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(EpicSamuraiMod.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(EpicSamuraiMod.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EpicSamuraiMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}