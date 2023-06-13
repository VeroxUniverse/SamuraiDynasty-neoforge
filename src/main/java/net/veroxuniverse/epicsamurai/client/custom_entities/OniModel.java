package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OniEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OniModel extends GeoModel<OniEntity> {
    @Override
    public ResourceLocation getModelResource(OniEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/oni.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OniEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/oni.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OniEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/oni.animation.json");
    }

    @Override
    public void setCustomAnimations(OniEntity animatable, long instanceId, AnimationState<OniEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }

}