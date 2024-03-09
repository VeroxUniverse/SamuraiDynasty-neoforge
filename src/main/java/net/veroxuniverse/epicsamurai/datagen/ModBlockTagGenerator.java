package net.veroxuniverse.epicsamurai.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EpicSamuraiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlocksRegistry.SPIRIT_STONE.get(),
                        BlocksRegistry.RUBY_ORE.get(),
                        BlocksRegistry.DEEPSLATE_RUBY_ORE.get(),
                        BlocksRegistry.RUBY_BLOCK.get(),
                        BlocksRegistry.AQUAMARINE_ORE.get(),
                        BlocksRegistry.DEEPSLATE_AQUAMARINE_ORE.get(),
                        BlocksRegistry.AQUAMARINE_BLOCK.get(),
                        BlocksRegistry.JADE_ORE.get(),
                        BlocksRegistry.DEEPSLATE_JADE_ORE.get(),
                        BlocksRegistry.JADE_BLOCK.get(),
                        BlocksRegistry.ONYX_ORE.get(),
                        BlocksRegistry.DEEPSLATE_ONYX_ORE.get(),
                        BlocksRegistry.ONYX_BLOCK.get(),
                        BlocksRegistry.SILVER_ORE.get(),
                        BlocksRegistry.DEEPSLATE_SILVER_ORE.get(),
                        BlocksRegistry.SILVER_BLOCK.get(),
                        BlocksRegistry.STEEL_BLOCK.get(),
                        BlocksRegistry.SPIRIT_STONE_WALL.get(),
                        BlocksRegistry.SPIRIT_STONE_SLAB.get(),
                        BlocksRegistry.SPIRIT_STONE_STAIRS.get(),
                        BlocksRegistry.CHISELED_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.CHISELED_PATTERN_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.MOSAIC_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.PATH_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.PATTERN_MOSSY_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.PATTERN_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_WALL.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS.get(),
                        BlocksRegistry.DRAGON_SPIRIT_STONE.get(),
                        BlocksRegistry.SPIRIT_STONE_BASE.get(),
                        BlocksRegistry.TANUKI_STATUE.get(),
                        BlocksRegistry.KOMAINU_STATUE.get(),
                        BlocksRegistry.KAWAUSO_STATUE.get(),
                        BlocksRegistry.STONE_ROOF.get(),
                        BlocksRegistry.STONE_ROOF_TOP.get(),
                        BlocksRegistry.STONE_ROOF_CORNER.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlocksRegistry.SPIRIT_STONE.get(),
                        BlocksRegistry.RUBY_ORE.get(),
                        BlocksRegistry.DEEPSLATE_RUBY_ORE.get(),
                        BlocksRegistry.RUBY_BLOCK.get(),
                        BlocksRegistry.AQUAMARINE_ORE.get(),
                        BlocksRegistry.DEEPSLATE_AQUAMARINE_ORE.get(),
                        BlocksRegistry.AQUAMARINE_BLOCK.get(),
                        BlocksRegistry.JADE_ORE.get(),
                        BlocksRegistry.DEEPSLATE_JADE_ORE.get(),
                        BlocksRegistry.JADE_BLOCK.get(),
                        BlocksRegistry.ONYX_ORE.get(),
                        BlocksRegistry.DEEPSLATE_ONYX_ORE.get(),
                        BlocksRegistry.ONYX_BLOCK.get(),
                        BlocksRegistry.SILVER_ORE.get(),
                        BlocksRegistry.DEEPSLATE_SILVER_ORE.get(),
                        BlocksRegistry.SILVER_BLOCK.get(),
                        BlocksRegistry.STEEL_BLOCK.get(),
                        BlocksRegistry.SPIRIT_STONE_WALL.get(),
                        BlocksRegistry.SPIRIT_STONE_SLAB.get(),
                        BlocksRegistry.SPIRIT_STONE_STAIRS.get(),
                        BlocksRegistry.CHISELED_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.CHISELED_PATTERN_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.MOSAIC_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.PATH_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.PATTERN_MOSSY_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.PATTERN_SPIRIT_STONE_BRICKS.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_WALL.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS.get(),
                        BlocksRegistry.DRAGON_SPIRIT_STONE.get(),
                        BlocksRegistry.TANUKI_STATUE.get(),
                        BlocksRegistry.KOMAINU_STATUE.get(),
                        BlocksRegistry.KAWAUSO_STATUE.get(),
                        BlocksRegistry.STONE_ROOF.get(),
                        BlocksRegistry.STONE_ROOF_TOP.get(),
                        BlocksRegistry.SPIRIT_STONE_BASE.get(),
                        BlocksRegistry.STONE_ROOF_CORNER.get());

        this.tag(BlockTags.WALLS)
                .add(BlocksRegistry.SPIRIT_STONE_WALL.get(),
                        BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL.get(),
                        BlocksRegistry.POLISHED_SPIRIT_STONE_WALL.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
