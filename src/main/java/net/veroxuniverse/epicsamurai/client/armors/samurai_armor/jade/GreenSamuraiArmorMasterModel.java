package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.jade;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GreenSamuraiArmorMasterItem;

public class GreenSamuraiArmorMasterModel extends GeoModel<GreenSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(GreenSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/green_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
