package net.veroxuniverse.epicsamurai.world.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.veroxuniverse.epicsamurai.world.feature.ModPlacedFeatures;

import java.util.List;

public class ModOreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.RUBY_ORE_PLACED);
        base.add(ModPlacedFeatures.JADE_ORE_PLACED);
        base.add(ModPlacedFeatures.ONYX_ORE_PLACED);
        base.add(ModPlacedFeatures.AQUAMARINE_ORE_PLACED);
        base.add(ModPlacedFeatures.SILVER_ORE_PLACED);
    }

}
