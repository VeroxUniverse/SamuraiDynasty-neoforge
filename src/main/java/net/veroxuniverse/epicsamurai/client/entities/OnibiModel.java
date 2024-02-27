package net.veroxuniverse.epicsamurai.client.entities;

import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OnibiEntity;

public class OnibiModel extends GeoModel<OnibiEntity> {
    @Override
    public ResourceLocation getModelResource(OnibiEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/spirit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OnibiEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/spirit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OnibiEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/spirit.animation.json");
    }

    @Override
    public void setCustomAnimations(OnibiEntity animatable, long instanceId, AnimationState<OnibiEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }

}