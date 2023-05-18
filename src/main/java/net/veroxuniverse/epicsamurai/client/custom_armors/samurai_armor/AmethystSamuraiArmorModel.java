package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.AmethystSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.RedSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AmethystSamuraiArmorModel extends AnimatedGeoModel<AmethystSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(AmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/amethyst_samurai_armor_textures_new.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AmethystSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
