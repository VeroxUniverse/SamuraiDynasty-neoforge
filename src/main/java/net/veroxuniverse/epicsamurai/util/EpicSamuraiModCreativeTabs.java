package net.veroxuniverse.epicsamurai.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.veroxuniverse.epicsamurai.init.ItemsInit;
import org.jetbrains.annotations.NotNull;

public class EpicSamuraiModCreativeTabs {

    public static final CreativeModeTab EPICSAMURAI_TAB = new CreativeModeTab("epicsamurai_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ItemsInit.SHURIKEN.get());
        }
    };

}

