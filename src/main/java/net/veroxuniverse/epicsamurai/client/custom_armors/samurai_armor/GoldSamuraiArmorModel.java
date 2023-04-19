package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.DiamondSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.GoldSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldSamuraiArmorModel extends AnimatedGeoModel<GoldSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/gold_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
