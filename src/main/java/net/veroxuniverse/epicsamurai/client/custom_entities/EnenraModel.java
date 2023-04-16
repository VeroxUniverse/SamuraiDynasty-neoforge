package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnenraModel extends AnimatedGeoModel<EnenraEntity> {
    @Override
    public ResourceLocation getModelResource(EnenraEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/enenra.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnenraEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/enenra.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnenraEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/enenra.animation.json");
    }
}