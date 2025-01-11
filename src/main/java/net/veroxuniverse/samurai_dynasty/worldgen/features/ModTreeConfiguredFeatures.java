package net.veroxuniverse.samurai_dynasty.worldgen.features;

import com.google.common.collect.ImmutableList;
import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TYGFeatures;
import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.configurations.TreeFromStructureNBTConfig;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.worldgen.features.decorators.LeavesAwareAttachedToLogsDecorator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModTreeConfiguredFeatures {

    public static ResourceLocation createLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, path);
    }

    public static final Supplier<LeavesAwareAttachedToLogsDecorator> SPIRIT_WOOD_BRANCH = () -> new LeavesAwareAttachedToLogsDecorator(0.65F, 0, 1, SimpleStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_BRANCH.get().defaultBlockState()), 2, List.of(Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.EAST));
    public static final AlterGroundDecorator MOSS_BLOCK = new AlterGroundDecorator(SimpleStateProvider.simple(Blocks.MOSS_BLOCK));


    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, ConfiguredFeatureFactory> CONFIGURED_FEATURES_MOD = new Reference2ObjectOpenHashMap<>();

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREE1 = createConfiguredFeature("spirit_wood_tree1", TYGFeatures.TREE_FROM_NBT_V1, configuredFeatureBootstapContext -> {
        return new TreeFromStructureNBTConfig(
                createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_trunk1"),
                createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_canopy1"),
                UniformInt.of(5, 6),
                BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD.get()),
                BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()),
                BlocksRegistry.SPIRIT_WOOD.get(), BlocksRegistry.SPIRIT_WOOD_LEAVES.get(), BlockTags.DIRT,
                3,
                ImmutableList.of(MOSS_BLOCK)
        );
    });

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREE2 = createConfiguredFeature("spirit_wood_tree2", TYGFeatures.TREE_FROM_NBT_V1, configuredFeatureBootstapContext -> {
        return new TreeFromStructureNBTConfig(
                createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_trunk2"),
                createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_canopy2"),
                UniformInt.of(5, 6),
                BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD.get()),
                BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()),
                BlocksRegistry.SPIRIT_WOOD.get(), BlocksRegistry.SPIRIT_WOOD_LEAVES.get(), BlockTags.DIRT,
                3,
                ImmutableList.of(MOSS_BLOCK)
        );
    });

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREE3 = createConfiguredFeature("spirit_wood_tree3", TYGFeatures.TREE_FROM_NBT_V1, configuredFeatureBootstapContext -> {
        return new TreeFromStructureNBTConfig(
                createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_trunk3"),
                createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_canopy3"),
                UniformInt.of(5, 10),
                BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD.get()),
                BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()),
                BlocksRegistry.SPIRIT_WOOD.get(), BlocksRegistry.SPIRIT_WOOD_LEAVES.get(), BlockTags.DIRT,
                3,
                ImmutableList.of(MOSS_BLOCK)
        );
    });

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREES = createConfiguredFeature("spirit_wood_trees",
            Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstrapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstrapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(createPlacedFeatureDirect(lookup.getOrThrow(SPIRIT_WOOD_TREE2)), 0.15F),
                        new WeightedPlacedFeature(createPlacedFeatureDirect(lookup.getOrThrow(SPIRIT_WOOD_TREE3)), 0.35F)),
                        createPlacedFeatureDirect(lookup.getOrThrow(SPIRIT_WOOD_TREE1)));
            }
    );

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> ResourceKey<ConfiguredFeature<?, ?>> createConfiguredFeature(String id, Supplier<? extends F> feature, Function<BootstrapContext<ConfiguredFeature<?, ?>>, ? extends FC> config) {
        ResourceLocation location = createLocation(id);

        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureResourceKey = ResourceKey.create(Registries.CONFIGURED_FEATURE, location);

        CONFIGURED_FEATURES_MOD.put(configuredFeatureResourceKey, configuredFeatureHolderGetter -> new ConfiguredFeature<>(feature.get(), config.apply(configuredFeatureHolderGetter)));

        return configuredFeatureResourceKey;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> ResourceKey<ConfiguredFeature<?, ?>> createConfiguredFeature(String id, F feature, Function<BootstrapContext<ConfiguredFeature<?, ?>>, ? extends FC> config) {
        ResourceLocation location = createLocation(id);

        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureResourceKey = ResourceKey.create(Registries.CONFIGURED_FEATURE, location);

        CONFIGURED_FEATURES_MOD.put(configuredFeatureResourceKey, configuredFeatureHolderGetter -> new ConfiguredFeature<>(feature, config.apply(configuredFeatureHolderGetter)));

        return configuredFeatureResourceKey;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> ResourceKey<ConfiguredFeature<?, ?>> createConfiguredFeature(String id, Supplier<? extends F> feature, Supplier<? extends FC> config) {
        ResourceLocation location = createLocation(id);

        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureResourceKey = ResourceKey.create(Registries.CONFIGURED_FEATURE, location);

        CONFIGURED_FEATURES_MOD.put(configuredFeatureResourceKey, configuredFeatureHolderGetter -> new ConfiguredFeature<>(feature.get(), config.get()));

        return configuredFeatureResourceKey;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> ResourceKey<ConfiguredFeature<?, ?>> createConfiguredFeature(String id, F feature, Supplier<? extends FC> config) {
        ResourceLocation location = createLocation(id);

        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureResourceKey = ResourceKey.create(Registries.CONFIGURED_FEATURE, location);

        CONFIGURED_FEATURES_MOD.put(configuredFeatureResourceKey, configuredFeatureHolderGetter -> new ConfiguredFeature<>(feature, config.get()));

        return configuredFeatureResourceKey;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> createConfiguredFeature(F feature, Supplier<? extends FC> config) {
        return Holder.direct(new ConfiguredFeature<>(feature, config.get()));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> createConfiguredFeature(F feature, FC config) {
        return Holder.direct(new ConfiguredFeature<>(feature, config));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> createConfiguredFeature(Supplier<F> feature, Supplier<FC> config) {
        return Holder.direct(new ConfiguredFeature<>(feature.get(), config.get()));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeatureDirect(Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
        return createPlacedFeatureDirect(feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeatureDirect(Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers) {
        return Holder.direct(new PlacedFeature(feature, placementModifiers));
    }

    public static void register() {
    }


    @FunctionalInterface
    public interface ConfiguredFeatureFactory {
        ConfiguredFeature<?, ?> generate(BootstrapContext<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter);
    }
}