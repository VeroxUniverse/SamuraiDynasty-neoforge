package net.veroxuniverse.epicsamurai.client.entities;

import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.TwoTailedFox;

public class TwoTailedModel extends GeoModel<TwoTailedFox> {
    @Override
    public ResourceLocation getModelResource(TwoTailedFox object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kitsune_small.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TwoTailedFox object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune_small.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TwoTailedFox animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/kitsune_small.animation.json");
    }

    @Override
    public void setCustomAnimations(TwoTailedFox animatable, long instanceId, AnimationState<TwoTailedFox> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}