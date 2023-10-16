package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.cataclysm;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.IgnitiumSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class IgnitiumSamuraiArmorModel extends GeoModel<IgnitiumSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(IgnitiumSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IgnitiumSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/ignitium_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IgnitiumSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
