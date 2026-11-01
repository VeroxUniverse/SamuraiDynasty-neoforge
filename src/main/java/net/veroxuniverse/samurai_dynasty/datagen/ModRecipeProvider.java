package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

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


        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.TWISTTHORN_SLAB.get(), BlocksRegistry.TWISTTHORN_PLANKS);
        stairBuilder(BlocksRegistry.TWISTTHORN_STAIRS.get(), Ingredient.of(BlocksRegistry.TWISTTHORN_PLANKS.get())).group("twistthorn_stairs")
                .unlockedBy("has_twistthorn_planks", has(BlocksRegistry.TWISTTHORN_PLANKS.get())).save(pRecipeOutput);
        doorBuilder(BlocksRegistry.TWISTTHORN_DOOR.get(), Ingredient.of(BlocksRegistry.TWISTTHORN_PLANKS.get())).group("twistthorn_door")
                .unlockedBy("has_twistthorn_planks", has(BlocksRegistry.TWISTTHORN_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(BlocksRegistry.TWISTTHORN_TRAPDOOR.get(), Ingredient.of(BlocksRegistry.TWISTTHORN_PLANKS.get())).group("twistthorn_trapdoor")
                .unlockedBy("has_twistthorn_planks", has(BlocksRegistry.TWISTTHORN_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, BlocksRegistry.TWISTTHORN_PRESSURE_PLATE.get(), BlocksRegistry.TWISTTHORN_PLANKS.get());
        buttonBuilder(BlocksRegistry.TWISTTHORN_BUTTON.get(), Ingredient.of(BlocksRegistry.TWISTTHORN_PLANKS.get())).group("twistthorn_button")
                .unlockedBy("has_twistthorn_planks", has(BlocksRegistry.TWISTTHORN_PLANKS.get())).save(pRecipeOutput);
        fenceBuilder(BlocksRegistry.TWISTTHORN_FENCE.get(), Ingredient.of(BlocksRegistry.TWISTTHORN_PLANKS.get())).group("twistthorn_fence")
                .unlockedBy("has_twistthorn_planks", has(BlocksRegistry.TWISTTHORN_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(BlocksRegistry.TWISTTHORN_FENCE_GATE.get(), Ingredient.of(BlocksRegistry.TWISTTHORN_PLANKS.get())).group("twistthorn_fence_gate")
                .unlockedBy("has_twistthorn_planks", has(BlocksRegistry.TWISTTHORN_PLANKS.get())).save(pRecipeOutput);

        for (BlocksRegistry.FenceMaterial material : BlocksRegistry.FENCE_MATERIALS) {
            ItemLike planks = material.planks().get();

            fenceWithMetalRecipe(pRecipeOutput, BlocksRegistry.GRATED_FENCES.get(material.name()).get(),
                    planks, Items.IRON_NUGGET, material.name() + "_grated_fence");
            fenceWithMetalRecipe(pRecipeOutput, BlocksRegistry.GILDED_FENCES.get(material.name()).get(),
                    planks, Items.GOLD_NUGGET, material.name() + "_gilded_fence");
        }

        for (RoofMaterial roofMaterial : ROOF_MATERIALS) {
            Block base = roofMaterial.base().get();
            roofStonecuttingRecipe(pRecipeOutput, base, roofMaterial.roof().get(), roofMaterial.name() + "_roof");
            roofStonecuttingRecipe(pRecipeOutput, base, roofMaterial.roofTop().get(), roofMaterial.name() + "_roof_top");
            roofStonecuttingRecipe(pRecipeOutput, base, roofMaterial.roofTip().get(), roofMaterial.name() + "_roof_tip");
        }

    }

    private record RoofMaterial(String name, Supplier<Block> base, Supplier<Block> roof,
                                Supplier<Block> roofTop, Supplier<Block> roofTip) {
    }

    private static final List<RoofMaterial> ROOF_MATERIALS = List.of(
            new RoofMaterial("spirit_stone",
                    () -> BlocksRegistry.SPIRIT_STONE_BRICKS.get(),
                    () -> BlocksRegistry.SPIRIT_STONE_ROOF.get(),
                    () -> BlocksRegistry.SPIRIT_STONE_ROOF_TOP.get(),
                    () -> BlocksRegistry.SPIRIT_STONE_ROOF_TIP.get()),
            new RoofMaterial("blackstone",
                    () -> Blocks.POLISHED_BLACKSTONE_BRICKS,
                    () -> BlocksRegistry.BLACKSTONE_ROOF.get(),
                    () -> BlocksRegistry.BLACKSTONE_ROOF_TOP.get(),
                    () -> BlocksRegistry.BLACKSTONE_ROOF_TIP.get()),
            new RoofMaterial("deepslate",
                    () -> Blocks.DEEPSLATE_BRICKS,
                    () -> BlocksRegistry.DEEPSLATE_ROOF.get(),
                    () -> BlocksRegistry.DEEPSLATE_ROOF_TOP.get(),
                    () -> BlocksRegistry.DEEPSLATE_ROOF_TIP.get()),
            new RoofMaterial("mud_bricks",
                    () -> Blocks.MUD_BRICKS,
                    () -> BlocksRegistry.MUD_BRICKS_ROOF.get(),
                    () -> BlocksRegistry.MUD_BRICKS_ROOF_TOP.get(),
                    () -> BlocksRegistry.MUD_BRICKS_ROOF_TIP.get())
    );

    private void roofStonecuttingRecipe(RecipeOutput pRecipeOutput, ItemLike base, ItemLike result, String resultName) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy(getHasName(base), has(base))
                .save(pRecipeOutput, SamuraiDynastyMod.MOD_ID + ":stones/" + resultName + "_from_" + getItemName(base) + "_stonecutting");
    }

    private void fenceWithMetalRecipe(RecipeOutput pRecipeOutput, ItemLike fence, ItemLike planks, ItemLike nugget, String group) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, fence, 3)
                .pattern("W#W")
                .pattern("W#W")
                .define('W', planks)
                .define('#', nugget)
                .group(group)
                .unlockedBy("has_planks", has(planks))
                .save(pRecipeOutput);
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