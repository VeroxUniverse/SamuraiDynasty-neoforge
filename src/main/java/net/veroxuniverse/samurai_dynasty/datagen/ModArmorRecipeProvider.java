package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModArmorRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final Map<String, DeferredHolder<Item, ?>> PIECES = new LinkedHashMap<>();
    private static final Map<String, Item> COLOR_DYES = new LinkedHashMap<>();

    static {
        PIECES.put("helmet", ItemsRegistry.NETHERITE_SAMURAI_HELMET);
        PIECES.put("chestplate", ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE);
        PIECES.put("leggings", ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS);
        PIECES.put("boots", ItemsRegistry.NETHERITE_SAMURAI_BOOTS);

        COLOR_DYES.put("white", Items.WHITE_DYE);
        COLOR_DYES.put("orange", Items.ORANGE_DYE);
        COLOR_DYES.put("magenta", Items.MAGENTA_DYE);
        COLOR_DYES.put("light_blue", Items.LIGHT_BLUE_DYE);
        COLOR_DYES.put("yellow", Items.YELLOW_DYE);
        COLOR_DYES.put("lime", Items.LIME_DYE);
        COLOR_DYES.put("pink", Items.PINK_DYE);
        COLOR_DYES.put("gray", Items.GRAY_DYE);
        COLOR_DYES.put("light_gray", Items.LIGHT_GRAY_DYE);
        COLOR_DYES.put("cyan", Items.CYAN_DYE);
        COLOR_DYES.put("purple", Items.PURPLE_DYE);
        COLOR_DYES.put("blue", Items.BLUE_DYE);
        COLOR_DYES.put("brown", Items.BROWN_DYE);
        COLOR_DYES.put("green", Items.GREEN_DYE);
        COLOR_DYES.put("red", Items.RED_DYE);
        COLOR_DYES.put("black", Items.BLACK_DYE);
    }

    public ModArmorRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        for (Map.Entry<String, DeferredHolder<Item, ?>> pieceEntry : PIECES.entrySet()) {
            String piece = pieceEntry.getKey();
            Item armorPiece = pieceEntry.getValue().get();

            for (Map.Entry<String, Item> colorEntry : COLOR_DYES.entrySet()) {
                String color = colorEntry.getKey();
                Item dye = colorEntry.getValue();

                buildDyeRecipe(pRecipeOutput, armorPiece, dye, piece, color);
            }
        }
    }

    private void buildDyeRecipe(RecipeOutput pRecipeOutput, Item armorPiece, Item dye, String piece, String color) {
        ItemStack result = new ItemStack(armorPiece);
        result.set(DataComponents.BASE_COLOR, DyeColor.byName(color, DyeColor.WHITE));

        ShapelessRecipe recipe = new ShapelessRecipe(
                "",
                CraftingBookCategory.EQUIPMENT,
                result,
                NonNullList.of(Ingredient.EMPTY, Ingredient.of(armorPiece), Ingredient.of(dye))
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID,
                "netherite_samurai_" + piece + "_from_dye_" + color);

        pRecipeOutput.accept(id, recipe, null);
    }
}