package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;


public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SamuraiDynastyMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SD_TAB_ITEMS = CREATIVE_MODE_TABS.register("sd_tab_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.items." + SamuraiDynastyMod.MOD_ID))
            .icon(() -> ItemsRegistry.STEEL_SAMURAI_HELMET.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                ItemsRegistry.ITEMS.getEntries().forEach(item -> {
                    output.accept(item.get());

                });
            }).build());

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
