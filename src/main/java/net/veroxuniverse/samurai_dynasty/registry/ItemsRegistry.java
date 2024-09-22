package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.curios.KitsuneMaskCurios;
import net.veroxuniverse.samurai_dynasty.curios.OniMaskCurios;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.item.*;
import net.veroxuniverse.samurai_dynasty.item.armor.*;

@SuppressWarnings("unused")
public class ItemsRegistry {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SamuraiDynastyMod.MOD_ID);
    
    public static final DeferredItem<Item> NETHERITE_SAMURAI_HELMET = ITEMS.register("netherite_samurai_helmet",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> NETHERITE_SAMURAI_CHESTPLATE = ITEMS.register("netherite_samurai_chestplate",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> NETHERITE_SAMURAI_LEGGINGS = ITEMS.register("netherite_samurai_leggings",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> NETHERITE_SAMURAI_BOOTS = ITEMS.register("netherite_samurai_boots",
            () -> new NetheriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> STEEL_SAMURAI_HELMET = ITEMS.register("steel_samurai_helmet",
            () -> new SteelSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_SAMURAI_CHESTPLATE = ITEMS.register("steel_samurai_chestplate",
            () -> new SteelSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_SAMURAI_LEGGINGS = ITEMS.register("steel_samurai_leggings",
            () -> new SteelSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_SAMURAI_BOOTS = ITEMS.register("steel_samurai_boots",
            () -> new SteelSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new SteelArmorItem(ArmorMaterialsRegistry.SAMURAI_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    
    public static final DeferredItem<Item> STEEL_NINJA_HELMET = ITEMS.register("steel_ninja_helmet",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_NINJA_CHESTPLATE = ITEMS.register("steel_ninja_chestplate",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> STEEL_NINJA_BOOTS = ITEMS.register("steel_ninja_boots",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.NINJA_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> NETHERITE_NINJA_HELMET = ITEMS.register("netherite_ninja_helmet",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> NETHERITE_NINJA_CHESTPLATE = ITEMS.register("netherite_ninja_chestplate",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> NETHERITE_NINJA_BOOTS = ITEMS.register("netherite_ninja_boots",
            () -> new NetheriteNinjaArmorItem(ArmorMaterialsRegistry.NINJA_NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> NINJA_LEGGINGS = ITEMS.register("ninja_leggings",
            () -> new SteelNinjaArmorItem(ArmorMaterialsRegistry.CLOTH, ArmorItem.Type.LEGGINGS, new Item.Properties()));


    public static final DeferredItem<Item> KIMONO = ITEMS.register("kimono",
            () -> new KimonoArmorItem(ArmorMaterialsRegistry.CLOTH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> STRAW_HAT = ITEMS.register("straw_hat",
            () -> new StrawHatArmorItem(ArmorMaterialsRegistry.STRAW, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final DeferredItem<Item> ONI_MASK = ITEMS.register("oni_mask",
            () -> new OniMaskCurios(new Item.Properties().fireResistant().stacksTo(1)));

      /*
    public static final DeferredItem<Item> ONI_MASK_WHITE = ITEMS.register("oni_mask_white",
            () -> new OniMaskWhiteCurios(new Item.Properties().fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> ONI_MASK_RED = ITEMS.register("oni_mask_red",
            () -> new OniMaskRedCurios(new Item.Properties().fireResistant().stacksTo(1)));
    */

    public static final DeferredItem<Item> KITSUNE_MASK = ITEMS.register("kitsune_mask",
            () -> new KitsuneMaskCurios(new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> KNIVE_HANDLE = ITEMS.register("knive_handle",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KATANA_HANDLE = ITEMS.register("katana_handle",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPEAR_HANDLE = ITEMS.register("spear_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KATANA = ITEMS.register("katana",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL, 1,-2.0f))));
    public static final DeferredItem<Item> WAKIZASHI = ITEMS.register("wakizashi",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,0,-1.7f))));
    public static final DeferredItem<Item> NAGINATA = ITEMS.register("naginata",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,1,-2.7f))));
    public static final DeferredItem<Item> NAGAMAKI = ITEMS.register("nagamaki",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,1,-2.6f))));
    public static final DeferredItem<Item> SHUKO = ITEMS.register("shuko",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,-2,-1.5f))));
    public static final DeferredItem<Item> TETSUBO = ITEMS.register("tetsubo",
            () -> new TetsuboItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,6,-3.4f))));
    public static final DeferredItem<Item> ODACHI = ITEMS.register("odachi",
            () -> new OdachiItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,2,-2.4f))));
    public static final DeferredItem<Item> TONBUKIRI = ITEMS.register("tonbukiri",
            () -> new TonbukiriItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,1,-2.7f))));
    public static final DeferredItem<Item> KAMAYARI = ITEMS.register("kamayari",
            () -> new KamayariItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,1,-2.6f))));
    public static final DeferredItem<Item> KUNAI = ITEMS.register("kunai",
            () -> new KunaiItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,-2,-2.0f))));
    public static final DeferredItem<Item> KAMA = ITEMS.register("kama",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,-2,-1.5f))));
    public static final DeferredItem<Item> SAI = ITEMS.register("sai",
            () -> new SwordItem(ItemMaterialsRegistry.STEEL, new Item.Properties().
                    attributes(SwordItem.createAttributes(ItemMaterialsRegistry.STEEL,-2,-1.5f))));

    public static final DeferredItem<Item> SHURIKEN = ITEMS.register("shuriken",
            () -> new ShurikenItem(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> KATANA_NETHERITE = ITEMS.register("katana_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2 , -2.0f)).fireResistant()));
    public static final DeferredItem<Item> WAKIZASHI_NETHERITE = ITEMS.register("wakizashi_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, 1, -1.7f)).fireResistant()));
    public static final DeferredItem<Item> KATANA_ONI = ITEMS.register("katana_oni",
            () -> new OniKatanaItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2,-2.0f)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> KATANA_KITSUNE = ITEMS.register("katana_kitsune",
            () -> new KitsuneKatanaItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2,-2.0f)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> KATANA_KITSUNE_BLUE = ITEMS.register("katana_kitsune_blue",
            () -> new KitsuneKatanaBlueItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2,-2.0f)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> KATANA_AKANAME = ITEMS.register("katana_akaname",
            () -> new AkanameKatanaItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2,-2.0f)).rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> KATANA_JOROGUMO = ITEMS.register("katana_jorogumo",
            () -> new JorogumoKatanaItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2,-2.0f)).rarity(Rarity.RARE).fireResistant()));

    public static final DeferredItem<Item> NAGINATA_NETHERITE = ITEMS.register("naginata_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, 2, -2.7f)).fireResistant()));
    public static final DeferredItem<Item> NAGAMAKI_NETHERITE = ITEMS.register("nagamaki_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, 2, -2.6f)).fireResistant()));
    public static final DeferredItem<Item> SHUKO_NETHERITE = ITEMS.register("shuko_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, -1, -1.5f)).fireResistant()));
    public static final DeferredItem<Item> TETSUBO_NETHERITE = ITEMS.register("tetsubo_netherite",
            () -> new TetsuboNetheriteItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, 8,-3.4f)).fireResistant()));
    public static final DeferredItem<Item> ODACHI_NETHERITE = ITEMS.register("odachi_netherite",
            () -> new OdachiNetheriteItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,3,-2.4f)).fireResistant()));
    public static final DeferredItem<Item> TONBUKIRI_NETHERITE = ITEMS.register("tonbukiri_netherite",
            () -> new TonbukiriNetheriteItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE,2,-2.7f)).fireResistant()));
    public static final DeferredItem<Item> KAMAYARI_NETHERITE = ITEMS.register("kamayari_netherite",
            () -> new KamayariNetheriteItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, 2,-2.6f)).fireResistant()));
    public static final DeferredItem<Item> KUNAI_NETHERITE = ITEMS.register("kunai_netherite",
            () -> new NetheriteKunaiItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, -1,-2.0f)).fireResistant()));
    public static final DeferredItem<Item> KAMA_NETHERITE = ITEMS.register("kama_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, -1, -1.5f)).fireResistant()));
    public static final DeferredItem<Item> SAI_NETHERITE = ITEMS.register("sai_netherite",
            () -> new SwordItem(ItemMaterialsRegistry.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ItemMaterialsRegistry.NETHERITE, -1, -1.5f)).fireResistant()));

    public static final DeferredItem<Item> AKANAME_SPAWN_EGG = ITEMS.register("akaname_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.AKANAME.get(), 0x5e100a, 0xa88c8a,
                    new Item.Properties()));
    public static final DeferredItem<Item> ENENRA_SPAWN_EGG = ITEMS.register("enenra_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.ENENRA.get(), 0x08090a, 0xa88c8a,
                    new Item.Properties()));
    public static final DeferredItem<Item> ONI_SPAWN_EGG = ITEMS.register("oni_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.ONI.get(), 0xce1841, 0xead9ce,
                    new Item.Properties()));
    public static final DeferredItem<Item> KITSUNE_SPAWN_EGG = ITEMS.register("kitsune_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.KITSUNE.get(), 0xff9356, 0xdd0885,
                    new Item.Properties()));

    public static final DeferredItem<Item> KITSUNE_SMALL_SPAWN_EGG = ITEMS.register("kitsune_small_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.TWOTAILED.get(), 0xF1F0ED, 0x2596be,
                    new Item.Properties()));
    public static final DeferredItem<Item> ONIBI_SPAWN_EGG = ITEMS.register("onibi_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.ONIBI.get(), 0x85929E, 0x0097FF,
                    new Item.Properties()));
    public static final DeferredItem<Item> JOROGUMO_SPAWN_EGG = ITEMS.register("jorogumo_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.JOROGUMO.get(), 0x5f3799, 0xffcedd,
                    new Item.Properties()));

    public static final DeferredItem<Item> KOMAINU_SPAWN_EGG = ITEMS.register("komainu_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.KOMAINU.get(), 0x00ffc8, 0xff7200,
                    new Item.Properties()));

    public static final DeferredItem<Item> TANUKI_SPAWN_EGG = ITEMS.register("tanuki_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.TANUKI.get(), 0x544719, 0x3186e0,
                    new Item.Properties()));

    public static final DeferredItem<Item> KAWAUSO_SPAWN_EGG = ITEMS.register("kawauso_spawn_egg",
            () -> new SpawnEggItem(ModEntityTypes.KAWAUSO.get(), 0x544719, 0x096e0f,
                    new Item.Properties()));

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> AMETHYST_INGOT = ITEMS.register("amethyst_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> QUARTZ_INGOT = ITEMS.register("quartz_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KITSUNE_HIDE = ITEMS.register("kitsune_hide",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KITSUNE_TAIL = ITEMS.register("kitsune_tail",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> AKANAME_TONGUE = ITEMS.register("akaname_tongue",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPIRIT_FLAME = ITEMS.register("spirit_flame",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> JOROGUMO_EYE = ITEMS.register("jorogumo_eye",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ONI_HORN = ITEMS.register("oni_horn",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CLOTH = ITEMS.register("cloth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPIRIT_UPGRADE_SMITHING_TMEPLATE = ITEMS.register("spirit_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
