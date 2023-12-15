package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

import java.util.function.Supplier;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EpicSamuraiMod.MOD_ID);

    @SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> TAB = CREATIVE_TABS.register(
            EpicSamuraiMod.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + EpicSamuraiMod.MOD_ID))
                    .icon(() -> new ItemStack(ItemsRegistry.RED_SAMURAI_HELMET.get()))
                    .displayItems((displayParameters, output) -> {
                        for (DeferredHolder<Item, ? extends Item> item : ItemsRegistry.ITEM_REGISTER.getEntries())
                            output.accept(item.get());
/*
                        if (ModList.get().isLoaded("create"))
                            for (RegistryObject<Item> item : CreateCompat.CREATE_ITEMS.getEntries())
                                output.accept(item.get());

                        if (ModList.get().isLoaded("deeperdarker"))
                            for (RegistryObject<Item> item : DeeperDarkerCompat.DEEPERDARKER_ITEMS.getEntries())
                                if (item.get() instanceof SamuraiArmorItem)
                                    output.accept(item.get());

                        if (ModList.get().isLoaded("ars_nouveau"))
                            for (RegistryObject<Item> item : ArsNouveauCompat.ARSN_ITEMS.getEntries())
                                if (item.get() instanceof MageSamuraiArmorItem)
                                    output.accept(item.get());

                        if (ModList.get().isLoaded("eldritch_end"))
                            for (RegistryObject<Item> item : EldritchEndCompat.ELDRITCH_ITEMS.getEntries())
                                if (item.get() instanceof EtyriteSamuraiArmorItem)
                                    output.accept(item.get());

                        if (ModList.get().isLoaded("aquaculture"))
                            for (RegistryObject<Item> item : AquacultureCompat.AQUA_ITEMS.getEntries())
                                if (item.get() instanceof SamuraiArmorItem)
                                    output.accept(item.get());

                        if (ModList.get().isLoaded("bloodmagic"))
                            for (RegistryObject<Item> item : BloodMagicCompat.BLOOD_ITEMS.getEntries())
                                if (item.get() instanceof SamuraiArmorItem)
                                    output.accept(item.get());

 */

                    })
                    .build()
    );

    public static void register() {
        CREATIVE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
