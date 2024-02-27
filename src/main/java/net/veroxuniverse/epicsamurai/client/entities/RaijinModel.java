package net.veroxuniverse.epicsamurai.client.entities;

import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.RaijinEntity;

public class RaijinModel extends GeoModel<RaijinEntity> {
    @Override
    public ResourceLocation getModelResource(RaijinEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/raijin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RaijinEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/raijin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RaijinEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/raijin.animation.json");
    }

    @Override
    public void setCustomAnimations(RaijinEntity animatable, long instanceId, AnimationState<RaijinEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}