package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;

public class KitsuneModel extends GeoModel<KitsuneEntity> {
    @Override
    public ResourceLocation getModelResource(KitsuneEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kitsune.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KitsuneEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KitsuneEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/kitsune.animation.json");
    }

    @Override
    public void setCustomAnimations(KitsuneEntity animatable, long instanceId, AnimationState<KitsuneEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}