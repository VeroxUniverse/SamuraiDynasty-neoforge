package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.create;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BrassSamuraiArmorModel extends AnimatedGeoModel<BrassSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(BrassSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_two.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BrassSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/brass_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BrassSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
