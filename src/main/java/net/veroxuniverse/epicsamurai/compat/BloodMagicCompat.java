/*

package net.veroxuniverse.epicsamurai.compat;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.LivingSamuraiArmorItem;
import wayoftime.bloodmagic.common.item.ArmorMaterialLiving;

public class BloodMagicCompat {

    public static final DeferredRegister<Item> BLOOD_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<Item> LIVING_SAMURAI_HELMET = BLOOD_ITEMS.register("living_samurai_helmet",
            () -> new LivingSamuraiArmorItem(ArmorMaterialLiving.INSTANCE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_SAMURAI_CHESTPLATE = BLOOD_ITEMS.register("living_samurai_chestplate",
            () -> new LivingSamuraiArmorItem(ArmorMaterialLiving.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_SAMURAI_LEGGINGS = BLOOD_ITEMS.register("living_samurai_leggings",
            () -> new LivingSamuraiArmorItem(ArmorMaterialLiving.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_SAMURAI_BOOTS = BLOOD_ITEMS.register("living_samurai_boots",
            () -> new LivingSamuraiArmorItem(ArmorMaterialLiving.INSTANCE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        BLOOD_ITEMS.register(eventBus);
    }
}

 */
