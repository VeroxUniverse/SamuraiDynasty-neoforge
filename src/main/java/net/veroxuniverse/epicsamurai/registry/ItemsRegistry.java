package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.curios.KitsuneMaskCurios;
import net.veroxuniverse.epicsamurai.curios.OniMaskCurios;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.item.*;
import net.veroxuniverse.epicsamurai.item.armor.*;
import net.veroxuniverse.epicsamurai.item.ranged.GunItem;

@SuppressWarnings("unused")
public class ItemsRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> IRON_SAMURAI_HELMET = ITEMS.register("iron_samurai_helmet",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_CHESTPLATE = ITEMS.register("iron_samurai_chestplate",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_LEGGINGS = ITEMS.register("iron_samurai_leggings",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_BOOTS = ITEMS.register("iron_samurai_boots",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_HELMET_LIGHT = ITEMS.register("iron_samurai_helmet_light",
            () -> new IronSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("iron_samurai_chestplate_light",
            () -> new IronSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("iron_samurai_leggings_light",
            () -> new IronSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_BOOTS_LIGHT = ITEMS.register("iron_samurai_boots_light",
            () -> new IronSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_HELMET_MASTER = ITEMS.register("iron_samurai_helmet_master",
            () -> new IronSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_IRON_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("iron_samurai_chestplate_master",
            () -> new IronSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_IRON_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_LEGGINGS_MASTER = ITEMS.register("iron_samurai_leggings_master",
            () -> new IronSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_IRON_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SAMURAI_BOOTS_MASTER = ITEMS.register("iron_samurai_boots_master",
            () -> new IronSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_IRON_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> WHITE_SAMURAI_HELMET = ITEMS.register("white_samurai_helmet",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_CHESTPLATE = ITEMS.register("white_samurai_chestplate",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_LEGGINGS = ITEMS.register("white_samurai_leggings",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_BOOTS = ITEMS.register("white_samurai_boots",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_HELMET_LIGHT = ITEMS.register("white_samurai_helmet_light",
            () -> new WhiteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("white_samurai_chestplate_light",
            () -> new WhiteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("white_samurai_leggings_light",
            () -> new WhiteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_BOOTS_LIGHT = ITEMS.register("white_samurai_boots_light",
            () -> new WhiteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_HELMET_MASTER = ITEMS.register("white_samurai_helmet_master",
            () -> new WhiteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_SILVER_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("white_samurai_chestplate_master",
            () -> new WhiteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_SILVER_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_LEGGINGS_MASTER = ITEMS.register("white_samurai_leggings_master",
            () -> new WhiteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_SILVER_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_BOOTS_MASTER = ITEMS.register("white_samurai_boots_master",
            () -> new WhiteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_SILVER_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GOLD_SAMURAI_HELMET = ITEMS.register("gold_samurai_helmet",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_CHESTPLATE = ITEMS.register("gold_samurai_chestplate",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_LEGGINGS = ITEMS.register("gold_samurai_leggings",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_BOOTS = ITEMS.register("gold_samurai_boots",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_HELMET_LIGHT = ITEMS.register("gold_samurai_helmet_light",
            () -> new GoldSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("gold_samurai_chestplate_light",
            () -> new GoldSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("gold_samurai_leggings_light",
            () -> new GoldSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_BOOTS_LIGHT = ITEMS.register("gold_samurai_boots_light",
            () -> new GoldSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_HELMET_MASTER = ITEMS.register("gold_samurai_helmet_master",
            () -> new GoldSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_GOLD_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("gold_samurai_chestplate_master",
            () -> new GoldSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_GOLD_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_LEGGINGS_MASTER = ITEMS.register("gold_samurai_leggings_master",
            () -> new GoldSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_GOLD_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_BOOTS_MASTER = ITEMS.register("gold_samurai_boots_master",
            () -> new GoldSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_GOLD_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static final RegistryObject<Item> DIAMOND_SAMURAI_HELMET = ITEMS.register("diamond_samurai_helmet",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_CHESTPLATE = ITEMS.register("diamond_samurai_chestplate",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_LEGGINGS = ITEMS.register("diamond_samurai_leggings",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_BOOTS = ITEMS.register("diamond_samurai_boots",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_HELMET_LIGHT = ITEMS.register("diamond_samurai_helmet_light",
            () -> new DiamondSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("diamond_samurai_chestplate_light",
            () -> new DiamondSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("diamond_samurai_leggings_light",
            () -> new DiamondSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_BOOTS_LIGHT = ITEMS.register("diamond_samurai_boots_light",
            () -> new DiamondSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_HELMET_MASTER = ITEMS.register("diamond_samurai_helmet_master",
            () -> new DiamondSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("diamond_samurai_chestplate_master",
            () -> new DiamondSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_LEGGINGS_MASTER = ITEMS.register("diamond_samurai_leggings_master",
            () -> new DiamondSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_BOOTS_MASTER = ITEMS.register("diamond_samurai_boots_master",
            () -> new DiamondSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SAMURAI_HELMET = ITEMS.register("netherite_samurai_helmet",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_CHESTPLATE = ITEMS.register("netherite_samurai_chestplate",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_LEGGINGS = ITEMS.register("netherite_samurai_leggings",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_BOOTS = ITEMS.register("netherite_samurai_boots",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_HELMET_LIGHT = ITEMS.register("netherite_samurai_helmet_light",
            () -> new NetheriteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("netherite_samurai_chestplate_light",
            () -> new NetheriteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("netherite_samurai_leggings_light",
            () -> new NetheriteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_BOOTS_LIGHT = ITEMS.register("netherite_samurai_boots_light",
            () -> new NetheriteSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_HELMET_MASTER = ITEMS.register("netherite_samurai_helmet_master",
            () -> new NetheriteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("netherite_samurai_chestplate_master",
            () -> new NetheriteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_LEGGINGS_MASTER = ITEMS.register("netherite_samurai_leggings_master",
            () -> new NetheriteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_BOOTS_MASTER = ITEMS.register("netherite_samurai_boots_master",
            () -> new NetheriteSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_SAMURAI_HELMET = ITEMS.register("amethyst_samurai_helmet",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_CHESTPLATE = ITEMS.register("amethyst_samurai_chestplate",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_LEGGINGS = ITEMS.register("amethyst_samurai_leggings",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_BOOTS = ITEMS.register("amethyst_samurai_boots",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> QUARTZ_SAMURAI_HELMET = ITEMS.register("quartz_samurai_helmet",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_CHESTPLATE = ITEMS.register("quartz_samurai_chestplate",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_LEGGINGS = ITEMS.register("quartz_samurai_leggings",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_BOOTS = ITEMS.register("quartz_samurai_boots",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RED_SAMURAI_HELMET = ITEMS.register("red_samurai_helmet",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_CHESTPLATE = ITEMS.register("red_samurai_chestplate",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_LEGGINGS = ITEMS.register("red_samurai_leggings",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_BOOTS = ITEMS.register("red_samurai_boots",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_HELMET_LIGHT = ITEMS.register("red_samurai_helmet_light",
            () -> new RedSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("red_samurai_chestplate_light",
            () -> new RedSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("red_samurai_leggings_light",
            () -> new RedSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_BOOTS_LIGHT = ITEMS.register("red_samurai_boots_light",
            () -> new RedSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_HELMET_MASTER = ITEMS.register("red_samurai_helmet_master",
            () -> new RedSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_RUBY_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("red_samurai_chestplate_master",
            () -> new RedSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_RUBY_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_LEGGINGS_MASTER = ITEMS.register("red_samurai_leggings_master",
            () -> new RedSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_RUBY_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RED_SAMURAI_BOOTS_MASTER = ITEMS.register("red_samurai_boots_master",
            () -> new RedSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_RUBY_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> BLUE_SAMURAI_HELMET = ITEMS.register("blue_samurai_helmet",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_CHESTPLATE = ITEMS.register("blue_samurai_chestplate",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_LEGGINGS = ITEMS.register("blue_samurai_leggings",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_BOOTS = ITEMS.register("blue_samurai_boots",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_HELMET_LIGHT = ITEMS.register("blue_samurai_helmet_light",
            () -> new BlueSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("blue_samurai_chestplate_light",
            () -> new BlueSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("blue_samurai_leggings_light",
            () -> new BlueSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_BOOTS_LIGHT = ITEMS.register("blue_samurai_boots_light",
            () -> new BlueSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_HELMET_MASTER = ITEMS.register("blue_samurai_helmet_master",
            () -> new BlueSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_AQUA_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("blue_samurai_chestplate_master",
            () -> new BlueSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_AQUA_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_LEGGINGS_MASTER = ITEMS.register("blue_samurai_leggings_master",
            () -> new BlueSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_AQUA_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_BOOTS_MASTER = ITEMS.register("blue_samurai_boots_master",
            () -> new BlueSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_AQUA_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GREEN_SAMURAI_HELMET = ITEMS.register("green_samurai_helmet",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_CHESTPLATE = ITEMS.register("green_samurai_chestplate",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_LEGGINGS = ITEMS.register("green_samurai_leggings",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_BOOTS = ITEMS.register("green_samurai_boots",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_HELMET_LIGHT = ITEMS.register("green_samurai_helmet_light",
            () -> new GreenSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("green_samurai_chestplate_light",
            () -> new GreenSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("green_samurai_leggings_light",
            () -> new GreenSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_BOOTS_LIGHT = ITEMS.register("green_samurai_boots_light",
            () -> new GreenSamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_HELMET_MASTER = ITEMS.register("green_samurai_helmet_master",
            () -> new GreenSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_JADE_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("green_samurai_chestplate_master",
            () -> new GreenSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_JADE_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_LEGGINGS_MASTER = ITEMS.register("green_samurai_leggings_master",
            () -> new GreenSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_JADE_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_BOOTS_MASTER = ITEMS.register("green_samurai_boots_master",
            () -> new GreenSamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_JADE_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GRAY_SAMURAI_HELMET = ITEMS.register("gray_samurai_helmet",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_CHESTPLATE = ITEMS.register("gray_samurai_chestplate",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_LEGGINGS = ITEMS.register("gray_samurai_leggings",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_BOOTS = ITEMS.register("gray_samurai_boots",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_HELMET_LIGHT = ITEMS.register("gray_samurai_helmet_light",
            () -> new GraySamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_CHESTPLATE_LIGHT = ITEMS.register("gray_samurai_chestplate_light",
            () -> new GraySamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_LEGGINGS_LIGHT = ITEMS.register("gray_samurai_leggings_light",
            () -> new GraySamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_BOOTS_LIGHT = ITEMS.register("gray_samurai_boots_light",
            () -> new GraySamuraiArmorLightItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_HELMET_MASTER = ITEMS.register("gray_samurai_helmet_master",
            () -> new GraySamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_ONYX_MASTER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_CHESTPLATE_MASTER = ITEMS.register("gray_samurai_chestplate_master",
            () -> new GraySamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_ONYX_MASTER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_LEGGINGS_MASTER = ITEMS.register("gray_samurai_leggings_master",
            () -> new GraySamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_ONYX_MASTER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_BOOTS_MASTER = ITEMS.register("gray_samurai_boots_master",
            () -> new GraySamuraiArmorMasterItem(ArmorMaterialsRegistry.SAMURAI_ONYX_MASTER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> IRON_NINJA_HELMET = ITEMS.register("iron_ninja_helmet",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRON_NINJA_CHESTPLATE = ITEMS.register("iron_ninja_chestplate",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
   /*
    public static final RegistryObject<Item> IRON_NINJA_LEGGINGS = ITEMS.register("iron_ninja_leggings",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    */
    public static final RegistryObject<Item> IRON_NINJA_BOOTS = ITEMS.register("iron_ninja_boots",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final RegistryObject<Item> STEEL_NINJA_HELMET = ITEMS.register("steel_ninja_helmet",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NINJA_CHESTPLATE = ITEMS.register("steel_ninja_chestplate",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
     /*
    public static final RegistryObject<Item> STEEL_NINJA_LEGGINGS = ITEMS.register("steel_ninja_leggings",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
      */
    public static final RegistryObject<Item> STEEL_NINJA_BOOTS = ITEMS.register("steel_ninja_boots",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GOLD_NINJA_HELMET = ITEMS.register("gold_ninja_helmet",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_NINJA_CHESTPLATE = ITEMS.register("gold_ninja_chestplate",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
     /*
    public static final RegistryObject<Item> GOLD_NINJA_LEGGINGS = ITEMS.register("gold_ninja_leggings",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
      */
    public static final RegistryObject<Item> GOLD_NINJA_BOOTS = ITEMS.register("gold_ninja_boots",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_NINJA_HELMET = ITEMS.register("diamond_ninja_helmet",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_NINJA_CHESTPLATE = ITEMS.register("diamond_ninja_chestplate",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
     /*
    public static final RegistryObject<Item> DIAMOND_NINJA_LEGGINGS = ITEMS.register("diamond_ninja_leggings",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
      */
    public static final RegistryObject<Item> DIAMOND_NINJA_BOOTS = ITEMS.register("diamond_ninja_boots",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_NINJA_HELMET = ITEMS.register("netherite_ninja_helmet",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_NINJA_CHESTPLATE = ITEMS.register("netherite_ninja_chestplate",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    /*
    public static final RegistryObject<Item> NETHERITE_NINJA_LEGGINGS = ITEMS.register("netherite_ninja_leggings",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
     */
    public static final RegistryObject<Item> NETHERITE_NINJA_BOOTS = ITEMS.register("netherite_ninja_boots",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> NINJA_LEGGINGS = ITEMS.register("ninja_leggings",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.CLOTH, ArmorItem.Type.LEGGINGS, new Item.Properties()));


    public static final RegistryObject<Item> KIMONO = ITEMS.register("kimono",
            () -> new KimonoArmorItem(ArmorMaterialsRegistry.CLOTH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatArmorItem(ArmorMaterialsRegistry.STRAW, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> ONI_MASK = ITEMS.register("oni_mask",
            () -> new OniMaskCurios(new Item.Properties().fireResistant().stacksTo(1)));

      /*
    public static final RegistryObject<Item> ONI_MASK_WHITE = ITEMS.register("oni_mask_white",
            () -> new OniMaskWhiteCurios(new Item.Properties().fireResistant().stacksTo(1)));
    public static final RegistryObject<Item> ONI_MASK_RED = ITEMS.register("oni_mask_red",
            () -> new OniMaskRedCurios(new Item.Properties().fireResistant().stacksTo(1)));
    */

    public static final RegistryObject<Item> KITSUNE_MASK = ITEMS.register("kitsune_mask",
            () -> new KitsuneMaskCurios(new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> KNIVE_HANDLE = ITEMS.register("knive_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KATANA_HANDLE = ITEMS.register("katana_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPEAR_HANDLE = ITEMS.register("spear_handle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,1,-2.0f, new Item.Properties()));
    public static final RegistryObject<Item> WAKIZASHI = ITEMS.register("wakizashi",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,0,-1.7f, new Item.Properties()));
    public static final RegistryObject<Item> NAGINATA = ITEMS.register("naginata",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,1,-2.7f, new Item.Properties()));
    public static final RegistryObject<Item> NAGAMAKI = ITEMS.register("nagamaki",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,1,-2.6f, new Item.Properties()));
    public static final RegistryObject<Item> SHUKO = ITEMS.register("shuko",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-2,-1.5f, new Item.Properties()));
    public static final RegistryObject<Item> TETSUBO = ITEMS.register("tetsubo",
            () -> new TetsuboItem(ItemMaterialsRegistry.SAMURAI,6,-3.4f, new Item.Properties()));
    public static final RegistryObject<Item> ODACHI = ITEMS.register("odachi",
            () -> new OdachiItem(ItemMaterialsRegistry.SAMURAI,2,-2.4f, new Item.Properties()));
    public static final RegistryObject<Item> TONBUKIRI = ITEMS.register("tonbukiri",
            () -> new TonbukiriItem(ItemMaterialsRegistry.SAMURAI,1,-2.7f, new Item.Properties()));
    public static final RegistryObject<Item> KAMAYARI = ITEMS.register("kamayari",
            () -> new KamayariItem(ItemMaterialsRegistry.SAMURAI,1,-2.6f, new Item.Properties()));
    public static final RegistryObject<Item> TANEGASHIMA = ITEMS.register("tanegashima",
            () -> new GunItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet",
            () -> new BulletItem(new Item.Properties()));
    public static final RegistryObject<Item> KUNAI = ITEMS.register("kunai",
            () -> new KunaiItem(ItemMaterialsRegistry.SAMURAI,-2,-2.0f, new Item.Properties()));
    public static final RegistryObject<Item> KAMA = ITEMS.register("kama",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-2,-1.5f, new Item.Properties()));
    public static final RegistryObject<Item> SAI = ITEMS.register("sai",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-2,-1.5f, new Item.Properties()));

    public static final RegistryObject<Item> SHURIKEN = ITEMS.register("shuriken",
            () -> new ShurikenItem(new Item.Properties().stacksTo(16)));


    public static final RegistryObject<Item> KATANA_NETHERITE = ITEMS.register("katana_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> WAKIZASHI_NETHERITE = ITEMS.register("wakizashi_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,1,-1.7f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> KATANA_ONI = ITEMS.register("katana_oni",
            () -> new OniKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final RegistryObject<Item> KATANA_KITSUNE = ITEMS.register("katana_kitsune",
            () -> new KitsuneKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final RegistryObject<Item> KATANA_KITSUNE_BLUE = ITEMS.register("katana_kitsune_blue",
            () -> new KitsuneKatanaBlueItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final RegistryObject<Item> KATANA_AKANAME = ITEMS.register("katana_akaname",
            () -> new AkanameKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final RegistryObject<Item> KATANA_JOROGUMO = ITEMS.register("katana_jorogumo",
            () -> new JorogumoKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> NAGINATA_NETHERITE = ITEMS.register("naginata_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.7f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NAGAMAKI_NETHERITE = ITEMS.register("nagamaki_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.6f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SHUKO_NETHERITE = ITEMS.register("shuko_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-1.5f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TETSUBO_NETHERITE = ITEMS.register("tetsubo_netherite",
            () -> new TetsuboNetheriteItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,8,-3.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ODACHI_NETHERITE = ITEMS.register("odachi_netherite",
            () -> new OdachiNetheriteItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,3,-2.4f, new Item.Properties()));
    public static final RegistryObject<Item> TONBUKIRI_NETHERITE = ITEMS.register("tonbukiri_netherite",
            () -> new TonbukiriNetheriteItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.7f, new Item.Properties()));
    public static final RegistryObject<Item> KAMAYARI_NETHERITE = ITEMS.register("kamayari_netherite",
            () -> new KamayariNetheriteItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.6f, new Item.Properties()));
    public static final RegistryObject<Item> KUNAI_NETHERITE = ITEMS.register("kunai_netherite",
            () -> new NetheriteKunaiItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-2.0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> KAMA_NETHERITE = ITEMS.register("kama_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-1.5f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> SAI_NETHERITE = ITEMS.register("sai_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-1.5f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> AKANAME_SPAWN_EGG = ITEMS.register("akaname_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.AKANAME, 0x5e100a, 0xa88c8a,
                    new Item.Properties()));
    public static final RegistryObject<Item> ENENRA_SPAWN_EGG = ITEMS.register("enenra_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ENENRA, 0x08090a, 0xa88c8a,
                    new Item.Properties()));
    public static final RegistryObject<Item> ONI_SPAWN_EGG = ITEMS.register("oni_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ONI, 0xce1841, 0xead9ce,
                    new Item.Properties()));
    public static final RegistryObject<Item> KITSUNE_SPAWN_EGG = ITEMS.register("kitsune_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KITSUNE, 0xff9356, 0xdd0885,
                    new Item.Properties()));

    public static final RegistryObject<Item> KITSUNE_SMALL_SPAWN_EGG = ITEMS.register("kitsune_small_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TWOTAILED, 0xF1F0ED, 0x2596be,
                    new Item.Properties()));
    public static final RegistryObject<Item> ONIBI_SPAWN_EGG = ITEMS.register("onibi_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ONIBI, 0x85929E, 0x0097FF,
                    new Item.Properties()));
    public static final RegistryObject<Item> JOROGUMO_SPAWN_EGG = ITEMS.register("jorogumo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.JOROGUMO, 0x5f3799, 0xffcedd,
                    new Item.Properties()));

    public static final RegistryObject<Item> KOMAINU_SPAWN_EGG = ITEMS.register("komainu_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KOMAINU, 0x00ffc8, 0xff7200,
                    new Item.Properties()));

    public static final RegistryObject<Item> TANUKI_SPAWN_EGG = ITEMS.register("tanuki_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TANUKI, 0x544719, 0x3186e0,
                    new Item.Properties()));

    public static final RegistryObject<Item> KAWAUSO_SPAWN_EGG = ITEMS.register("kawauso_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KAWAUSO, 0x544719, 0x096e0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMETHYST_INGOT = ITEMS.register("amethyst_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_INGOT = ITEMS.register("quartz_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITSUNE_HIDE = ITEMS.register("kitsune_hide",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KITSUNE_TAIL = ITEMS.register("kitsune_tail",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AKANAME_TONGUE = ITEMS.register("akaname_tongue",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SPIRIT_FLAME = ITEMS.register("spirit_flame",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JOROGUMO_EYE = ITEMS.register("jorogumo_eye",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ONI_HORN = ITEMS.register("oni_horn",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CLOTH = ITEMS.register("cloth",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SPIRIT_UPGRADE_SMITHING_TMEPLATE = ITEMS.register("spirit_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
