package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemMaterialsRegistry {

    public static final ForgeTier SAMURAI = new ForgeTier(4, 1561, 12.0f,
            5.0f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get()));

}