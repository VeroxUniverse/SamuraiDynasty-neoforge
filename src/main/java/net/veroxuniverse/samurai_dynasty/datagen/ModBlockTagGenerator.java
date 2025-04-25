package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SamuraiDynastyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlocksRegistry.SPIRIT_BLOSSOM_LOG.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_LOG.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_WOOD.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_WOOD_LOG.get())
                .add(BlocksRegistry.SPIRIT_WOOD_LOG.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_WOOD.get())
                .add(BlocksRegistry.SPIRIT_WOOD.get())
                .add(BlocksRegistry.SPIRIT_WOOD_BRANCH.get())
                .add(BlocksRegistry.SPIRIT_WOOD_ROOTS.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_BRANCH.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_ROOTS.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())
                .add(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())
                .add(BlocksRegistry.SPIRIT_WOOD_FENCE.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_FENCE.get())
                .add(BlocksRegistry.SPIRIT_WOOD_FENCE_GATE.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_FENCE_GATE.get())
                .add(BlocksRegistry.SPIRIT_WOOD_DOOR.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_DOOR.get())
                .add(BlocksRegistry.SPIRIT_WOOD_TRAPDOOR.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_TRAPDOOR.get())
                .add(BlocksRegistry.SPIRIT_WOOD_SLAB.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_SLAB.get())
                .add(BlocksRegistry.SPIRIT_WOOD_STAIRS.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_STAIRS.get())
                .add(BlocksRegistry.SPIRIT_WOOD_BUTTON.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_BUTTON.get())
                .add(BlocksRegistry.SPIRIT_WOOD_PRESSURE_PLATE.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_PRESSURE_PLATE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlocksRegistry.SPIRIT_MOSS_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlocksRegistry.SPIRIT_STONE.get(),
                        BlocksRegistry.JADE_ORE.get(),
                        BlocksRegistry.DEEPSLATE_JADE_ORE.get(),
                        BlocksRegistry.JADE_BLOCK.get(),
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
                        BlocksRegistry.STONE_ROOF_CORNER.get(),
                        BlocksRegistry.DEEPSLATE_LAMP.get(),
                        BlocksRegistry.DIORITE_LAMP.get(),
                        BlocksRegistry.STONE_LAMP.get(),
                        BlocksRegistry.GRANITE_LAMP.get(),
                        BlocksRegistry.ANDESITE_LAMP.get(),
                        BlocksRegistry.SPIRIT_LAMP.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlocksRegistry.SPIRIT_STONE.get(),
                        BlocksRegistry.JADE_ORE.get(),
                        BlocksRegistry.DEEPSLATE_JADE_ORE.get(),
                        BlocksRegistry.JADE_BLOCK.get(),
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

        this.tag(BlockTags.DIRT)
                .add(BlocksRegistry.SPIRIT_MOSS_BLOCK.get());

        this.tag(BlockTags.LEAVES)
                .add(BlocksRegistry.SPIRIT_WOOD_LEAVES.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_LEAVES.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BlocksRegistry.SPIRIT_BLOSSOM_LOG.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_LOG.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_WOOD.get())
                .add(BlocksRegistry.SPIRIT_WOOD_LOG.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_WOOD_LOG.get())
                .add(BlocksRegistry.SPIRIT_WOOD.get())
                .add(BlocksRegistry.STRIPPED_SPIRIT_WOOD.get());

        this.tag(BlockTags.FENCES)
                .add(BlocksRegistry.SPIRIT_WOOD_FENCE.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_FENCE.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(BlocksRegistry.SPIRIT_WOOD_FENCE.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(BlocksRegistry.SPIRIT_WOOD_FENCE_GATE.get())
                .add(BlocksRegistry.SPIRIT_BLOSSOM_FENCE_GATE.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
