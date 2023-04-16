package net.veroxuniverse.epicsamurai.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemMaterialsInit {

    public static final ForgeTier SAMURAI = new ForgeTier(4, 2500, 12.0f,
            5.0f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ItemsInit.STEEL_INGOT.get()));

}