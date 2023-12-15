package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.block.DragonBlock;

public class BlocksRegistry {
    private static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK, EpicSamuraiMod.MOD_ID);

    public static final DeferredHolder<Block, DropExperienceBlock> RUBY_ORE = BLOCK_REGISTER.register("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> DEEPSLATE_RUBY_ORE = BLOCK_REGISTER.register("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> JADE_ORE = BLOCK_REGISTER.register("jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> DEEPSLATE_JADE_ORE = BLOCK_REGISTER.register("deepslate_jade_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> AQUAMARINE_ORE = BLOCK_REGISTER.register("aquamarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> DEEPSLATE_AQUAMARINE_ORE = BLOCK_REGISTER.register("deepslate_aquamarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> ONYX_ORE = BLOCK_REGISTER.register("onyx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> DEEPSLATE_ONYX_ORE = BLOCK_REGISTER.register("deepslate_onyx_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> SILVER_ORE = BLOCK_REGISTER.register("silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final DeferredHolder<Block, DropExperienceBlock> DEEPSLATE_SILVER_ORE = BLOCK_REGISTER.register("deepslate_silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final DeferredHolder<Block, Block> RUBY_BLOCK = BLOCK_REGISTER.register("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> JADE_BLOCK = BLOCK_REGISTER.register("jade_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> AQUAMARINE_BLOCK = BLOCK_REGISTER.register("aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> ONYX_BLOCK = BLOCK_REGISTER.register("onyx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> SILVER_BLOCK = BLOCK_REGISTER.register("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> STEEL_BLOCK = BLOCK_REGISTER.register("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredHolder<Block, Block> SPIRIT_STONE = BLOCK_REGISTER.register("spirit_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, StairBlock> SPIRIT_STONE_STAIRS = BLOCK_REGISTER.register("spirit_stone_stairs",
            () -> new StairBlock(() -> BlocksRegistry.SPIRIT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, SlabBlock> SPIRIT_STONE_SLAB = BLOCK_REGISTER.register("spirit_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, WallBlock> SPIRIT_STONE_WALL = BLOCK_REGISTER.register("spirit_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));
    public static final DeferredHolder<Block, Block> MOSSY_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("mossy_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, StairBlock> MOSSY_SPIRIT_STONE_BRICK_STAIRS = BLOCK_REGISTER.register("mossy_spirit_stone_brick_stairs",
            () -> new StairBlock(() -> BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
                            .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, SlabBlock> MOSSY_SPIRIT_STONE_BRICK_SLAB = BLOCK_REGISTER.register("mossy_spirit_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, WallBlock> MOSSY_SPIRIT_STONE_BRICK_WALL = BLOCK_REGISTER.register("mossy_spirit_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));
    public static final DeferredHolder<Block, DragonBlock> DRAGON_SPIRIT_STONE = BLOCK_REGISTER.register("dragon_spirit_stone",
            () -> new DragonBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> POLISHED_SPIRIT_STONE = BLOCK_REGISTER.register("polished_spirit_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, StairBlock> POLISHED_SPIRIT_STONE_STAIRS = BLOCK_REGISTER.register("polished_spirit_stone_stairs",
            () -> new StairBlock(() -> BlocksRegistry.POLISHED_SPIRIT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)
                            .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, SlabBlock> POLISHED_SPIRIT_STONE_SLAB = BLOCK_REGISTER.register("polished_spirit_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, WallBlock> POLISHED_SPIRIT_STONE_WALL = BLOCK_REGISTER.register("polished_spirit_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));
    public static final DeferredHolder<Block, Block> CHISELED_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("chiseled_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> CHISELED_PATTERN_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("chiseled_pattern_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> MOSAIC_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("mosaic_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> PATTERN_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("pattern_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> PATTERN_MOSSY_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("pattern_mossy_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredHolder<Block, Block> PATH_SPIRIT_STONE_BRICKS = BLOCK_REGISTER.register("path_spirit_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops()));

    //* WORK IN PROGRESS *//

     /*

    public static final DeferredBlock<Block> TANUKI_STATUE = BLOCK_REGISTER.register("tanuki_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> KOMAINU_STATUE = BLOCK_REGISTER.register("komainu_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> KAWAUSO_STATUE = BLOCK_REGISTER.register("kawauso_statue",
            () -> new StatueBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STONE_ROOF = BLOCK_REGISTER.register("stone_roof",
            () -> new RoofBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STONE_ROOF_CORNER = BLOCK_REGISTER.register("stone_roof_corner",
            () -> new RoofBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> STONE_ROOF_TOP = BLOCK_REGISTER.register("stone_roof_top",
            () -> new RoofBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()
                    .strength(4f).requiresCorrectToolForDrops()));

     */

    public static void register() {
        BLOCK_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}