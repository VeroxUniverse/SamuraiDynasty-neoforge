package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.worldgen.ModConfiguredFeatures;
import net.veroxuniverse.samurai_dynasty.worldgen.ModPlacedFeatures;
import net.veroxuniverse.samurai_dynasty.worldgen.features.ModTreeConfiguredFeatures;
import net.veroxuniverse.samurai_dynasty.worldgen.features.ModTreePlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, context -> {
                ModConfiguredFeatures.bootstrap(context);

                ModTreeConfiguredFeatures.CONFIGURED_FEATURES_MOD.forEach((configuredFeatureResourceKey, configuredFeatureFactory) ->
                        context.register(configuredFeatureResourceKey, configuredFeatureFactory.generate(context))
                );
            })

            .add(Registries.PLACED_FEATURE, context -> {
                ModPlacedFeatures.bootstrap(context);

                ModTreePlacedFeatures.PLACED_FEATURES_MOD.forEach((placedFeatureResourceKey, placedFeatureFactory) ->
                        context.register(placedFeatureResourceKey, placedFeatureFactory.generate(context.lookup(Registries.CONFIGURED_FEATURE)))
                );
            });

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SamuraiDynastyMod.MOD_ID));
    }
}