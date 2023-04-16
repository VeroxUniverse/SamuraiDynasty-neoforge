package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AkanameModel extends AnimatedGeoModel<AkanameEntity> {
    @Override
    public ResourceLocation getModelResource(AkanameEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/akaname.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AkanameEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/akaname.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AkanameEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/akaname.animation.json");
    }
}