package net.veroxuniverse.samurai_dynasty.worldgen.biomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class SpiritWoodForestRegion extends Region {

    public SpiritWoodForestRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry,
                          Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {

        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.COOL)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.span(
                        ParameterUtils.Continentalness.INLAND,
                        ParameterUtils.Continentalness.FAR_INLAND
                ))
                .erosion(ParameterUtils.Erosion.EROSION_3)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.HIGH_SLICE_NORMAL_ASCENDING)
                .build()
                .forEach(point -> builder.add(point, ModBiomes.SPIRIT_WOOD_FOREST));

        builder.build().forEach(mapper);
    }

}
