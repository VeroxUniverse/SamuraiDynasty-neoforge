package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.item.*;
import net.veroxuniverse.epicsamurai.item.armor.*;

@SuppressWarnings("unused")
public class ItemsRegistry {
    public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(BuiltInRegistries.ITEM, EpicSamuraiMod.MOD_ID);

    public static final DeferredHolder<Item, IronSamuraiArmorItem> IRON_SAMURAI_HELMET = ITEM_REGISTER.register("iron_samurai_helmet",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredHolder<Item, IronSamuraiArmorItem> IRON_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("iron_samurai_chestplate",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, IronSamuraiArmorItem> IRON_SAMURAI_LEGGINGS = ITEM_REGISTER.register("iron_samurai_leggings",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, IronSamuraiArmorItem> IRON_SAMURAI_BOOTS = ITEM_REGISTER.register("iron_samurai_boots",
            () -> new IronSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredHolder<Item, WhiteSamuraiArmorItem> WHITE_SAMURAI_HELMET = ITEM_REGISTER.register("white_samurai_helmet",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, WhiteSamuraiArmorItem> WHITE_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("white_samurai_chestplate",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, WhiteSamuraiArmorItem> WHITE_SAMURAI_LEGGINGS = ITEM_REGISTER.register("white_samurai_leggings",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, WhiteSamuraiArmorItem> WHITE_SAMURAI_BOOTS = ITEM_REGISTER.register("white_samurai_boots",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, GoldSamuraiArmorItem> GOLD_SAMURAI_HELMET = ITEM_REGISTER.register("gold_samurai_helmet",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, GoldSamuraiArmorItem> GOLD_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("gold_samurai_chestplate",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, GoldSamuraiArmorItem> GOLD_SAMURAI_LEGGINGS = ITEM_REGISTER.register("gold_samurai_leggings",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, GoldSamuraiArmorItem> GOLD_SAMURAI_BOOTS = ITEM_REGISTER.register("gold_samurai_boots",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, DiamondSamuraiArmorItem> DIAMOND_SAMURAI_HELMET = ITEM_REGISTER.register("diamond_samurai_helmet",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, DiamondSamuraiArmorItem> DIAMOND_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("diamond_samurai_chestplate",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, DiamondSamuraiArmorItem> DIAMOND_SAMURAI_LEGGINGS = ITEM_REGISTER.register("diamond_samurai_leggings",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, DiamondSamuraiArmorItem> DIAMOND_SAMURAI_BOOTS = ITEM_REGISTER.register("diamond_samurai_boots",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, NetheriteSamuraiArmorItem> NETHERITE_SAMURAI_HELMET = ITEM_REGISTER.register("netherite_samurai_helmet",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, MaskNetheriteSamuraiArmorItem> MASK_NETHERITE_SAMURAI_HELMET = ITEM_REGISTER.register("mask_netherite_samurai_helmet",
            () -> new MaskNetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, NetheriteSamuraiArmorItem> NETHERITE_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("netherite_samurai_chestplate",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, NetheriteSamuraiArmorItem> NETHERITE_SAMURAI_LEGGINGS = ITEM_REGISTER.register("netherite_samurai_leggings",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, NetheriteSamuraiArmorItem> NETHERITE_SAMURAI_BOOTS = ITEM_REGISTER.register("netherite_samurai_boots",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, AmethystSamuraiArmorItem> AMETHYST_SAMURAI_HELMET = ITEM_REGISTER.register("amethyst_samurai_helmet",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, MaskAmethystSamuraiArmorItem> MASK_AMETHYST_SAMURAI_HELMET = ITEM_REGISTER.register("mask_amethyst_samurai_helmet",
            () -> new MaskAmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, AmethystSamuraiArmorItem> AMETHYST_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("amethyst_samurai_chestplate",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, AmethystSamuraiArmorItem> AMETHYST_SAMURAI_LEGGINGS = ITEM_REGISTER.register("amethyst_samurai_leggings",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, AmethystSamuraiArmorItem> AMETHYST_SAMURAI_BOOTS = ITEM_REGISTER.register("amethyst_samurai_boots",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, QuartzSamuraiArmorItem> QUARTZ_SAMURAI_HELMET = ITEM_REGISTER.register("quartz_samurai_helmet",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, MaskQuartzSamuraiArmorItem> MASK_QUARTZ_SAMURAI_HELMET = ITEM_REGISTER.register("mask_quartz_samurai_helmet",
            () -> new MaskQuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, QuartzSamuraiArmorItem> QUARTZ_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("quartz_samurai_chestplate",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, QuartzSamuraiArmorItem> QUARTZ_SAMURAI_LEGGINGS = ITEM_REGISTER.register("quartz_samurai_leggings",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, QuartzSamuraiArmorItem> QUARTZ_SAMURAI_BOOTS = ITEM_REGISTER.register("quartz_samurai_boots",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, RedSamuraiArmorItem> RED_SAMURAI_HELMET = ITEM_REGISTER.register("red_samurai_helmet",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, RedSamuraiArmorItem> RED_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("red_samurai_chestplate",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, RedSamuraiArmorItem> RED_SAMURAI_LEGGINGS = ITEM_REGISTER.register("red_samurai_leggings",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, RedSamuraiArmorItem> RED_SAMURAI_BOOTS = ITEM_REGISTER.register("red_samurai_boots",
            () -> new RedSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, BlueSamuraiArmorItem> BLUE_SAMURAI_HELMET = ITEM_REGISTER.register("blue_samurai_helmet",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, BlueSamuraiArmorItem> BLUE_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("blue_samurai_chestplate",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, BlueSamuraiArmorItem> BLUE_SAMURAI_LEGGINGS = ITEM_REGISTER.register("blue_samurai_leggings",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, BlueSamuraiArmorItem> BLUE_SAMURAI_BOOTS = ITEM_REGISTER.register("blue_samurai_boots",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, GreenSamuraiArmorItem> GREEN_SAMURAI_HELMET = ITEM_REGISTER.register("green_samurai_helmet",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, GreenSamuraiArmorItem> GREEN_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("green_samurai_chestplate",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, GreenSamuraiArmorItem> GREEN_SAMURAI_LEGGINGS = ITEM_REGISTER.register("green_samurai_leggings",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, GreenSamuraiArmorItem> GREEN_SAMURAI_BOOTS = ITEM_REGISTER.register("green_samurai_boots",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, GraySamuraiArmorItem> GRAY_SAMURAI_HELMET = ITEM_REGISTER.register("gray_samurai_helmet",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, GraySamuraiArmorItem> GRAY_SAMURAI_CHESTPLATE = ITEM_REGISTER.register("gray_samurai_chestplate",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, GraySamuraiArmorItem> GRAY_SAMURAI_LEGGINGS = ITEM_REGISTER.register("gray_samurai_leggings",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, GraySamuraiArmorItem> GRAY_SAMURAI_BOOTS = ITEM_REGISTER.register("gray_samurai_boots",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, SteelArmorItem> STEEL_HELMET = ITEM_REGISTER.register("steel_helmet",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, SteelArmorItem> STEEL_CHESTPLATE = ITEM_REGISTER.register("steel_chestplate",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, SteelArmorItem> STEEL_LEGGINGS = ITEM_REGISTER.register("steel_leggings",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, SteelArmorItem> STEEL_BOOTS = ITEM_REGISTER.register("steel_boots",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, IronNinjaArmorItem> IRON_NINJA_HELMET = ITEM_REGISTER.register("iron_ninja_helmet",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, IronNinjaArmorItem> IRON_NINJA_CHESTPLATE = ITEM_REGISTER.register("iron_ninja_chestplate",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
   /*
    public static final DeferredHolder<Item, Item> IRON_NINJA_LEGGINGS = ITEM_REGISTER.register("iron_ninja_leggings",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    */
    public static final DeferredHolder<Item, IronNinjaArmorItem> IRON_NINJA_BOOTS = ITEM_REGISTER.register("iron_ninja_boots",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.NINJA_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final DeferredHolder<Item, SteelNinjaArmorItem> STEEL_NINJA_HELMET = ITEM_REGISTER.register("steel_ninja_helmet",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, SteelNinjaArmorItem> STEEL_NINJA_CHESTPLATE = ITEM_REGISTER.register("steel_ninja_chestplate",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
     /*
    public static final DeferredHolder<Item, Item> STEEL_NINJA_LEGGINGS = ITEM_REGISTER.register("steel_ninja_leggings",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
      */
    public static final DeferredHolder<Item, SteelNinjaArmorItem> STEEL_NINJA_BOOTS = ITEM_REGISTER.register("steel_ninja_boots",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, GoldNinjaArmorItem> GOLD_NINJA_HELMET = ITEM_REGISTER.register("gold_ninja_helmet",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, GoldNinjaArmorItem> GOLD_NINJA_CHESTPLATE = ITEM_REGISTER.register("gold_ninja_chestplate",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
     /*
    public static final DeferredHolder<Item, Item> GOLD_NINJA_LEGGINGS = ITEM_REGISTER.register("gold_ninja_leggings",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
      */
    public static final DeferredHolder<Item, GoldNinjaArmorItem> GOLD_NINJA_BOOTS = ITEM_REGISTER.register("gold_ninja_boots",
            () -> new GoldNinjaArmorItem(ArmorMaterialsRegistry.NINJA_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, DiamondNinjaArmorItem> DIAMOND_NINJA_HELMET = ITEM_REGISTER.register("diamond_ninja_helmet",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, DiamondNinjaArmorItem> DIAMOND_NINJA_CHESTPLATE = ITEM_REGISTER.register("diamond_ninja_chestplate",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
     /*
    public static final DeferredHolder<Item, Item> DIAMOND_NINJA_LEGGINGS = ITEM_REGISTER.register("diamond_ninja_leggings",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
      */
    public static final DeferredHolder<Item, DiamondNinjaArmorItem> DIAMOND_NINJA_BOOTS = ITEM_REGISTER.register("diamond_ninja_boots",
            () -> new DiamondNinjaArmorItem(ArmorMaterialsRegistry.NINJA_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, NetheriteNinjaArmorItem> NETHERITE_NINJA_HELMET = ITEM_REGISTER.register("netherite_ninja_helmet",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, NetheriteNinjaArmorItem> NETHERITE_NINJA_CHESTPLATE = ITEM_REGISTER.register("netherite_ninja_chestplate",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    /*
    public static final DeferredHolder<Item, Item> NETHERITE_NINJA_LEGGINGS = ITEM_REGISTER.register("netherite_ninja_leggings",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
     */
    public static final DeferredHolder<Item, NetheriteNinjaArmorItem> NETHERITE_NINJA_BOOTS = ITEM_REGISTER.register("netherite_ninja_boots",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, IronNinjaArmorItem> NINJA_LEGGINGS = ITEM_REGISTER.register("ninja_leggings",
            () -> new IronNinjaArmorItem(ArmorMaterialsRegistry.CLOTH, ArmorItem.Type.LEGGINGS, new Item.Properties()));


    public static final DeferredHolder<Item, KimonoArmorItem> KIMONO = ITEM_REGISTER.register("kimono",
            () -> new KimonoArmorItem(ArmorMaterialsRegistry.CLOTH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredHolder<Item, StrawHatArmorItem> STRAW_HAT = ITEM_REGISTER.register("straw_hat",
            () -> new StrawHatArmorItem(ArmorMaterialsRegistry.STRAW, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, MaskStrawHatArmorItem> MASK_STRAW_HAT = ITEM_REGISTER.register("mask_straw_hat",
            () -> new MaskStrawHatArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, OniMaskArmorItem> ONI_MASK = ITEM_REGISTER.register("oni_mask",
            () -> new OniMaskArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, KitsuneMaskArmorItem> KITSUNE_MASK = ITEM_REGISTER.register("kitsune_mask",
            () -> new KitsuneMaskArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, Item> KNIVE_HANDLE = ITEM_REGISTER.register("knive_handle",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> KATANA_HANDLE = ITEM_REGISTER.register("katana_handle",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SPEAR_HANDLE = ITEM_REGISTER.register("spear_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, SwordItem> KATANA = ITEM_REGISTER.register("katana",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,1,-2.0f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> NAGINATA = ITEM_REGISTER.register("naginata",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,1,-2.7f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> NAGAMAKI = ITEM_REGISTER.register("nagamaki",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,1,-2.6f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> SHUKO = ITEM_REGISTER.register("shuko",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-2,-1.5f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> TETSUBO = ITEM_REGISTER.register("tetsubo",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,6,-3.4f, new Item.Properties()));
    public static final DeferredHolder<Item, KunaiItem> KUNAI = ITEM_REGISTER.register("kunai",
            () -> new KunaiItem(ItemMaterialsRegistry.SAMURAI,-2,-2.0f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> KAMA = ITEM_REGISTER.register("kama",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-2,-1.5f, new Item.Properties()));
    public static final DeferredHolder<Item, SwordItem> SAI = ITEM_REGISTER.register("sai",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-2,-1.5f, new Item.Properties()));

    public static final DeferredHolder<Item, ShurikenItem> SHURIKEN = ITEM_REGISTER.register("shuriken",
            () -> new ShurikenItem(new Item.Properties()));


    public static final DeferredHolder<Item, SwordItem> KATANA_NETHERITE = ITEM_REGISTER.register("katana_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, OniKatanaItem> KATANA_ONI = ITEM_REGISTER.register("katana_oni",
            () -> new OniKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredHolder<Item, KitsuneKatanaItem> KATANA_KITSUNE = ITEM_REGISTER.register("katana_kitsune",
            () -> new KitsuneKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredHolder<Item, KitsuneKatanaBlueItem> KATANA_KITSUNE_BLUE = ITEM_REGISTER.register("katana_kitsune_blue",
            () -> new KitsuneKatanaBlueItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredHolder<Item, AkanameKatanaItem> KATANA_AKANAME = ITEM_REGISTER.register("katana_akaname",
            () -> new AkanameKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredHolder<Item, JorogumoKatanaItem> KATANA_JOROGUMO = ITEM_REGISTER.register("katana_jorogumo",
            () -> new JorogumoKatanaItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.0f, new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final DeferredHolder<Item, SwordItem> NAGINATA_NETHERITE = ITEM_REGISTER.register("naginata_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.7f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, SwordItem> NAGAMAKI_NETHERITE = ITEM_REGISTER.register("nagamaki_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,2,-2.6f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, SwordItem> SHUKO_NETHERITE = ITEM_REGISTER.register("shuko_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-1.5f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, SwordItem> TETSUBO_NETHERITE = ITEM_REGISTER.register("tetsubo_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,8,-3.4f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, NetheriteKunaiItem> KUNAI_NETHERITE = ITEM_REGISTER.register("kunai_netherite",
            () -> new NetheriteKunaiItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-2.0f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, SwordItem> KAMA_NETHERITE = ITEM_REGISTER.register("kama_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-1.5f, new Item.Properties().fireResistant()));
    public static final DeferredHolder<Item, SwordItem> SAI_NETHERITE = ITEM_REGISTER.register("sai_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI_NETHERITE,-1,-1.5f, new Item.Properties().fireResistant()));

    public static final DeferredHolder<Item, SpawnEggItem> AKANAME_SPAWN_EGG = ITEM_REGISTER.register("akaname_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.AKANAME.get(), 0x5e100a, 0xa88c8a, new Item.Properties()
            ));
    public static final DeferredHolder<Item, SpawnEggItem> ENENRA_SPAWN_EGG = ITEM_REGISTER.register("enenra_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.ENENRA.get(), 0x08090a, 0xa88c8a, new Item.Properties()
            ));
    public static final DeferredHolder<Item, SpawnEggItem> ONI_SPAWN_EGG = ITEM_REGISTER.register("oni_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.ONI.get(), 0xce1841, 0xead9ce, new Item.Properties()
            ));
    public static final DeferredHolder<Item, SpawnEggItem> KITSUNE_SPAWN_EGG = ITEM_REGISTER.register("kitsune_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.KITSUNE.get(), 0xff9356, 0xdd0885, new Item.Properties()
            ));

    public static final DeferredHolder<Item, SpawnEggItem> KITSUNE_SMALL_SPAWN_EGG = ITEM_REGISTER.register("kitsune_small_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.TWOTAILED.get(), 0xF1F0ED, 0x2596be, new Item.Properties()
            ));
    public static final DeferredHolder<Item, SpawnEggItem> ONIBI_SPAWN_EGG = ITEM_REGISTER.register("onibi_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.ONIBI.get(), 0x85929E, 0x0097FF, new Item.Properties()
            ));
    public static final DeferredHolder<Item, SpawnEggItem> JOROGUMO_SPAWN_EGG = ITEM_REGISTER.register("jorogumo_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.JOROGUMO.get(), 0x5f3799, 0xffcedd, new Item.Properties()
            ));

    public static final DeferredHolder<Item, SpawnEggItem> KOMAINU_SPAWN_EGG = ITEM_REGISTER.register("komainu_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.KOMAINU.get(), 0x00ffc8, 0xff7200, new Item.Properties()
            ));

    public static final DeferredHolder<Item, SpawnEggItem> TANUKI_SPAWN_EGG = ITEM_REGISTER.register("tanuki_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.TANUKI.get(), 0x544719, 0x3186e0, new Item.Properties()
            ));

    public static final DeferredHolder<Item, SpawnEggItem> KAWAUSO_SPAWN_EGG = ITEM_REGISTER.register("kawauso_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.KAWAUSO.get(), 0x544719, 0x096e0f, new Item.Properties()
            ));

    public static final DeferredHolder<Item, Item> RUBY = ITEM_REGISTER.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> JADE = ITEM_REGISTER.register("jade",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> AQUAMARINE = ITEM_REGISTER.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ONYX = ITEM_REGISTER.register("onyx",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_SILVER = ITEM_REGISTER.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SILVER_INGOT = ITEM_REGISTER.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SILVER_NUGGET = ITEM_REGISTER.register("silver_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_INGOT = ITEM_REGISTER.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> STEEL_NUGGET = ITEM_REGISTER.register("steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> AMETHYST_INGOT = ITEM_REGISTER.register("amethyst_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> QUARTZ_INGOT = ITEM_REGISTER.register("quartz_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> KITSUNE_HIDE = ITEM_REGISTER.register("kitsune_hide",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> KITSUNE_TAIL =ITEM_REGISTER.register("kitsune_tail",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> AKANAME_TONGUE = ITEM_REGISTER.register("akaname_tongue",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SPIRIT_FLAME = ITEM_REGISTER.register("spirit_flame",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> JOROGUMO_EYE = ITEM_REGISTER.register("jorogumo_eye",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> ONI_HORN = ITEM_REGISTER.register("oni_horn",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> CLOTH = ITEM_REGISTER.register("cloth",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SPIRIT_UPGRADE_SMITHING_TMEPLATE =ITEM_REGISTER.register("spirit_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));


    public static void register() {
        ITEM_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
