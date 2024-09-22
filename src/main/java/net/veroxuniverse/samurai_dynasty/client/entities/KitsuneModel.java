package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.client.model.data.EntityModelData;
import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KitsuneEntity;

public class KitsuneModel extends GeoModel<KitsuneEntity> {
    @Override
    public ResourceLocation getModelResource(KitsuneEntity object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/kitsune.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KitsuneEntity object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/entity/kitsune.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KitsuneEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/kitsune.animation.json");
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