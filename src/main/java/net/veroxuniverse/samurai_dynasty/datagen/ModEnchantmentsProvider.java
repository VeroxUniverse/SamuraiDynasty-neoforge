package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.veroxuniverse.samurai_dynasty.datagen.enchantment.ModEnchantments;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentsProvider extends EnchantmentTagsProvider {

    public ModEnchantmentsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future) {
        super(packOutput, future);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tooltipOrder(
                pProvider,
                new ResourceKey[]{
                        ModEnchantments.RETURNING_BLADE
                }
        );



    }
}
