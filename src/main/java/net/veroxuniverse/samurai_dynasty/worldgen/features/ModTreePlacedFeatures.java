package net.veroxuniverse.samurai_dynasty.worldgen.features;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

import java.util.*;
import java.util.function.Supplier;

public class ModTreePlacedFeatures {
    public static final Map<ResourceKey<PlacedFeature>, PlacedFeatureFactory> PLACED_FEATURES_MOD = new Reference2ObjectOpenHashMap<>();

    public static final ResourceKey<PlacedFeature> SPIRIT_WOOD_TREES = createPlacedFeature("spirit_wood_trees", ModTreeConfiguredFeatures.SPIRIT_WOOD_TREES, () -> VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.25F, 2)));

    public static ResourceLocation createLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, path);
    }

    @SafeVarargs
    private static ResourceKey<PlacedFeature> createPlacedFeature(String id, ResourceKey<ConfiguredFeature<?, ?>> feature, Supplier<PlacementModifier>... placementModifiers) {
        return createPlacedFeature(id, feature, () -> Arrays.stream(placementModifiers).map(Supplier::get).toList());
    }

    private static ResourceKey<PlacedFeature> createPlacedFeature(String id, ResourceKey<ConfiguredFeature<?, ?>> feature, Supplier<List<PlacementModifier>> placementModifiers) {
        ResourceLocation location = createLocation(id);

        ResourceKey<PlacedFeature> placedFeatureKey = ResourceKey.create(Registries.PLACED_FEATURE, location);

        PLACED_FEATURES_MOD.put(placedFeatureKey, configuredFeatureHolderGetter -> new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(feature), placementModifiers.get()));

        return placedFeatureKey;
    }

    public static void register() {
    }

    @FunctionalInterface
    public interface PlacedFeatureFactory {
        PlacedFeature generate(HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter);
    }
}