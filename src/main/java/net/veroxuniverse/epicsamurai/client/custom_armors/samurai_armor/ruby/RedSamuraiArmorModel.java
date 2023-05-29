package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.ruby;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.RedSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedSamuraiArmorModel extends AnimatedGeoModel<RedSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(RedSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/red_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
