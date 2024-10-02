package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.client.model.data.EntityModelData;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.AkanameEntity;

public class AkanameModel extends GeoModel<AkanameEntity> {
    @Override
    public ResourceLocation getModelResource(AkanameEntity object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/akaname.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AkanameEntity object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/entity/akaname.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AkanameEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/akaname.animation.json");
    }

    @Override
    public void setCustomAnimations(AkanameEntity animatable, long instanceId, AnimationState<AkanameEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}