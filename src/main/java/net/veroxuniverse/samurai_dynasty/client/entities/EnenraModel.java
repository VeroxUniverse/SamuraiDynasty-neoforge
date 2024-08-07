package net.veroxuniverse.samurai_dynasty.client.entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;

public class EnenraModel extends GeoModel<EnenraEntity> {
    @Override
    public ResourceLocation getModelResource(EnenraEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/enenra.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnenraEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/enenra.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnenraEntity animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/enenra.animation.json");
    }

    @Override
    public void setCustomAnimations(EnenraEntity animatable, long instanceId, AnimationState<EnenraEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}