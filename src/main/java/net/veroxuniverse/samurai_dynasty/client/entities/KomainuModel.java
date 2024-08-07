package net.veroxuniverse.samurai_dynasty.client.entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KomainuEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;

public class KomainuModel extends GeoModel<KomainuEntity> {

    @Override
    public ResourceLocation getModelResource(KomainuEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/komainu.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KomainuEntity object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/komainu.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KomainuEntity animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/komainu.animation.json");
    }

    @Override
    public void setCustomAnimations(KomainuEntity animatable, long instanceId, AnimationState<KomainuEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}