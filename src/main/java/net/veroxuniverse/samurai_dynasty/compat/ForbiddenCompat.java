package net.veroxuniverse.samurai_dynasty.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.DracoSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.item.armor.TyrSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;

public class ForbiddenCompat {
    public static final DeferredRegister<Item> FA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SamuraiDynastyMod.MOD_ID);

    public static final RegistryObject<Item> TYR_SAMURAI_HELMET = FA_ITEMS.register("tyr_samurai_helmet",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TYR_SAMURAI_CHESTPLATE = FA_ITEMS.register("tyr_samurai_chestplate",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TYR_SAMURAI_LEGGINGS = FA_ITEMS.register("tyr_samurai_leggings",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TYR_SAMURAI_BOOTS = FA_ITEMS.register("tyr_samurai_boots",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> DRACO_SAMURAI_HELMET = FA_ITEMS.register("draco_samurai_helmet",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRACO_SAMURAI_CHESTPLATE = FA_ITEMS.register("draco_samurai_chestplate",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRACO_SAMURAI_LEGGINGS = FA_ITEMS.register("draco_samurai_leggings",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRACO_SAMURAI_BOOTS = FA_ITEMS.register("draco_samurai_boots",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus) {
        FA_ITEMS.register(eventBus);
    }

}
