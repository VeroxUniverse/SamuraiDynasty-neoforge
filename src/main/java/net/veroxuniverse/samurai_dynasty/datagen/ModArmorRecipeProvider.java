package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class ModArmorRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModArmorRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    private static final String[] COLORS = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};
    private static final String[] PIECES = {"helmet", "chestplate", "leggings", "boots"};


    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        for (String piece : PIECES) {
            for (String color : COLORS) {
                String dyeItem = "minecraft:" + color + "_dye";
                String resultColor = color;

                createShapelessRecipe(piece, dyeItem, resultColor);
            }
        }

    }

    private void createShapelessRecipe(String piece, String dyeItem, String color) {
        String json = String.format(
                "{\n" +
                        "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                        "  \"category\": \"equipment\",\n" +
                        "  \"ingredients\": [\n" +
                        "    {\"item\": \"samurai_dynasty:netherite_samurai_%s\"},\n" +
                        "    {\"item\": \"%s\"}\n" +
                        "  ],\n" +
                        "  \"result\": {\n" +
                        "    \"id\": \"samurai_dynasty:netherite_samurai_%s\",\n" +
                        "    \"components\": {\n" +
                        "      \"minecraft:base_color\": \"%s\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}", piece, dyeItem, piece, color);

        saveRecipeJson(json, piece, color);
    }

    private void saveRecipeJson(String json, String piece, String color) {
        Path projectDir = Paths.get("").toAbsolutePath();
        Path recipeDir = projectDir.resolve("src/main/resources/data/samurai_dynasty/recipe/dyed_armor");

        File recipeDirFile = recipeDir.toFile();
        if (!recipeDirFile.exists()) {
            recipeDirFile.mkdirs();
            System.out.println("Verzeichnis wurde erstellt: " + recipeDirFile.getAbsolutePath());
        }

        File recipeFile = new File(recipeDirFile, "netherite_samurai_" + piece + "_from_dye_" + color + ".json");

        System.out.println("Speichern des Rezepts in: " + recipeFile.getAbsolutePath());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(recipeFile))) {
            writer.write(json);
            System.out.println("Rezept für " + piece + " in Farbe " + color + " wurde erstellt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}