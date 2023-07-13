package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class KitsuneModel extends AnimatedGeoModel<KitsuneEntity> {
    @Override
    public ResourceLocation getModelLocation(KitsuneEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kitsune.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(KitsuneEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(KitsuneEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/kitsune.animation.json");
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public void setLivingAnimations(KitsuneEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");


        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}