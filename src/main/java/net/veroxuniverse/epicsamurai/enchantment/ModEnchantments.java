package net.veroxuniverse.epicsamurai.enchantment;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

import java.util.function.Supplier;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT, EpicSamuraiMod.MOD_ID);

    public static final DeferredHolder<Enchantment, ReturningBladeEnchantment> RETURNING_BLADE =
            ENCHANTMENTS.register("returning_blade",
                    ()-> new ReturningBladeEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON,
                            EquipmentSlot.MAINHAND));


    public static void register() {
        ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}