package net.veroxuniverse.epicsamurai.client.custom_armors.steel_armor;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.SteelArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SteelArmorModel extends AnimatedGeoModel<SteelArmorItem> {
    @Override
    public ResourceLocation  getModelLocation(SteelArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/steel_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SteelArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/steel_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SteelArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
