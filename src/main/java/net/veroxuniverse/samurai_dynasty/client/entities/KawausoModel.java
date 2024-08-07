package net.veroxuniverse.samurai_dynasty.client.entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KawausoEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;

public class KawausoModel extends GeoModel<KawausoEntity> {
    @Override
    public ResourceLocation getModelResource(KawausoEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/kawauso.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KawausoEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/kawauso.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KawausoEntity animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/kawauso.animation.json");
    }

    @Override
    public void setCustomAnimations(KawausoEntity animatable, long instanceId, AnimationState<KawausoEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}