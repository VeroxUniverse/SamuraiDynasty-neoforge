package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemMaterialsRegistry {

    public static final ForgeTier SAMURAI = new ForgeTier(3, 1561, 12.0f,
            5.0f, 12, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get()));

    public static final ForgeTier SAMURAI_NETHERITE = new ForgeTier(4, 2561, 12.0f,
            5.0f, 25, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

}