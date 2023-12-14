/*

package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;

public class AquacultureCompat {
    public static final DeferredRegister<Item> AQUA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> NEPTUNIUM_SAMURAI_HELMET = AQUA_ITEMS.register("neptunium_samurai_helmet",
            () -> new NeptuniumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NEPTUN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NEPTUNIUM_SAMURAI_CHESTPLATE = AQUA_ITEMS.register("neptunium_samurai_chestplate",
            () -> new NeptuniumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NEPTUN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NEPTUNIUM_SAMURAI_LEGGINGS = AQUA_ITEMS.register("neptunium_samurai_leggings",
            () -> new NeptuniumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NEPTUN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NEPTUNIUM_SAMURAI_BOOTS = AQUA_ITEMS.register("neptunium_samurai_boots",
            () -> new NeptuniumSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_NEPTUN, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        AQUA_ITEMS.register(eventBus);
    }
}

 */