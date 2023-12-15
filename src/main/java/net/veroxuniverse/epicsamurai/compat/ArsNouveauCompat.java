/*

package net.veroxuniverse.epicsamurai.compat;

import com.hollingsworth.arsnouveau.api.perk.ArmorPerkHolder;
import com.hollingsworth.arsnouveau.api.perk.PerkSlot;
import com.hollingsworth.arsnouveau.api.registry.PerkRegistry;
import com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor;
import com.hollingsworth.arsnouveau.common.armor.Materials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

import java.util.Arrays;
import java.util.List;

public class ArsNouveauCompat {

    public static final DeferredRegister.Items ARSN_ITEMS = DeferredRegister.createItems(EpicSamuraiMod.MOD_ID);

    public static GeoModel<AnimatedMagicArmor> model;
    public static final DeferredItem<Item> MAGE_SAMURAI_HELMET = ARSN_ITEMS.register("mage_samurai_helmet",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.HELMET, new Item.Properties(), model));
    public static final DeferredItem<Item> MAGE_SAMURAI_CHESTPLATE = ARSN_ITEMS.register("mage_samurai_chestplate",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.CHESTPLATE, new Item.Properties(), model));

    public static final DeferredItem<Item> MAGE_SAMURAI_LEGGINGS = ARSN_ITEMS.register("mage_samurai_leggings",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.LEGGINGS, new Item.Properties(), model));
    public static final DeferredItem<Item> MAGE_SAMURAI_BOOTS = ARSN_ITEMS.register("mage_samurai_boots",
            () -> new MageSamuraiArmorItem(Materials.HEAVY, ArmorItem.Type.BOOTS, new Item.Properties(), model));



    public static void registerPerkProviders(){
        PerkRegistry.registerPerkProvider(MAGE_SAMURAI_HELMET.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                List.of(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.TWO)
        )));
        PerkRegistry.registerPerkProvider(MAGE_SAMURAI_CHESTPLATE.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                List.of(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.TWO),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.THREE)
        )));
        PerkRegistry.registerPerkProvider(MAGE_SAMURAI_LEGGINGS.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                List.of(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.TWO),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.THREE)
        )));
        PerkRegistry.registerPerkProvider(MAGE_SAMURAI_BOOTS.get(), stack -> new ArmorPerkHolder(stack, Arrays.asList(
                List.of(PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE),
                Arrays.asList(PerkSlot.ONE, PerkSlot.ONE, PerkSlot.TWO)
        )));
    }

    public static void register(IEventBus eventBus) {
        ARSN_ITEMS.register(eventBus);
    }
}

 */
