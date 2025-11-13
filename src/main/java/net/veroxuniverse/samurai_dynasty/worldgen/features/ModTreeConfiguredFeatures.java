package net.veroxuniverse.samurai_dynasty.worldgen.features;

import com.google.common.collect.ImmutableList;
import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.TYGFeatures;
import dev.corgitaco.ohthetreesyoullgrow.world.level.levelgen.feature.configurations.TreeFromStructureNBTConfig;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModTreeConfiguredFeatures {

    public static ResourceLocation createLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, path);
    }

    public static AlterGroundDecorator spiritMossBlockDecorator() {
        return new AlterGroundDecorator(SimpleStateProvider.simple(BlocksRegistry.SPIRIT_MOSS_BLOCK.get().defaultBlockState()));
    }

    public static AlterGroundDecorator mossBlockDecorator() {
        return new AlterGroundDecorator(SimpleStateProvider.simple(Blocks.MOSS_BLOCK.defaultBlockState()));
    }

    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, ConfiguredFeatureFactory> CONFIGURED_FEATURES_MOD = new Reference2ObjectOpenHashMap<>();

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREE1 =
            createConfiguredFeature("spirit_wood_tree1", TYGFeatures.TREE_FROM_NBT_V1, ctx -> new TreeFromStructureNBTConfig.Builder()
                    .baseLocation(createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_trunk1"))
                    .canopyLocation(createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_canopy1"))
                    .height(UniformInt.of(5, 6))
                    .logProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD.get()))
                    .leavesProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()))
                    .logTarget(Set.of(BlocksRegistry.SPIRIT_WOOD.get()))
                    .leavesTarget(Set.of(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()))
                    .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                    .leavesPlacementFilter(BlockPredicate.replaceable())
                    .maxLogDepth(3)
                    .treeDecorators(ImmutableList.of(spiritMossBlockDecorator()))
                    .placeFromNBT(Set.of(
                            BlocksRegistry.SPIRIT_WOOD_BRANCH.get(),
                            BlocksRegistry.SPIRIT_WOOD_ROOTS.get()
                    ))
                    .isSapling(false)
                    .orientation(TreeFromStructureNBTConfig.Orientation.STANDARD)
                    .build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREE2 =
            createConfiguredFeature("spirit_wood_tree2", TYGFeatures.TREE_FROM_NBT_V1, ctx -> new TreeFromStructureNBTConfig.Builder()
                    .baseLocation(createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_trunk2"))
                    .canopyLocation(createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_canopy2"))
                    .height(UniformInt.of(5, 6))
                    .logProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD.get()))
                    .leavesProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()))
                    .logTarget(Set.of(BlocksRegistry.SPIRIT_WOOD.get()))
                    .leavesTarget(Set.of(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()))
                    .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                    .leavesPlacementFilter(BlockPredicate.replaceable())
                    .maxLogDepth(3)
                    .treeDecorators(ImmutableList.of(spiritMossBlockDecorator()))
                    .isSapling(false)
                    .orientation(TreeFromStructureNBTConfig.Orientation.STANDARD)
                    .build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_WOOD_TREE3 =
            createConfiguredFeature("spirit_wood_tree3", TYGFeatures.TREE_FROM_NBT_V1, ctx -> new TreeFromStructureNBTConfig.Builder()
                    .baseLocation(createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_trunk3"))
                    .canopyLocation(createLocation("features/trees/spirit_wood_tree/spirit_wood_tree_canopy3"))
                    .height(UniformInt.of(5, 10))
                    .logProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD.get()))
                    .leavesProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()))
                    .logTarget(Set.of(BlocksRegistry.SPIRIT_WOOD.get()))
                    .leavesTarget(Set.of(BlocksRegistry.SPIRIT_WOOD_LEAVES.get()))
                    .growableOn(BlockPredicate.matchesTag(BlockTags.DIRT))
                    .leavesPlacementFilter(BlockPredicate.replaceable())
                    .maxLogDepth(3)
                    .treeDecorators(ImmutableList.of(spiritMossBlockDecorator()))
                    .isSapling(false)
                    .orientation(TreeFromStructureNBTConfig.Orientation.STANDARD)
                    .build());

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

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_BLOSSOM_TREE1 =
            createConfiguredFeature("spirit_blossom_tree1", TYGFeatures.TREE_FROM_NBT_V1, ctx -> new TreeFromStructureNBTConfig.Builder()
                    .baseLocation(createLocation("features/trees/spirit_blossom_tree/spirit_blossom_tree_trunk1"))
                    .canopyLocation(createLocation("features/trees/spirit_blossom_tree/spirit_blossom_tree_canopy1"))
                    .height(UniformInt.of(7, 8))
                    .logProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get()))
                    .leavesProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_BLOSSOM_LEAVES.get()))
                    .logTarget(Set.of(BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get()))
                    .leavesTarget(Set.of(BlocksRegistry.SPIRIT_BLOSSOM_LEAVES.get()))
                    .growableOn(BlockPredicate.anyOf(
                            BlockPredicate.matchesTag(BlockTags.DIRT),
                            BlockPredicate.matchesBlocks(Blocks.MOSS_BLOCK))
                    )
                    .leavesPlacementFilter(BlockPredicate.replaceable())
                    .maxLogDepth(3)
                    .treeDecorators(ImmutableList.of(mossBlockDecorator()))
                    .isSapling(false)
                    .orientation(TreeFromStructureNBTConfig.Orientation.STANDARD)
                    .build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_BLOSSOM_TREE2 =
            createConfiguredFeature("spirit_blossom_tree2", TYGFeatures.TREE_FROM_NBT_V1, ctx -> new TreeFromStructureNBTConfig.Builder()
                    .baseLocation(createLocation("features/trees/spirit_blossom_tree/spirit_blossom_tree_trunk2"))
                    .canopyLocation(createLocation("features/trees/spirit_blossom_tree/spirit_blossom_tree_canopy2"))
                    .height(UniformInt.of(5, 8))
                    .logProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get()))
                    .leavesProvider(BlockStateProvider.simple(BlocksRegistry.SPIRIT_BLOSSOM_LEAVES.get()))
                    .logTarget(Set.of(BlocksRegistry.SPIRIT_BLOSSOM_WOOD.get()))
                    .leavesTarget(Set.of(BlocksRegistry.SPIRIT_BLOSSOM_LEAVES.get()))
                    .growableOn(BlockPredicate.anyOf(
                            BlockPredicate.matchesTag(BlockTags.DIRT),
                            BlockPredicate.matchesBlocks(Blocks.MOSS_BLOCK))
                    )
                    .leavesPlacementFilter(BlockPredicate.replaceable())
                    .maxLogDepth(3)
                    .treeDecorators(ImmutableList.of(mossBlockDecorator()))
                    .isSapling(false)
                    .orientation(TreeFromStructureNBTConfig.Orientation.STANDARD)
                    .build());

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_BLOSSOM_TREES = createConfiguredFeature("spirit_blossom_trees",
            Feature.RANDOM_SELECTOR,
            (configuredFeatureBootstrapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstrapContext.lookup(Registries.CONFIGURED_FEATURE);
                return new RandomFeatureConfiguration(ImmutableList.of(
                        new WeightedPlacedFeature(createPlacedFeatureDirect(lookup.getOrThrow(SPIRIT_BLOSSOM_TREE1)), 0.35F)),
                        createPlacedFeatureDirect(lookup.getOrThrow(SPIRIT_BLOSSOM_TREE2)));
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