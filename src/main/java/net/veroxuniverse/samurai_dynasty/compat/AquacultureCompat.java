package net.veroxuniverse.samurai_dynasty.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.NeptuniumSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;

public class AquacultureCompat {
    public static final DeferredRegister<Item> AQUA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SamuraiDynastyMod.MOD_ID);

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
