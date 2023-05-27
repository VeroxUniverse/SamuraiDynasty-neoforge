package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.epicsamurai.item.SculkSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.util.EpicSamuraiModCreativeTabs;
public class DeeperDarkerCompat {

    public static final DeferredRegister<Item> DEEPERDARKER_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> SCULK_SAMURAI_HELMET = DEEPERDARKER_ITEMS.register("sculk_samurai_helmet",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SCULK_SAMURAI_CHESTPLATE = DEEPERDARKER_ITEMS.register("sculk_samurai_chestplate",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SCULK_SAMURAI_LEGGINGS = DEEPERDARKER_ITEMS.register("sculk_samurai_leggings",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SCULK_SAMURAI_BOOTS = DEEPERDARKER_ITEMS.register("sculk_samurai_boots",
            () -> new SculkSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_SCULK, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB).rarity(Rarity.EPIC)));


    public static void register(IEventBus eventBus) {
        DEEPERDARKER_ITEMS.register(eventBus);
    }
}
