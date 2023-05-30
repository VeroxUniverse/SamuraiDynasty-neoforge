package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.create.BrassSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.deeperdarker.SculkSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.SculkSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.epicsamurai.util.EpicSamuraiModCreativeTabs;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CreateCompat {

    public static final DeferredRegister<Item> CREATE_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> BRASS_SAMURAI_HELMET = CREATE_ITEMS.register("brass_samurai_helmet",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BRASS_SAMURAI_CHESTPLATE = CREATE_ITEMS.register("brass_samurai_chestplate",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BRASS_SAMURAI_LEGGINGS = CREATE_ITEMS.register("brass_samurai_leggings",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BRASS_SAMURAI_BOOTS = CREATE_ITEMS.register("brass_samurai_boots",
            () -> new BrassSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_BRASS, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> BRASS_REPAIR_KIT = CREATE_ITEMS.register("brass_repair_kit",
            () -> new Item(new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static void registerArmorRenderer() {
        GeoArmorRenderer.registerArmorRenderer(BrassSamuraiArmorItem.class, BrassSamuraiArmorRenderer::new);
    }

    public static void register(IEventBus eventBus) {
        CREATE_ITEMS.register(eventBus);
    }
}
