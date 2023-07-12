package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.FujinEntity;
import net.veroxuniverse.epicsamurai.entity.custom.RaijinEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class RaijinModel extends GeoModel<RaijinEntity> {
    @Override
    public ResourceLocation getModelResource(RaijinEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/raijin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RaijinEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/raijin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RaijinEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/raijin.animation.json");
    }

    @Override
    public void setCustomAnimations(RaijinEntity animatable, long instanceId, AnimationState<RaijinEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}