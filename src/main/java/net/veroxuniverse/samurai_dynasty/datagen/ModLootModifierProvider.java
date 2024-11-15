package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.datagen.loot.ModLootModifier;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;

import java.util.concurrent.CompletableFuture;

public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SamuraiDynastyMod.MOD_ID);
    }

    @Override
    protected void start() {

        add("spirit_template_from_jungle_temple", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.40f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/jungle_temple")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_desert_pyramid", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.40f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/desert_pyramid")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_simple_dungeon", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.2f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/simple_dungeon")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_fortress", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.5f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/nether_bridge")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion1", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/bastion_bridge")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion2", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/bastion_treasure")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion3", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/bastion_other")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion4", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/bastion_hoglin_stable")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_ruined_portal", new ModLootModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/ruined_portal")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

    }
}