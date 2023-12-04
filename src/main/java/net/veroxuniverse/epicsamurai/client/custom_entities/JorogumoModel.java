package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.JorogumoEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;

public class JorogumoModel extends GeoModel<JorogumoEntity> {
    @Override
    public ResourceLocation getModelResource(JorogumoEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/jorogumo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JorogumoEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/jorogumo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JorogumoEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/jorogumo.animation.json");
    }

    @Override
    public void setCustomAnimations(JorogumoEntity animatable, long instanceId, AnimationState<JorogumoEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}