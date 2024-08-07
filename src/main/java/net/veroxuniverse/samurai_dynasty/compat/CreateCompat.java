package net.veroxuniverse.samurai_dynasty.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.BrassSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;

public class CreateCompat {

    public static final DeferredRegister<Item> CREATE_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SamuraiDynastyMod.MOD_ID);

    public static final RegistryObject<Item> BRASS_SAMURAI_HELMET = CREATE_ITEMS.register("brass_samurai_helmet",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_SAMURAI_CHESTPLATE = CREATE_ITEMS.register("brass_samurai_chestplate",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_SAMURAI_LEGGINGS = CREATE_ITEMS.register("brass_samurai_leggings",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_SAMURAI_BOOTS = CREATE_ITEMS.register("brass_samurai_boots",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> BRASS_REPAIR_KIT = CREATE_ITEMS.register("brass_repair_kit",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        CREATE_ITEMS.register(eventBus);
    }
}
