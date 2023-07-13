package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.forbidden_arcanus.DracoSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.forbidden_arcanus.TyrSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.DracoSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.TyrSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.epicsamurai.util.EpicSamuraiModCreativeTabs;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ForbiddenArcanusCompat {
    public static final DeferredRegister<Item> FORBIDDENARCANUS_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> TYR_SAMURAI_HELMET = FORBIDDENARCANUS_ITEMS.register("tyr_samurai_helmet",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> TYR_SAMURAI_CHESTPLATE = FORBIDDENARCANUS_ITEMS.register("tyr_samurai_chestplate",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> TYR_SAMURAI_LEGGINGS = FORBIDDENARCANUS_ITEMS.register("tyr_samurai_leggings",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> TYR_SAMURAI_BOOTS = FORBIDDENARCANUS_ITEMS.register("tyr_samurai_boots",
            () -> new TyrSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_TYR, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));

    public static final RegistryObject<Item> DRACO_SAMURAI_HELMET = FORBIDDENARCANUS_ITEMS.register("draco_samurai_helmet",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> DRACO_SAMURAI_CHESTPLATE = FORBIDDENARCANUS_ITEMS.register("draco_samurai_chestplate",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> DRACO_SAMURAI_LEGGINGS = FORBIDDENARCANUS_ITEMS.register("draco_samurai_leggings",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> DRACO_SAMURAI_BOOTS = FORBIDDENARCANUS_ITEMS.register("draco_samurai_boots",
            () -> new DracoSamuraiArmorItem(ArmorMaterialsRegistry.SAMURAI_DRACO, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));


    public static void registerArmorRenderer() {
        GeoArmorRenderer.registerArmorRenderer(TyrSamuraiArmorItem.class, TyrSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(DracoSamuraiArmorItem.class, DracoSamuraiArmorRenderer::new);
    }

    public static void register(IEventBus eventBus) {
        FORBIDDENARCANUS_ITEMS.register(eventBus);
    }
}
