package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                             CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, SamuraiDynastyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Item Tags here

    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}