package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.dropSelf(BlocksRegistry.CHISELED_PATTERN_SPIRIT_STONE_BRICKS.get());
        this.dropSelf(BlocksRegistry.CHISELED_SPIRIT_STONE_BRICKS.get());
        this.dropSelf(BlocksRegistry.DRAGON_SPIRIT_STONE.get());
        this.dropSelf(BlocksRegistry.JADE_BLOCK.get());
        this.dropSelf(BlocksRegistry.KAWAUSO_STATUE.get());
        this.dropSelf(BlocksRegistry.KOMAINU_STATUE.get());
        this.dropSelf(BlocksRegistry.MOSAIC_SPIRIT_STONE_BRICKS.get());
        this.dropSelf(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_SLAB.get());
        this.dropSelf(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_STAIRS.get());
        this.dropSelf(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICK_WALL.get());
        this.dropSelf(BlocksRegistry.PATH_SPIRIT_STONE_BRICKS.get());
        this.dropSelf(BlocksRegistry.PATTERN_MOSSY_SPIRIT_STONE_BRICKS.get());
        this.dropSelf(BlocksRegistry.PATTERN_SPIRIT_STONE_BRICKS.get());
        this.dropSelf(BlocksRegistry.POLISHED_SPIRIT_STONE.get());
        this.dropSelf(BlocksRegistry.POLISHED_SPIRIT_STONE_SLAB.get());
        this.dropSelf(BlocksRegistry.POLISHED_SPIRIT_STONE_STAIRS.get());
        this.dropSelf(BlocksRegistry.POLISHED_SPIRIT_STONE_WALL.get());
        this.dropSelf(BlocksRegistry.SPIRIT_STONE.get());
        this.dropSelf(BlocksRegistry.SPIRIT_STONE_BASE.get());
        this.dropSelf(BlocksRegistry.SPIRIT_STONE_SLAB.get());
        this.dropSelf(BlocksRegistry.SPIRIT_STONE_WALL.get());
        this.dropSelf(BlocksRegistry.SPIRIT_STONE_STAIRS.get());
        this.dropSelf(BlocksRegistry.STEEL_BLOCK.get());
        this.dropSelf(BlocksRegistry.STONE_ROOF.get());
        this.dropSelf(BlocksRegistry.STONE_ROOF_CORNER.get());
        this.dropSelf(BlocksRegistry.STONE_ROOF_TOP.get());
        this.dropSelf(BlocksRegistry.TANUKI_STATUE.get());
        this.dropSelf(BlocksRegistry.MOSSY_SPIRIT_STONE_BRICKS.get());

        this.dropSelf(BlocksRegistry.SPIDER_LILLY.get());
        this.add(BlocksRegistry.POTTED_SPIDER_LILLY.get(), createPotFlowerItemTable(BlocksRegistry.SPIDER_LILLY));

        this.add(BlocksRegistry.JADE_ORE.get(),
                block -> createOreDrop(BlocksRegistry.JADE_ORE.get(), ItemsRegistry.JADE.get()));
        this.add(BlocksRegistry.DEEPSLATE_JADE_ORE.get(),
                block -> createOreDrop(BlocksRegistry.DEEPSLATE_JADE_ORE.get(), ItemsRegistry.JADE.get()));
        
        this.dropSelf(BlocksRegistry.RED_MAPLE_LOG.get());
        this.dropSelf(BlocksRegistry.STRIPPED_RED_MAPLE_LOG.get());

        this.dropSelf(BlocksRegistry.RED_MAPLE_PLANKS.get());
        this.dropSelf(BlocksRegistry.RED_MAPLE_SAPLING.get());

        this.add(BlocksRegistry.RED_MAPLE_LEAVES.get(), block ->
                createLeavesDrops(block, BlocksRegistry.RED_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlocksRegistry.SPIRIT_WOOD_LOG.get());
        this.dropSelf(BlocksRegistry.STRIPPED_SPIRIT_WOOD_LOG.get());
        this.dropSelf(BlocksRegistry.SPIRIT_WOOD.get());
        this.dropSelf(BlocksRegistry.STRIPPED_SPIRIT_WOOD.get());

        this.dropSelf(BlocksRegistry.SPIRIT_WOOD_PLANKS.get());
        this.dropSelf(BlocksRegistry.SPIRIT_WOOD_LEAVES.get());

        this.dropSelf(BlocksRegistry.SPIRIT_WOOD_ROOTS.get());
        this.dropSelf(BlocksRegistry.SPIRIT_WOOD_BRANCH.get());

        /*

        this.dropSelf(BlocksRegistry.SPIRIT_WOOD_SAPLING.get());
        this.add(BlocksRegistry.SPIRIT_WOOD_LEAVES.get(), block ->
                createLeavesDrops(block, BlocksRegistry.SPIRIT_WOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

         */
        
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlocksRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}