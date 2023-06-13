package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.SculkSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;

public class DeeperDarkerCompat {

    public static final DeferredRegister<Item> DEEPERDARKER_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);
    public static final RegistryObject<Item> SCULK_SAMURAI_HELMET = DEEPERDARKER_ITEMS.register("sculk_samurai_helmet",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_SAMURAI_CHESTPLATE = DEEPERDARKER_ITEMS.register("sculk_samurai_chestplate",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_SAMURAI_LEGGINGS = DEEPERDARKER_ITEMS.register("sculk_samurai_leggings",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_SAMURAI_BOOTS = DEEPERDARKER_ITEMS.register("sculk_samurai_boots",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static void register(IEventBus eventBus) {
        DEEPERDARKER_ITEMS.register(eventBus);
    }
}
