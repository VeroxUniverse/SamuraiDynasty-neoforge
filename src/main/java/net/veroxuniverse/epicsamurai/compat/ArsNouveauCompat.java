package net.veroxuniverse.epicsamurai.compat;

import com.hollingsworth.arsnouveau.common.armor.Materials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau.MageSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.util.EpicSamuraiModCreativeTabs;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ArsNouveauCompat {

    public static final DeferredRegister<Item> ARSN_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> MAGE_SAMURAI_HELMET = ARSN_ITEMS.register("mage_samurai_helmet",
            () -> new MageSamuraiArmorItem(Materials.master, EquipmentSlot.HEAD, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> MAGE_SAMURAI_CHESTPLATE = ARSN_ITEMS.register("mage_samurai_chestplate",
            () -> new MageSamuraiArmorItem(Materials.master, EquipmentSlot.CHEST, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> MAGE_SAMURAI_LEGGINGS = ARSN_ITEMS.register("mage_samurai_leggings",
            () -> new MageSamuraiArmorItem(Materials.master, EquipmentSlot.LEGS, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));
    public static final RegistryObject<Item> MAGE_SAMURAI_BOOTS = ARSN_ITEMS.register("mage_samurai_boots",
            () -> new MageSamuraiArmorItem(Materials.master, EquipmentSlot.FEET, new Item.Properties().tab(EpicSamuraiModCreativeTabs.EPICSAMURAI_TAB)));


    public static void registerArmorRenderer() {
        GeoArmorRenderer.registerArmorRenderer(MageSamuraiArmorItem.class, MageSamuraiArmorRenderer::new);
    }


    public static void register(IEventBus eventBus) {
        ARSN_ITEMS.register(eventBus);
    }
}
