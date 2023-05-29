package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.silver;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.WhiteSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WhiteSamuraiArmorModel extends AnimatedGeoModel<WhiteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(WhiteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/white_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
