package net.veroxuniverse.epicsamurai.compat;

/*

import com.hollingsworth.arsnouveau.api.ArsNouveauAPI;
import com.hollingsworth.arsnouveau.api.perk.ArmorPerkHolder;
import com.hollingsworth.arsnouveau.api.perk.PerkSlot;
import com.hollingsworth.arsnouveau.common.armor.Materials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau.MageSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.ars_nouveau.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.Arrays;

public class ArsNouveauCompat {

    public static final DeferredRegister<Item> ARSN_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> MAGE_SAMURAI_HELMET = ARSN_ITEMS.register("mage_samurai_helmet",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MAGE_SAMURAI_CHESTPLATE = ARSN_ITEMS.register("mage_samurai_chestplate",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MAGE_SAMURAI_LEGGINGS = ARSN_ITEMS.register("mage_samurai_leggings",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MAGE_SAMURAI_BOOTS = ARSN_ITEMS.register("mage_samurai_boots",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.BOOTS, new Item.Properties()));



    public static void registerPerkProviders(){
        var api = ArsNouveauAPI.getInstance();
        api.registerPerkProvider(MAGE_SAMURAI_HELMET.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                Arrays.asList(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.TWO)
        )));
        api.registerPerkProvider(MAGE_SAMURAI_CHESTPLATE.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                Arrays.asList(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.TWO)
        )));
        api.registerPerkProvider(MAGE_SAMURAI_LEGGINGS.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                Arrays.asList(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.TWO)
        )));
        api.registerPerkProvider(MAGE_SAMURAI_BOOTS.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                Arrays.asList(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.TWO)
        )));
    }

    public static void registerArmorRenderer() {
        GeoArmorRenderer.registerArmorRenderer(MageSamuraiArmorItem.class, MageSamuraiArmorRenderer::new);
    }


    public static void register(IEventBus eventBus) {
        ARSN_ITEMS.register(eventBus);
    }
}

 */
