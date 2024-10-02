package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

import java.util.EnumMap;
import java.util.List;

public class ArmorMaterialsRegistry{
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            net.neoforged.neoforge.registries.DeferredRegister.create(Registries.ARMOR_MATERIAL, SamuraiDynastyMod.MOD_ID);

    public static final Holder<ArmorMaterial> NINJA_STEEL =
            ARMOR_MATERIALS.register("ninja_steel", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), armor -> {
                        armor.put(ArmorItem.Type.BOOTS, 2);
                        armor.put(ArmorItem.Type.LEGGINGS, 3);
                        armor.put(ArmorItem.Type.CHESTPLATE, 6);
                        armor.put(ArmorItem.Type.HELMET, 2);
                    }), 12, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "ninja_steel"))),
                    0.5F, 0.0F));

    public static final Holder<ArmorMaterial> NINJA_NETHERITE =
            ARMOR_MATERIALS.register("ninja_netherite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), armor -> {
                        armor.put(ArmorItem.Type.BOOTS, 3);
                        armor.put(ArmorItem.Type.LEGGINGS, 6);
                        armor.put(ArmorItem.Type.CHESTPLATE, 8);
                        armor.put(ArmorItem.Type.HELMET, 3);
                    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Items.NETHERITE_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "ninja_netherite"))),
                    3.0F, 0.1F));

    public static final Holder<ArmorMaterial> SAMURAI_STEEL =
            ARMOR_MATERIALS.register("samurai_steel", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), armor -> {
                        armor.put(ArmorItem.Type.BOOTS, 3);
                        armor.put(ArmorItem.Type.LEGGINGS, 5);
                        armor.put(ArmorItem.Type.CHESTPLATE, 7);
                        armor.put(ArmorItem.Type.HELMET, 2);
                    }), 12, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get()),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "samurai_steel"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "samurai_steel"), "_overlay", true)),
                    0.5F, 0.0F));

    public static final Holder<ArmorMaterial> SAMURAI_NETHERITE =
            ARMOR_MATERIALS.register("samurai_netherite", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), armor -> {
                        armor.put(ArmorItem.Type.BOOTS, 3);
                        armor.put(ArmorItem.Type.LEGGINGS, 6);
                        armor.put(ArmorItem.Type.CHESTPLATE, 8);
                        armor.put(ArmorItem.Type.HELMET, 3);
                    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Items.NETHERITE_INGOT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "samurai_netherite"))),
                    3.0F, 0.1F));

    public static final Holder<ArmorMaterial> STRAW =
            ARMOR_MATERIALS.register("straw", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), armor -> {
                        armor.put(ArmorItem.Type.BOOTS, 1);
                        armor.put(ArmorItem.Type.LEGGINGS, 1);
                        armor.put(ArmorItem.Type.CHESTPLATE, 1);
                        armor.put(ArmorItem.Type.HELMET, 1);
                    }), 7, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.WHEAT),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "straw"))),
                    0.0F, 0.0F));

    public static final Holder<ArmorMaterial> CLOTH =
            ARMOR_MATERIALS.register("cloth", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), armor -> {
                        armor.put(ArmorItem.Type.BOOTS, 1);
                        armor.put(ArmorItem.Type.LEGGINGS, 2);
                        armor.put(ArmorItem.Type.CHESTPLATE, 3);
                        armor.put(ArmorItem.Type.HELMET, 1);
                    }), 12, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(ItemsRegistry.CLOTH.get()),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "cloth"))),
                    0.0F, 0.0F));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}