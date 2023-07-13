package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.FujinEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FujinModel extends GeoModel<FujinEntity> {
    @Override
    public ResourceLocation getModelResource(FujinEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/fujin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FujinEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/fujin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FujinEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/fujin.animation.json");
    }

    @Override
    public void setCustomAnimations(FujinEntity animatable, long instanceId, AnimationState<FujinEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}