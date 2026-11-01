package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

import java.util.Map;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, net.neoforged.neoforge.common.data.ExistingFileHelper exFileHelper) {
        super(output, SamuraiDynastyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlocksRegistry.SPIRIT_STONE);
        blockWithItem(BlocksRegistry.SPIRIT_STONE_BRICKS);
        stairsBlock((StairBlock) BlocksRegistry.SPIRIT_STONE_BRICKS_STAIRS.get(), blockTexture(BlocksRegistry.SPIRIT_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) BlocksRegistry.SPIRIT_STONE_BRICKS_SLAB.get()), blockTexture(BlocksRegistry.SPIRIT_STONE_BRICKS.get()), blockTexture(BlocksRegistry.SPIRIT_STONE_BRICKS.get()));
        wallBlock((WallBlock) BlocksRegistry.SPIRIT_STONE_BRICKS_WALL.get(), blockTexture(BlocksRegistry.SPIRIT_STONE_BRICKS.get()));

        blockItem(BlocksRegistry.SPIRIT_STONE_BRICKS_STAIRS);
        blockItem(BlocksRegistry.SPIRIT_STONE_BRICKS_SLAB);

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

        blockWithItem(BlocksRegistry.TWISTTHORN_PLANKS);
        logBlock(((RotatedPillarBlock) BlocksRegistry.TWISTTHORN_LOG.get()));
        logBlock(((RotatedPillarBlock) BlocksRegistry.STRIPPED_TWISTTHORN_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlocksRegistry.TWISTTHORN_WOOD.get()), blockTexture(BlocksRegistry.TWISTTHORN_LOG.get()), blockTexture(BlocksRegistry.TWISTTHORN_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlocksRegistry.STRIPPED_TWISTTHORN_WOOD.get()), blockTexture(BlocksRegistry.STRIPPED_TWISTTHORN_LOG.get()), blockTexture(BlocksRegistry.STRIPPED_TWISTTHORN_LOG.get()));

        blockItem(BlocksRegistry.TWISTTHORN_LOG);
        blockItem(BlocksRegistry.STRIPPED_TWISTTHORN_LOG);
        blockItem(BlocksRegistry.TWISTTHORN_WOOD);
        blockItem(BlocksRegistry.STRIPPED_TWISTTHORN_WOOD);

        blockWithItem(BlocksRegistry.SPIRIT_MOSS_BLOCK);

        leavesBlock(BlocksRegistry.TWISTTHORN_LEAVES);
        saplingBlock(BlocksRegistry.TWISTTHORN_SAPLING);

        blockWithItem(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS);
        logBlock(((RotatedPillarBlock) BlocksRegistry.SPIRIT_BLOSSOM_LOG.get()));
        logBlock(((RotatedPillarBlock) BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_LOG.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_WOOD.get()), blockTexture(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_LOG.get()), blockTexture(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_LOG.get()));

        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_LOG);
        blockItem(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_LOG);
        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_WOOD);
        blockItem(BlocksRegistry.STRIPPED_SPIRIT_BLOSSOM_WOOD);

        leavesBlock(BlocksRegistry.SPIRIT_BLOSSOM_LEAVES);
        saplingBlock(BlocksRegistry.SPIRIT_BLOSSOM_SAPLING);

        simpleBlock(BlocksRegistry.SPIDER_LILLY.get(),
                models().cross(blockTexture(BlocksRegistry.SPIDER_LILLY.get()).getPath(), blockTexture(BlocksRegistry.SPIDER_LILLY.get())).renderType("cutout"));
        simpleBlock(BlocksRegistry.POTTED_SPIDER_LILLY.get(), models().singleTexture("potted_spider_lilly", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(BlocksRegistry.SPIDER_LILLY.get())).renderType("cutout"));

        stairsBlock(((StairBlock) BlocksRegistry.SPIRIT_BLOSSOM_STAIRS.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()));
        slabBlock(((SlabBlock) BlocksRegistry.SPIRIT_BLOSSOM_SLAB.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) BlocksRegistry.SPIRIT_BLOSSOM_PRESSURE_PLATE.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()));
        buttonBlock(((ButtonBlock) BlocksRegistry.SPIRIT_BLOSSOM_BUTTON.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()));
        fenceBlock(((FenceBlock) BlocksRegistry.SPIRIT_BLOSSOM_FENCE.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) BlocksRegistry.SPIRIT_BLOSSOM_FENCE_GATE.get()), blockTexture(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) BlocksRegistry.SPIRIT_BLOSSOM_DOOR.get()), modLoc("block/spirit_blossom_door_bottom"), modLoc("block/spirit_blossom_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) BlocksRegistry.SPIRIT_BLOSSOM_TRAPDOOR.get()), modLoc("block/spirit_blossom_trapdoor"), true, "cutout");

        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_STAIRS);
        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_SLAB);
        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_PRESSURE_PLATE);
        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_FENCE_GATE);
        blockItem(BlocksRegistry.SPIRIT_BLOSSOM_TRAPDOOR, "_bottom");

        stairsBlock(((StairBlock) BlocksRegistry.TWISTTHORN_STAIRS.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()));
        slabBlock(((SlabBlock) BlocksRegistry.TWISTTHORN_SLAB.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) BlocksRegistry.TWISTTHORN_PRESSURE_PLATE.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()));
        buttonBlock(((ButtonBlock) BlocksRegistry.TWISTTHORN_BUTTON.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()));
        fenceBlock(((FenceBlock) BlocksRegistry.TWISTTHORN_FENCE.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) BlocksRegistry.TWISTTHORN_FENCE_GATE.get()), blockTexture(BlocksRegistry.TWISTTHORN_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) BlocksRegistry.TWISTTHORN_DOOR.get()), modLoc("block/twistthorn_door_bottom"), modLoc("block/twistthorn_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) BlocksRegistry.TWISTTHORN_TRAPDOOR.get()), modLoc("block/twistthorn_trapdoor"), true, "cutout");

        blockItem(BlocksRegistry.TWISTTHORN_STAIRS);
        blockItem(BlocksRegistry.TWISTTHORN_SLAB);
        blockItem(BlocksRegistry.TWISTTHORN_PRESSURE_PLATE);
        blockItem(BlocksRegistry.TWISTTHORN_FENCE_GATE);
        blockItem(BlocksRegistry.TWISTTHORN_TRAPDOOR, "_bottom");

        //blockWithItem(BlocksRegistry.CLOUD);

        registerFenceFamily("grated_fence",
                modLoc("block/template_grated_fence_post"),
                modLoc("block/template_grated_fence_side"),
                modLoc("item/template_grated_fence_inventory"),
                BlocksRegistry.GRATED_FENCES);

        registerFenceFamily("gilded_fence",
                modLoc("block/template_gilded_fence_post"),
                modLoc("block/template_gilded_fence_side"),
                modLoc("item/template_gilded_fence_inventory"),
                BlocksRegistry.GILDED_FENCES);

    }

    private ResourceLocation planksTexture(Block planks) {
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(planks);
        return ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "block/" + id.getPath());
    }

    private void registerFenceFamily(String suffix,
                                     ResourceLocation postTemplate,
                                     ResourceLocation sideTemplate,
                                     ResourceLocation inventoryTemplate,
                                     Map<String, DeferredBlock<Block>> fences) {
        for (BlocksRegistry.FenceMaterial material : BlocksRegistry.FENCE_MATERIALS) {
            Block fence = fences.get(material.name()).get();
            ResourceLocation planks = planksTexture(material.planks().get());
            String baseName = material.name() + "_" + suffix;

            ModelFile post = models().withExistingParent(baseName + "_post", postTemplate)
                    .texture("planks", planks);
            ModelFile side = models().withExistingParent(baseName + "_side", sideTemplate)
                    .texture("planks", planks);

            getMultipartBuilder(fence)
                    .part().modelFile(post).addModel().end()
                    .part().modelFile(side).rotationY(0).uvLock(true).addModel().condition(FenceBlock.NORTH, true).end()
                    .part().modelFile(side).rotationY(90).uvLock(true).addModel().condition(FenceBlock.EAST, true).end()
                    .part().modelFile(side).rotationY(180).uvLock(true).addModel().condition(FenceBlock.SOUTH, true).end()
                    .part().modelFile(side).rotationY(270).uvLock(true).addModel().condition(FenceBlock.WEST, true).end();

            itemModels().withExistingParent(baseName, inventoryTemplate)
                    .texture("planks", planks);
        }
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

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }

}