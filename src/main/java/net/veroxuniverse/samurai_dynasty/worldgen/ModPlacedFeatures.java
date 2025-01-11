package net.veroxuniverse.samurai_dynasty.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SPIDER_LILLY_PLACED_KEY = registerKey("spider_lilly_placed");
    public static final ResourceKey<PlacedFeature> SPIRIT_PETALS_PLACED_KEY = registerKey("spirit_petals_placed");
    public static final ResourceKey<PlacedFeature> MOSS_PLACED_KEY = registerKey("moss_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SPIDER_LILLY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPIDER_LILLY_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(5),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()));

        register(context, SPIRIT_PETALS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPIRIT_PETALS_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(5),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()));

        register(context, MOSS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSS_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(7),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
