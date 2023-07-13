package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.forbidden_arcanus;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.TyrSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TyrSamuraiArmorModel extends AnimatedGeoModel<TyrSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelLocation(TyrSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_two.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TyrSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/tyr_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TyrSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
