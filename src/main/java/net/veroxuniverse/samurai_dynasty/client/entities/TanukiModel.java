package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.TanukiEntity;

public class TanukiModel extends GeoModel<TanukiEntity> {
    @Override
    public ResourceLocation getModelResource(TanukiEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/tanuki.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TanukiEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/tanuki/akaname.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TanukiEntity animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/tanuki.animation.json");
    }

    @Override
    public void setCustomAnimations(TanukiEntity animatable, long instanceId, AnimationState<TanukiEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}