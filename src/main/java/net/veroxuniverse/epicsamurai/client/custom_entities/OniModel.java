package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import net.veroxuniverse.epicsamurai.entity.custom.OniEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OniModel extends AnimatedGeoModel<OniEntity> {
    @Override
    public ResourceLocation getModelResource(OniEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/oni.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OniEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/oni.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OniEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/oni.animation.json");
    }
}