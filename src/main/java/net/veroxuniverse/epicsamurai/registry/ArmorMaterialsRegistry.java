package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.compat.CreateCompat;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ArmorMaterialsRegistry implements ArmorMaterial {

    SAMURAI_RUBY("samurai_ruby", 33, new int[]{3, 6, 8, 2}, 25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.RUBY.get())),

    SAMURAI_ONYX("samurai_onyx", 33, new int[]{3, 6, 8, 2}, 25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.ONYX.get())),

    SAMURAI_AQUA("samurai_aqua", 33, new int[]{3, 6, 8, 2}, 25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.AQUAMARINE.get())),

    SAMURAI_JADE("samurai_jade", 33, new int[]{3, 6, 8, 2}, 25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.JADE.get())),

    SAMURAI_SILVER("samurai_silver", 20, new int[]{2, 5, 6, 2}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.SILVER_INGOT.get())),

    SAMURAI_DIAMOND("samurai_diamond", 33, new int[]{3, 6, 8, 2}, 12,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(Items.DIAMOND)),

    SAMURAI_BRASS("samurai_brass", 33, new int[]{3, 6, 8, 2}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F,
            () -> Ingredient.of(CreateCompat.BRASS_REPAIR_KIT.get())),

    SAMURAI_NETHERITE("samurai_netherite", 45, new int[]{3, 6, 8, 3}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT)),

    SAMURAI_SCULK("samurai_sculk", 55, new int[]{3, 6, 8, 3}, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.5F,
            () -> Ingredient.of(Items.ECHO_SHARD)),

    SAMURAI_AMETHYST("samurai_amethyst", 35, new int[]{3, 6, 8, 3}, 25,
            SoundEvents.AMETHYST_CLUSTER_PLACE, 2.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.AMETHYST_INGOT.get())),

    SAMURAI_QUARTZ("samurai_quartz", 35, new int[]{3, 6, 8, 3}, 25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.QUARTZ_INGOT.get())),

    SAMURAI_GOLD("samurai_gold", 15, new int[]{2, 4, 5, 2}, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 0.5F, 0.0F,
            () -> Ingredient.of(Items.GOLD_INGOT)),

    SAMURAI_IRON("samurai_iron",20, new int[]{2, 5, 6, 2}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),


    STEEL("steel", 29, new int[]{3, 5, 7, 2}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get())),

    STRAW("straw", 15, new int[]{1, 1, 1, 1}, 7,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0.5F, 0.0F,
            () -> Ingredient.of(Items.WHEAT));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ArmorMaterialsRegistry(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                           SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public @NotNull String getName() {
        return EpicSamuraiMod.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}