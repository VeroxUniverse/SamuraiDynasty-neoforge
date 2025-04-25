package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.SPIRIT_BLOSSOM_SLAB.get(), BlocksRegistry.SPIRIT_BLOSSOM_PLANKS);
        stairBuilder(BlocksRegistry.SPIRIT_BLOSSOM_STAIRS.get(), Ingredient.of(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).group("spirit_blossom_stairs")
                .unlockedBy("has_spirit_blossom_planks", has(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).save(pRecipeOutput);
        doorBuilder(BlocksRegistry.SPIRIT_BLOSSOM_DOOR.get(), Ingredient.of(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).group("spirit_blossom_door")
                .unlockedBy("has_spirit_blossom_planks", has(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(BlocksRegistry.SPIRIT_BLOSSOM_TRAPDOOR.get(), Ingredient.of(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).group("spirit_blossom_trapdoor")
                .unlockedBy("has_spirit_blossom_planks", has(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, BlocksRegistry.SPIRIT_BLOSSOM_PRESSURE_PLATE.get(), BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get());
        buttonBuilder(BlocksRegistry.SPIRIT_BLOSSOM_BUTTON.get(), Ingredient.of(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).group("spirit_blossom_button")
                .unlockedBy("has_spirit_blossom_planks", has(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).save(pRecipeOutput);
        fenceBuilder(BlocksRegistry.SPIRIT_BLOSSOM_FENCE.get(), Ingredient.of(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).group("spirit_blossom_fence")
                .unlockedBy("has_spirit_blossom_planks", has(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(BlocksRegistry.SPIRIT_BLOSSOM_FENCE_GATE.get(), Ingredient.of(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).group("spirit_blossom_fence_gate")
                .unlockedBy("has_spirit_blossom_planks", has(BlocksRegistry.SPIRIT_BLOSSOM_PLANKS.get())).save(pRecipeOutput);


        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.SPIRIT_WOOD_SLAB.get(), BlocksRegistry.SPIRIT_WOOD_PLANKS);
        stairBuilder(BlocksRegistry.SPIRIT_WOOD_STAIRS.get(), Ingredient.of(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).group("spirit_wood_stairs")
                .unlockedBy("has_spirit_wood_planks", has(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).save(pRecipeOutput);
        doorBuilder(BlocksRegistry.SPIRIT_WOOD_DOOR.get(), Ingredient.of(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).group("spirit_wood_door")
                .unlockedBy("has_spirit_wood_planks", has(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(BlocksRegistry.SPIRIT_WOOD_TRAPDOOR.get(), Ingredient.of(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).group("spirit_wood_trapdoor")
                .unlockedBy("has_spirit_wood_planks", has(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, BlocksRegistry.SPIRIT_WOOD_PRESSURE_PLATE.get(), BlocksRegistry.SPIRIT_WOOD_PLANKS.get());
        buttonBuilder(BlocksRegistry.SPIRIT_WOOD_BUTTON.get(), Ingredient.of(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).group("spirit_wood_button")
                .unlockedBy("has_spirit_wood_planks", has(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).save(pRecipeOutput);
        fenceBuilder(BlocksRegistry.SPIRIT_WOOD_FENCE.get(), Ingredient.of(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).group("spirit_wood_fence")
                .unlockedBy("has_spirit_wood_planks", has(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(BlocksRegistry.SPIRIT_WOOD_FENCE_GATE.get(), Ingredient.of(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).group("spirit_wood_fence_gate")
                .unlockedBy("has_spirit_wood_planks", has(BlocksRegistry.SPIRIT_WOOD_PLANKS.get())).save(pRecipeOutput);

    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, SamuraiDynastyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}