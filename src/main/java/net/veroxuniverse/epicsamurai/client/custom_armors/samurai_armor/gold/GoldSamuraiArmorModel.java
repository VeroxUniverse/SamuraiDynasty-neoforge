package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.gold;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GoldSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldSamuraiArmorModel extends AnimatedGeoModel<GoldSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelLocation(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/gold_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GoldSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
