package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.quartz;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MaskQuartzSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.QuartzSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class MaskQuartzSamuraiArmorModel extends GeoModel<MaskQuartzSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MaskQuartzSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/mask_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaskQuartzSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/quartz_samurai_armor_textures_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaskQuartzSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
