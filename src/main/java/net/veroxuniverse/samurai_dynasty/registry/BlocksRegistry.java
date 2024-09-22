package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.block.DragonBlock;
import net.veroxuniverse.samurai_dynasty.block.RoofBlock;
import net.veroxuniverse.samurai_dynasty.block.StatueBlock;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlocksRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SamuraiDynastyMod.MOD_ID);

    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> JADE_ORE = registerBlock("jade_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ONYX_ORE = registerBlock("onyx_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_ONYX_ORE = registerBlock("deepslate_onyx_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7) ,BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ONYX_BLOCK = registerBlock("onyx_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE_BASE = registerBlock("spirit_stone_base",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SPIRIT_STONE = registerBlock("spirit_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_STONE_STAIRS = registerBlock("spirit_stone_stairs",
            () -> new StairBlock(BlocksRegistry.SPIRIT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_STONE_SLAB = registerBlock("spirit_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SPIRIT_STONE_WALL = registerBlock("spirit_stone_wall",
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

    public static final DeferredBlock<Block> STONE_ROOF = registerBlock("stone_roof",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STONE_ROOF_CORNER = registerBlock("stone_roof_corner",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STONE_ROOF_TOP = registerBlock("stone_roof_top",
            () -> new RoofBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));


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
        ItemsRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}