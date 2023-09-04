package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.item.KunaiItem;
import net.veroxuniverse.epicsamurai.item.ShurikenItem;
import net.veroxuniverse.epicsamurai.item.armor.*;

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
    public static final RegistryObject<Item> WHITE_SAMURAI_HELMET = ITEMS.register("white_samurai_helmet",

            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_CHESTPLATE = ITEMS.register("white_samurai_chestplate",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_LEGGINGS = ITEMS.register("white_samurai_leggings",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_SAMURAI_BOOTS = ITEMS.register("white_samurai_boots",
            () -> new WhiteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GOLD_SAMURAI_HELMET = ITEMS.register("gold_samurai_helmet",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_CHESTPLATE = ITEMS.register("gold_samurai_chestplate",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_LEGGINGS = ITEMS.register("gold_samurai_leggings",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SAMURAI_BOOTS = ITEMS.register("gold_samurai_boots",
            () -> new GoldSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SAMURAI_HELMET = ITEMS.register("diamond_samurai_helmet",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_CHESTPLATE = ITEMS.register("diamond_samurai_chestplate",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_LEGGINGS = ITEMS.register("diamond_samurai_leggings",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SAMURAI_BOOTS = ITEMS.register("diamond_samurai_boots",
            () -> new DiamondSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SAMURAI_HELMET = ITEMS.register("netherite_samurai_helmet",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MASK_NETHERITE_SAMURAI_HELMET = ITEMS.register("mask_netherite_samurai_helmet",
            () -> new MaskNetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_CHESTPLATE = ITEMS.register("netherite_samurai_chestplate",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_LEGGINGS = ITEMS.register("netherite_samurai_leggings",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SAMURAI_BOOTS = ITEMS.register("netherite_samurai_boots",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> AMETHYST_SAMURAI_HELMET = ITEMS.register("amethyst_samurai_helmet",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MASK_AMETHYST_SAMURAI_HELMET = ITEMS.register("mask_amethyst_samurai_helmet",
            () -> new MaskAmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_CHESTPLATE = ITEMS.register("amethyst_samurai_chestplate",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_LEGGINGS = ITEMS.register("amethyst_samurai_leggings",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> AMETHYST_SAMURAI_BOOTS = ITEMS.register("amethyst_samurai_boots",
            () -> new AmethystSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> QUARTZ_SAMURAI_HELMET = ITEMS.register("quartz_samurai_helmet",
            () -> new QuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MASK_QUARTZ_SAMURAI_HELMET = ITEMS.register("mask_quartz_samurai_helmet",
            () -> new MaskQuartzSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_QUARTZ, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
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

    public static final RegistryObject<Item> BLUE_SAMURAI_HELMET = ITEMS.register("blue_samurai_helmet",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_CHESTPLATE = ITEMS.register("blue_samurai_chestplate",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_LEGGINGS = ITEMS.register("blue_samurai_leggings",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SAMURAI_BOOTS = ITEMS.register("blue_samurai_boots",
            () -> new BlueSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_AQUA, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GREEN_SAMURAI_HELMET = ITEMS.register("green_samurai_helmet",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_CHESTPLATE = ITEMS.register("green_samurai_chestplate",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_LEGGINGS = ITEMS.register("green_samurai_leggings",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAMURAI_BOOTS = ITEMS.register("green_samurai_boots",
            () -> new GreenSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_JADE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GRAY_SAMURAI_HELMET = ITEMS.register("gray_samurai_helmet",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_CHESTPLATE = ITEMS.register("gray_samurai_chestplate",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_LEGGINGS = ITEMS.register("gray_samurai_leggings",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GRAY_SAMURAI_BOOTS = ITEMS.register("gray_samurai_boots",
            () -> new GraySamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ONYX, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> STEEL_NINJA_HELMET = ITEMS.register("steel_ninja_helmet",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NINJA_CHESTPLATE = ITEMS.register("steel_ninja_chestplate",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NINJA_LEGGINGS = ITEMS.register("steel_ninja_leggings",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NINJA_BOOTS = ITEMS.register("steel_ninja_boots",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatArmorItem(ArmorMaterialsRegistry.STRAW, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MASK_STRAW_HAT = ITEMS.register("mask_straw_hat",
            () -> new MaskStrawHatArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ONI_MASK = ITEMS.register("oni_mask",
            () -> new OniMaskArmorItem(ArmorMaterialsRegistry.STEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> KNIVE_HANDLE = ITEMS.register("knive_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KATANA_HANDLE = ITEMS.register("katana_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPEAR_HANDLE = ITEMS.register("spear_handle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,2,-2.4f, new Item.Properties()));
    public static final RegistryObject<Item> NAGINATA = ITEMS.register("naginata",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,2,-2.4f, new Item.Properties()));
    public static final RegistryObject<Item> NAGAMAKI = ITEMS.register("nagamaki",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,2,-2.4f, new Item.Properties()));
    public static final RegistryObject<Item> SHUKO = ITEMS.register("shuko",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-1,-2.0f, new Item.Properties()));
    public static final RegistryObject<Item> TETSUBO = ITEMS.register("tetsubo",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,4,-3.4f, new Item.Properties()));
    public static final RegistryObject<Item> KUNAI = ITEMS.register("kunai",
            () -> new KunaiItem(ItemMaterialsRegistry.SAMURAI,-1,-2.0f, new Item.Properties()));
    public static final RegistryObject<Item> KAMA = ITEMS.register("kama",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-1,-2.0f, new Item.Properties()));
    public static final RegistryObject<Item> SAI = ITEMS.register("sai",
            () -> new SwordItem(ItemMaterialsRegistry.SAMURAI,-1,-2.0f, new Item.Properties()));
    public static final RegistryObject<Item> SHURIKEN = ITEMS.register("shuriken",
            () -> new ShurikenItem(new Item.Properties()));

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
    public static final RegistryObject<Item> ONIBI_SPAWN_EGG = ITEMS.register("onibi_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ONIBI, 0x85929E, 0x0097FF,
                    new Item.Properties()));
    public static final RegistryObject<Item> JOROGUMO_SPAWN_EGG = ITEMS.register("jorogumo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.JOROGUMO, 0x5f3799, 0xffcedd,
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

    public static final RegistryObject<Item> ONI_HORN = ITEMS.register("oni_horn",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
