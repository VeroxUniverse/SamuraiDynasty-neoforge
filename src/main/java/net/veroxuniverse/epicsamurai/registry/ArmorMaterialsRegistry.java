package net.veroxuniverse.epicsamurai.registry;

import com.google.common.base.Suppliers;
import com.stal111.forbidden_arcanus.core.init.ModItems;
import com.teammetallurgy.aquaculture.init.AquaItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fml.ModList;
import net.veroxuniverse.epicsamurai.compat.CreateCompat;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmorMaterialsRegistry implements ArmorMaterial {

    NINJA_GOLD("ninja_gold", 15,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 1);
        armor.put(ArmorItem.Type.LEGGINGS, 2);
        armor.put(ArmorItem.Type.CHESTPLATE, 4);
        armor.put(ArmorItem.Type.HELMET, 1);
    }), 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F,
            () -> Ingredient.of(Items.GOLD_INGOT)),

    NINJA_IRON("ninja_iron", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 3);
        armor.put(ArmorItem.Type.CHESTPLATE, 5);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),

    NINJA_DIAMOND("ninja_diamond", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 4);
        armor.put(ArmorItem.Type.CHESTPLATE, 7);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(Items.DIAMOND)),

    NINJA_STEEL("ninja_steel", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 3);
        armor.put(ArmorItem.Type.CHESTPLATE, 6);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get())),

    NINJA_NETHERITE("ninja_netherite", 45,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT)),

    SAMURAI_RUBY("samurai_ruby", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.RUBY.get())),

    SAMURAI_RUBY_MASTER("samurai_ruby_master", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.RUBY.get())),

    SAMURAI_ONYX("samurai_onyx", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.ONYX.get())),

    SAMURAI_ONYX_MASTER("samurai_onyx_master", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.ONYX.get())),

    SAMURAI_AQUA("samurai_aqua", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.AQUAMARINE.get())),

    SAMURAI_AQUA_MASTER("samurai_aqua_master", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.AQUAMARINE.get())),

    SAMURAI_JADE("samurai_jade", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.JADE.get())),

    SAMURAI_JADE_MASTER("samurai_jade_master", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.JADE.get())),

    SAMURAI_DIAMOND("samurai_diamond", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F,
            () -> Ingredient.of(Items.DIAMOND)),

    SAMURAI_DIAMOND_MASTER("samurai_diamond_master", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F,
            () -> Ingredient.of(Items.DIAMOND)),

    SAMURAI_SILVER("samurai_silver", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 5);
        armor.put(ArmorItem.Type.CHESTPLATE, 6);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.SILVER_INGOT.get())),

    SAMURAI_SILVER_MASTER("samurai_silver_master", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 5);
        armor.put(ArmorItem.Type.CHESTPLATE, 6);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.SILVER_INGOT.get())),

    SAMURAI_BRASS("samurai_brass", 33,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F,
            () -> Ingredient.of(CreateCompat.BRASS_REPAIR_KIT.get())),


    SAMURAI_NETHERITE("samurai_netherite", 45,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT)),

    SAMURAI_NETHERITE_MASTER("samurai_netherite_master", 45,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT)),


    SAMURAI_SCULK("samurai_sculk", 45,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 4);
        armor.put(ArmorItem.Type.LEGGINGS, 7);
        armor.put(ArmorItem.Type.CHESTPLATE, 9);
        armor.put(ArmorItem.Type.HELMET, 4);
    }), 25, SoundEvents.SCULK_BLOCK_PLACE, 4.0F, 0.1F,
            () -> Ingredient.of(Items.ECHO_SHARD)),

    SAMURAI_AMETHYST("samurai_amethyst", 35,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.AMETHYST_CLUSTER_PLACE, 2.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.AMETHYST_INGOT.get())),

    SAMURAI_NEPTUN("samurai_neptun", 35,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.0F,
            () -> {
        if (ModList.get().isLoaded("aquaculture")) {
            return Ingredient.of(AquaItems.NEPTUNIUM_INGOT.get());
        } else {
            return Ingredient.of(Items.HEART_OF_THE_SEA);
        }
    }),

    SAMURAI_ETYRITE("samurai_etyrite", 35,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(Items.NETHERITE_INGOT)),

    SAMURAI_QUARTZ("samurai_quartz", 35,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 6);
        armor.put(ArmorItem.Type.CHESTPLATE, 8);
        armor.put(ArmorItem.Type.HELMET, 3);
    }), 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.QUARTZ_INGOT.get())),

    SAMURAI_GOLD("samurai_gold", 15,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 4);
        armor.put(ArmorItem.Type.CHESTPLATE, 5);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.5F, 0.0F,
            () -> Ingredient.of(Items.GOLD_INGOT)),

    SAMURAI_GOLD_MASTER("samurai_gold_master", 15,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 4);
        armor.put(ArmorItem.Type.CHESTPLATE, 5);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F,
            () -> Ingredient.of(Items.GOLD_INGOT)),

    SAMURAI_IRON("samurai_iron", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 5);
        armor.put(ArmorItem.Type.CHESTPLATE, 6);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),

    SAMURAI_IRON_MASTER("samurai_iron_master", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 2);
        armor.put(ArmorItem.Type.LEGGINGS, 5);
        armor.put(ArmorItem.Type.CHESTPLATE, 6);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT)),

    SAMURAI_STEEL("samurai_steel", 20,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 3);
        armor.put(ArmorItem.Type.LEGGINGS, 5);
        armor.put(ArmorItem.Type.CHESTPLATE, 7);
        armor.put(ArmorItem.Type.HELMET, 2);
    }), 12, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get())),

    STRAW("straw", 15,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 1);
        armor.put(ArmorItem.Type.LEGGINGS, 1);
        armor.put(ArmorItem.Type.CHESTPLATE, 1);
        armor.put(ArmorItem.Type.HELMET, 1);
    }), 7, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(Items.WHEAT)),

    SAMURAI_TYR("samurai_tyr", 50,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 8);
        armor.put(ArmorItem.Type.LEGGINGS, 10);
        armor.put(ArmorItem.Type.CHESTPLATE, 12);
        armor.put(ArmorItem.Type.HELMET, 7);
    }), 25, SoundEvents.ARMOR_EQUIP_IRON, 4.0F, 0.2F,
            () -> {
                if (ModList.get().isLoaded("forbidden_arcanus")) {
                    return Ingredient.of(ModItems.AQUATIC_DRAGON_SCALE.get());
                } else {
                    return Ingredient.of(Items.GOLD_INGOT);
                }
            }),

    SAMURAI_DRACO("samurai_draco", 40,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 6);
        armor.put(ArmorItem.Type.LEGGINGS, 8);
        armor.put(ArmorItem.Type.CHESTPLATE, 10);
        armor.put(ArmorItem.Type.HELMET, 6);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.1F,
            () -> {
                if (ModList.get().isLoaded("forbidden_arcanus")) {
                    return Ingredient.of(ModItems.DRAGON_SCALE.get());
                } else {
                    return Ingredient.of(Items.GOLD_INGOT);
                }
            }),


    CLOTH("cloth", 15,Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
        armor.put(ArmorItem.Type.BOOTS, 1);
        armor.put(ArmorItem.Type.LEGGINGS, 2);
        armor.put(ArmorItem.Type.CHESTPLATE, 3);
        armor.put(ArmorItem.Type.HELMET, 1);
    }), 12, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F,
            () -> Ingredient.of(ItemsRegistry.CLOTH.get()));

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ArmorMaterialsRegistry(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protection, int enchantmentValue, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protection;
        this.enchantmentValue = enchantmentValue;
            this.sound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurabilityForType(ArmorItem.@NotNull Type typeDurability) {
        return HEALTH_FUNCTION_FOR_TYPE.get(typeDurability) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.@NotNull Type typeDefense) {
        return this.protectionFunctionForType.get(typeDefense);
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
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return this.name;
    }
}