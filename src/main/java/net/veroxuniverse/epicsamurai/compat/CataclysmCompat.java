package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.IgnitiumSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;

public class CataclysmCompat {


    public static final DeferredRegister<Item> CATACLYSM_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> IGNITIUM_SAMURAI_HELMET = CATACLYSM_ITEMS.register("ignitium_samurai_helmet",
            () -> new IgnitiumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IGNITIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> IGNITIUM_SAMURAI_CHESTPLATE = CATACLYSM_ITEMS.register("ignitium_samurai_chestplate",
            () -> new IgnitiumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IGNITIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> IGNITIUM_SAMURAI_LEGGINGS = CATACLYSM_ITEMS.register("ignitium_samurai_leggings",
            () -> new IgnitiumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IGNITIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> IGNITIUM_SAMURAI_BOOTS = CATACLYSM_ITEMS.register("ignitium_samurai_boots",
            () -> new IgnitiumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_IGNITIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));


    public static void register(IEventBus eventBus) {
        CATACLYSM_ITEMS.register(eventBus);
    }
}
