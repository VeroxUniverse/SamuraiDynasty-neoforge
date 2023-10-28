package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.TwoTailedFox;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

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