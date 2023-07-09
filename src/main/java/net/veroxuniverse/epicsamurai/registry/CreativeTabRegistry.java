package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.compat.ArsNouveauCompat;
import net.veroxuniverse.epicsamurai.compat.CreateCompat;
import net.veroxuniverse.epicsamurai.compat.DeeperDarkerCompat;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register(EpicSamuraiMod.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + EpicSamuraiMod.MOD_ID))
            .icon(() -> new ItemStack(ItemsRegistry.RED_SAMURAI_HELMET.get()))
            .displayItems((enabledFeatures, output) -> {
                for(RegistryObject<Item> item : ItemsRegistry.ITEMS.getEntries()){
                    if(item.get() instanceof CustomTabs customTabBehavior){
                        customTabBehavior.fillItemCategory(output);
                    }else{
                        output.accept(item.get());
                    }
                }
                if (ModList.get().isLoaded("create")) {
                    for(RegistryObject<Item> item : CreateCompat.CREATE_ITEMS.getEntries()){
                        if(item.get() instanceof CustomTabs customTabBehavior){
                            customTabBehavior.fillItemCategory(output);
                        }else{
                            output.accept(item.get());
                        }
                    }
                }
                if (ModList.get().isLoaded("deeperdarker")) {
                    for(RegistryObject<Item> item : DeeperDarkerCompat.DEEPERDARKER_ITEMS.getEntries()){
                        if(item.get() instanceof CustomTabs customTabBehavior){
                            customTabBehavior.fillItemCategory(output);
                        }else{
                            output.accept(item.get());
                        }
                    }
                }
                if (ModList.get().isLoaded("ars_nouveau")) {
                    for(RegistryObject<Item> item : ArsNouveauCompat.ARSN_ITEMS.getEntries()){
                        if(item.get() instanceof CustomTabs customTabBehavior){
                            customTabBehavior.fillItemCategory(output);
                        }else{
                            output.accept(item.get());
                        }
                    }
                }
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
