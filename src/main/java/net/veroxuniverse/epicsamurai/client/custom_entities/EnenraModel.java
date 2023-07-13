package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EnenraModel extends AnimatedGeoModel<EnenraEntity> {
    @Override
    public ResourceLocation getModelLocation(EnenraEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/enenra.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EnenraEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/enenra.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EnenraEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/enenra.animation.json");
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public void setLivingAnimations(EnenraEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");


        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}