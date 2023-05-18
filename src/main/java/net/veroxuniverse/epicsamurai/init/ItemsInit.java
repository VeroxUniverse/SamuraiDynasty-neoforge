package net.veroxuniverse.epicsamurai.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.item.*;
import net.veroxuniverse.epicsamurai.util.EpicSamuraiModCreativeTabs;

@SuppressWarnings("unused")
public class ItemsInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> IRON_SAMURAI_HELMET = ITEMS.register("iron_samurai_helmet",
            () -> new IronSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_IRON, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> IRON_SAMURAI_CHESTPLATE = ITEMS.register("iron_samurai_chestplate",
            () -> new IronSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_IRON, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> IRON_SAMURAI_LEGGINGS = ITEMS.register("iron_samurai_leggings",
            () -> new IronSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_IRON, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> IRON_SAMURAI_BOOTS = ITEMS.register("iron_samurai_boots",
            () -> new IronSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_IRON, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> WHITE_SAMURAI_HELMET = ITEMS.register("white_samurai_helmet",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_SILVER, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> WHITE_SAMURAI_CHESTPLATE = ITEMS.register("white_samurai_chestplate",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_SILVER, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> WHITE_SAMURAI_LEGGINGS = ITEMS.register("white_samurai_leggings",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_SILVER, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> WHITE_SAMURAI_BOOTS = ITEMS.register("white_samurai_boots",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_SILVER, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> GOLD_SAMURAI_HELMET = ITEMS.register("gold_samurai_helmet",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_GOLD, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GOLD_SAMURAI_CHESTPLATE = ITEMS.register("gold_samurai_chestplate",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_GOLD, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GOLD_SAMURAI_LEGGINGS = ITEMS.register("gold_samurai_leggings",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_GOLD, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GOLD_SAMURAI_BOOTS = ITEMS.register("gold_samurai_boots",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_GOLD, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> DIAMOND_SAMURAI_HELMET = ITEMS.register("diamond_samurai_helmet",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_DIAMOND, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_CHESTPLATE = ITEMS.register("diamond_samurai_chestplate",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_DIAMOND, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_LEGGINGS = ITEMS.register("diamond_samurai_leggings",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_DIAMOND, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_BOOTS = ITEMS.register("diamond_samurai_boots",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_DIAMOND, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> NETHERITE_SAMURAI_HELMET = ITEMS.register("netherite_samurai_helmet",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_CHESTPLATE = ITEMS.register("netherite_samurai_chestplate",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_LEGGINGS = ITEMS.register("netherite_samurai_leggings",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_BOOTS = ITEMS.register("netherite_samurai_boots",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> AMETHYST_SAMURAI_HELMET = ITEMS.register("amethyst_samurai_helmet",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_CHESTPLATE = ITEMS.register("amethyst_samurai_chestplate",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_LEGGINGS = ITEMS.register("amethyst_samurai_leggings",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_BOOTS = ITEMS.register("amethyst_samurai_boots",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_HELMET = ITEMS.register("quartz_samurai_helmet",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_CHESTPLATE = ITEMS.register("quartz_samurai_chestplate",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_LEGGINGS = ITEMS.register("quartz_samurai_leggings",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> QUARTZ_SAMURAI_BOOTS = ITEMS.register("quartz_samurai_boots",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> RED_SAMURAI_HELMET = ITEMS.register("red_samurai_helmet",
            () -> new RedSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_RUBY, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> RED_SAMURAI_CHESTPLATE = ITEMS.register("red_samurai_chestplate",
            () -> new RedSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_RUBY, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> RED_SAMURAI_LEGGINGS = ITEMS.register("red_samurai_leggings",
            () -> new RedSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_RUBY, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> RED_SAMURAI_BOOTS = ITEMS.register("red_samurai_boots",
            () -> new RedSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_RUBY, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> BLUE_SAMURAI_HELMET = ITEMS.register("blue_samurai_helmet",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_AQUA, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BLUE_SAMURAI_CHESTPLATE = ITEMS.register("blue_samurai_chestplate",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_AQUA, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BLUE_SAMURAI_LEGGINGS = ITEMS.register("blue_samurai_leggings",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_AQUA, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BLUE_SAMURAI_BOOTS = ITEMS.register("blue_samurai_boots",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_AQUA, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> GREEN_SAMURAI_HELMET = ITEMS.register("green_samurai_helmet",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_JADE, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GREEN_SAMURAI_CHESTPLATE = ITEMS.register("green_samurai_chestplate",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_JADE, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GREEN_SAMURAI_LEGGINGS = ITEMS.register("green_samurai_leggings",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_JADE, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GREEN_SAMURAI_BOOTS = ITEMS.register("green_samurai_boots",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsInit.SAMURAI_JADE, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> GRAY_SAMURAI_HELMET = ITEMS.register("gray_samurai_helmet",
            () -> new GraySamuraiArmorItem(ArmorMaterialsInit.SAMURAI_ONYX, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GRAY_SAMURAI_CHESTPLATE = ITEMS.register("gray_samurai_chestplate",
            () -> new GraySamuraiArmorItem(ArmorMaterialsInit.SAMURAI_ONYX, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GRAY_SAMURAI_LEGGINGS = ITEMS.register("gray_samurai_leggings",
            () -> new GraySamuraiArmorItem(ArmorMaterialsInit.SAMURAI_ONYX, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> GRAY_SAMURAI_BOOTS = ITEMS.register("gray_samurai_boots",
            () -> new GraySamuraiArmorItem(ArmorMaterialsInit.SAMURAI_ONYX, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new SteelArmorItem(ArmorMaterialsInit.STEEL, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new SteelArmorItem(ArmorMaterialsInit.STEEL, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            () -> new SteelArmorItem(ArmorMaterialsInit.STEEL, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new SteelArmorItem(ArmorMaterialsInit.STEEL, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatArmorItem(ArmorMaterialsInit.STRAW, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> KNIVE_HANDLE = ITEMS.register("knive_handle",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> KATANA_HANDLE = ITEMS.register("katana_handle",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> SPEAR_HANDLE = ITEMS.register("spear_handle",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(ItemMaterialsInit.SAMURAI,2,-2.4f, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> NAGINATA = ITEMS.register("naginata",
            () -> new SwordItem(ItemMaterialsInit.SAMURAI,2,-2.4f, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> NAGAMAKI = ITEMS.register("nagamaki",
            () -> new SwordItem(ItemMaterialsInit.SAMURAI,2,-2.4f, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> KUNAI = ITEMS.register("kunai",
            () -> new KunaiItem(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> KAMA = ITEMS.register("kama",
            () -> new SwordItem(ItemMaterialsInit.SAMURAI,-1,-2.0f, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> SAI = ITEMS.register("sai",
            () -> new SwordItem(ItemMaterialsInit.SAMURAI,-1,-2.0f, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> SHURIKEN = ITEMS.register("shuriken",
            () -> new ShurikenItem(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> AKANAME_SPAWN_EGG = ITEMS.register("akaname_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.AKANAME, 0x5e100a, 0xa88c8a,
                    new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> ENENRA_SPAWN_EGG = ITEMS.register("enenra_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ENENRA, 0x08090a, 0xa88c8a,
                    new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> ONI_SPAWN_EGG = ITEMS.register("oni_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ONI, 0xce1841, 0xead9ce,
                    new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> KITSUNE_SPAWN_EGG = ITEMS.register("kitsune_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KITSUNE, 0xff9356, 0xdd0885,
                    new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> AMETHYST_INGOT = ITEMS.register("amethyst_ingot",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> QUARTZ_INGOT = ITEMS.register("quartz_ingot",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
