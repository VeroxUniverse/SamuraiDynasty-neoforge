package net.veroxuniverse.samurai_dynasty.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.EtyriteSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;

public class EldritchEndCompat {
    public static final DeferredRegister<Item> ELDRITCH_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SamuraiDynastyMod.MOD_ID);

    public static final RegistryObject<Item> ETYRITE_SAMURAI_HELMET = ELDRITCH_ITEMS.register("etyrite_samurai_helmet",
            () -> new EtyriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ETYRITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ETYRITE_SAMURAI_CHESTPLATE = ELDRITCH_ITEMS.register("etyrite_samurai_chestplate",
            () -> new EtyriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ETYRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ETYRITE_SAMURAI_LEGGINGS = ELDRITCH_ITEMS.register("etyrite_samurai_leggings",
            () -> new EtyriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ETYRITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ETYRITE_SAMURAI_BOOTS = ELDRITCH_ITEMS.register("etyrite_samurai_boots",
            () -> new EtyriteSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_ETYRITE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ELDRITCH_ITEMS.register(eventBus);
    }
}
