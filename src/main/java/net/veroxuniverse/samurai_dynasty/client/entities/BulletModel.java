package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.BulletEntity;

public class BulletModel extends GeoModel<BulletEntity> {
    @Override
    public ResourceLocation getModelResource(BulletEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/bullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BulletEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/items/bullet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BulletEntity animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

    @Override
    public RenderType getRenderType(BulletEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }

}