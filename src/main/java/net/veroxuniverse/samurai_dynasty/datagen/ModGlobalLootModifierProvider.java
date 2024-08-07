package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.veroxuniverse.samurai_dynasty.datagen.loot.AddItemModifier;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, SamuraiDynastyMod.MOD_ID);
    }

    @Override
    protected void start() {

        add("spirit_template_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.40f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.40f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_simple_dungeon", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.2f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_fortress", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.5f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion1", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_bridge")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion2", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion3", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_other")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_nether_bastion4", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_hoglin_stable")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

        add("spirit_template_from_ruined_portal", new AddItemModifier(new LootItemCondition[] {
                LootItemRandomChanceCondition.randomChance(0.75f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build() },
                ItemsRegistry.SPIRIT_UPGRADE_SMITHING_TMEPLATE.get()));

    }
}