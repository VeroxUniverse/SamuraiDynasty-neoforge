package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.gold;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GoldSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GoldSamuraiArmorModel extends GeoModel<GoldSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
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
