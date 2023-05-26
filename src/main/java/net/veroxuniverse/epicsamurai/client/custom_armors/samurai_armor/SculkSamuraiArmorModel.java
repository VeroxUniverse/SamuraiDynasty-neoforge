package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.AmethystSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.SculkSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SculkSamuraiArmorModel extends AnimatedGeoModel<SculkSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SculkSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_two.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/sculk_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
