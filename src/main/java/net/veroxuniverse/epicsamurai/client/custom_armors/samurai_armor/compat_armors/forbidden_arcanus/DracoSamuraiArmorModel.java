package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.forbidden_arcanus;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.DracoSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.TyrSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DracoSamuraiArmorModel extends AnimatedGeoModel<DracoSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelLocation(DracoSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_two.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DracoSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/draco_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DracoSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
