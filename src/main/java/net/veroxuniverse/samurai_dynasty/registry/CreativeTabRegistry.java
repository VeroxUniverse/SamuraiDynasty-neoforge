package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.compat.*;
import net.veroxuniverse.samurai_dynasty.item.armor.EtyriteSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.item.armor.MageSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SamuraiDynastyMod.MOD_ID);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register(
            SamuraiDynastyMod.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + SamuraiDynastyMod.MOD_ID))
                    .icon(() -> new ItemStack(ItemsRegistry.RED_SAMURAI_HELMET.get()))
                    .displayItems((displayParameters, output) -> {
                        for (RegistryObject<Item> item : ItemsRegistry.ITEMS.getEntries())
                            output.accept(item.get());

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

                        if (ModList.get().isLoaded("forbidden_arcanus"))
                            for (RegistryObject<Item> item : ForbiddenCompat.FA_ITEMS.getEntries())
                                if (item.get() instanceof SamuraiArmorItem)
                                    output.accept(item.get());

                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
