package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.block.*;
import net.veroxuniverse.samurai_dynasty.utils.ModTags;
import net.veroxuniverse.samurai_dynasty.worldgen.ModTreeGrowers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlocksRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SamuraiDynastyMod.MOD_ID);

    public static final DeferredBlock<Block> JADE_ORE = registerBlock("jade_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE = registerBlock("spirit_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE_BRICKS = registerBlock("spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_STONE_BRICKS_STAIRS = registerBlock("spirit_stone_bricks_stairs",
            () -> new StairBlock(BlocksRegistry.SPIRIT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)
                            .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_STONE_BRICKS_SLAB = registerBlock("spirit_stone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_STONE_BRICKS_WALL = registerBlock("spirit_stone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL)));
    public static final DeferredBlock<Block> MOSSY_SPIRIT_STONE_BRICKS = registerBlock("mossy_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOSSY_SPIRIT_STONE_BRICK_STAIRS = registerBlock("mossy_spirit_stone_brick_stairs",
            () -> new StairBlock(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)
                            .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOSSY_SPIRIT_STONE_BRICK_SLAB = registerBlock("mossy_spirit_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOSSY_SPIRIT_STONE_BRICK_WALL = registerBlock("mossy_spirit_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL)));
    public static final DeferredBlock<Block> DRAGON_SPIRIT_STONE = registerBlock("dragon_spirit_stone",
            () -> new DragonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_SPIRIT_STONE = registerBlock("polished_spirit_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_SPIRIT_STONE_STAIRS = registerBlock("polished_spirit_stone_stairs",
            () -> new StairBlock(BlocksRegistry.POLISHED_SPIRIT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)
                            .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_SPIRIT_STONE_SLAB = registerBlock("polished_spirit_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> POLISHED_SPIRIT_STONE_WALL = registerBlock("polished_spirit_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL)));
    public static final DeferredBlock<Block> CHISELED_SPIRIT_STONE_BRICKS = registerBlock("chiseled_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CHISELED_PATTERN_SPIRIT_STONE_BRICKS = registerBlock("chiseled_pattern_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOSAIC_SPIRIT_STONE_BRICKS = registerBlock("mosaic_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> PATTERN_SPIRIT_STONE_BRICKS = registerBlock("pattern_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> PATTERN_MOSSY_SPIRIT_STONE_BRICKS = registerBlock("pattern_mossy_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> PATH_SPIRIT_STONE_BRICKS = registerBlock("path_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));

    //* WORK IN PROGRESS *//

    public static final DeferredBlock<Block> TANUKI_STATUE = registerBlock("tanuki_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> KOMAINU_STATUE = registerBlock("komainu_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> KAWAUSO_STATUE = registerBlock("kawauso_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE_ROOF = registerBlock("spirit_stone_roof",
            () -> new RoofSlopeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE_ROOF_TOP = registerBlock("spirit_stone_roof_top",
            () -> new RoofTopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE_ROOF_TIP = registerBlock("spirit_stone_roof_tip",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACKSTONE_ROOF = registerBlock("blackstone_roof",
            () -> new RoofSlopeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACKSTONE_ROOF_TOP = registerBlock("blackstone_roof_top",
            () -> new RoofTopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACKSTONE_ROOF_TIP = registerBlock("blackstone_roof_tip",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ROOF = registerBlock("deepslate_roof",
            () -> new RoofSlopeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ROOF_TOP = registerBlock("deepslate_roof_top",
            () -> new RoofTopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_ROOF_TIP = registerBlock("deepslate_roof_tip",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MUD_BRICKS_ROOF = registerBlock("mud_bricks_roof",
            () -> new RoofSlopeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MUD_BRICKS_ROOF_TOP = registerBlock("mud_bricks_roof_top",
            () -> new RoofTopBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MUD_BRICKS_ROOF_TIP = registerBlock("mud_bricks_roof_tip",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_LAMP = registerBlock("spirit_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(p_152607_ -> 14)));

    public static final DeferredBlock<Block> STONE_LAMP = registerBlock("stone_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(p_152607_ -> 14)));

    public static final DeferredBlock<Block> ANDESITE_LAMP = registerBlock("andesite_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(p_152607_ -> 14)));

    public static final DeferredBlock<Block> DIORITE_LAMP = registerBlock("diorite_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(p_152607_ -> 14)));

    public static final DeferredBlock<Block> GRANITE_LAMP = registerBlock("granite_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(p_152607_ -> 14)));

    public static final DeferredBlock<Block> DEEPSLATE_LAMP = registerBlock("deepslate_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel(p_152607_ -> 14)));


    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_LOG = registerBlock("spirit_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_SPIRIT_BLOSSOM_LOG = registerBlock("stripped_spirit_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_WOOD = registerBlock("spirit_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_SPIRIT_BLOSSOM_WOOD = registerBlock("stripped_spirit_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_PLANKS = registerBlock("spirit_blossom_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_STAIRS = registerBlock("spirit_blossom_stairs",
            () -> new StairBlock(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_SLAB = registerBlock("spirit_blossom_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_FENCE = registerBlock("spirit_blossom_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_FENCE_GATE = registerBlock("spirit_blossom_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_BUTTON = registerBlock("spirit_blossom_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_PRESSURE_PLATE = registerBlock("spirit_blossom_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_DOOR = registerBlock("spirit_blossom_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_TRAPDOOR = registerBlock("spirit_blossom_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_LEAVES = registerBlock("spirit_blossom_leaves",
            () -> new SpiritBlossomLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_SAPLING = registerBlock("spirit_blossom_sapling",
            () -> new SaplingBlock(ModTreeGrowers.SPIRIT_BLOSSOM_TREE_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_ROOTS = registerBlock("spirit_blossom_roots",
            () -> new ModHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> SPIRIT_BLOSSOM_BRANCH = registerBlock("spirit_blossom_branch",
            () -> new ModHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).noOcclusion().noCollission()));


    public static final DeferredBlock<Block> SPIRIT_MOSS_BLOCK = registerBlock("spirit_moss_block",
            () -> new MossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK)
                    .strength(0.2f)));

    public static final DeferredBlock<Block> SPIDER_LILLY = registerBlock("spider_lilly",
            () -> new FlowerBlock(MobEffects.POISON, 2, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)));
    public static final DeferredBlock<Block> POTTED_SPIDER_LILLY = registerBlockWithoutItem("potted_spider_lilly",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), SPIDER_LILLY, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final DeferredBlock<Block> TWISTTHORN_PETALS = registerBlock("twistthorn_petals",
            () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_CARPET)
                    .strength(4f).noOcclusion().instabreak()));

    public static final DeferredBlock<Block> TWISTTHORN_LOG = registerBlock("twistthorn_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_TWISTTHORN_LOG = registerBlock("stripped_twistthorn_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> TWISTTHORN_WOOD = registerBlock("twistthorn_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_TWISTTHORN_WOOD = registerBlock("stripped_twistthorn_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> TWISTTHORN_PLANKS = registerBlock("twistthorn_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> TWISTTHORN_STAIRS = registerBlock("twistthorn_stairs",
            () -> new StairBlock(BlocksRegistry.TWISTTHORN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TWISTTHORN_SLAB = registerBlock("twistthorn_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TWISTTHORN_FENCE = registerBlock("twistthorn_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TWISTTHORN_FENCE_GATE = registerBlock("twistthorn_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TWISTTHORN_BUTTON = registerBlock("twistthorn_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()));
    public static final DeferredBlock<Block> TWISTTHORN_PRESSURE_PLATE = registerBlock("twistthorn_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TWISTTHORN_DOOR = registerBlock("twistthorn_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> TWISTTHORN_TRAPDOOR = registerBlock("twistthorn_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TWISTTHORN_LEAVES = registerBlock("twistthorn_leaves",
            () -> new ThwistthornLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> TWISTTHORN_SAPLING = registerBlock("twistthorn_sapling",
            () -> new SaplingBlock(ModTreeGrowers.TWISTTHORN_TREE_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> TWISTTHORN_ROOTS = registerBlock("twistthorn_roots",
            () -> new ModHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> TWISTTHORN_BRANCH = registerBlock("twistthorn_branch",
            () -> new ModHorizontalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).noOcclusion().noCollission()));

    public static final DeferredBlock<Block> CLOUD = registerBlockWithoutItem("cloud",
            () -> new CloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).dynamicShape().mapColor(MapColor.WOOL).noOcclusion()));

    public record FenceMaterial(String name, Supplier<Block> planks) {
    }

    public static final List<FenceMaterial> FENCE_MATERIALS = List.of(
            new FenceMaterial("oak", () -> Blocks.OAK_PLANKS),
            new FenceMaterial("spruce", () -> Blocks.SPRUCE_PLANKS),
            new FenceMaterial("birch", () -> Blocks.BIRCH_PLANKS),
            new FenceMaterial("jungle", () -> Blocks.JUNGLE_PLANKS),
            new FenceMaterial("acacia", () -> Blocks.ACACIA_PLANKS),
            new FenceMaterial("dark_oak", () -> Blocks.DARK_OAK_PLANKS),
            new FenceMaterial("mangrove", () -> Blocks.MANGROVE_PLANKS),
            new FenceMaterial("cherry", () -> Blocks.CHERRY_PLANKS),
            new FenceMaterial("bamboo", () -> Blocks.BAMBOO_PLANKS),
            new FenceMaterial("crimson", () -> Blocks.CRIMSON_PLANKS),
            new FenceMaterial("warped", () -> Blocks.WARPED_PLANKS),
            new FenceMaterial("twistthorn", () -> TWISTTHORN_PLANKS.get()),
            new FenceMaterial("spirit_blossom", () -> SPIRIT_BLOSSOM_PLANKS.get())
    );

    public static final Map<String, DeferredBlock<Block>> GRATED_FENCES = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> GILDED_FENCES = new LinkedHashMap<>();

    static {
        for (FenceMaterial material : FENCE_MATERIALS) {
            GRATED_FENCES.put(material.name(), registerBlock(material.name() + "_grated_fence",
                    () -> new FamilyFenceBlock(ModTags.GRATED_FENCES, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).requiresCorrectToolForDrops())));
            GILDED_FENCES.put(material.name(), registerBlock(material.name() + "_gilded_fence",
                    () -> new FamilyFenceBlock(ModTags.GILDED_FENCES, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).requiresCorrectToolForDrops())));
        }
    }

    ok warped und crimson braucht die sounds wie auch bamboo und bamboo scheint eine andere textur für die fences zu
    nehmen heißt für bamboo muss ich das model manuell setzen. und fences verbinden sich ja für gewöhnlich mit
    vollen blöcken und fence gates.

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return state -> state.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemsRegistry.ITEMS_BUILDING.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}