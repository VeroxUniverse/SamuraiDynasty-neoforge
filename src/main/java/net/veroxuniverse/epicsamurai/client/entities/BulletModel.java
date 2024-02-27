package net.veroxuniverse.epicsamurai.client.entities;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.BulletEntity;

public class BulletModel extends GeoModel<BulletEntity> {
    @Override
    public ResourceLocation getModelResource(BulletEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BulletEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/items/bullet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BulletEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

    @Override
    public RenderType getRenderType(BulletEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }

}