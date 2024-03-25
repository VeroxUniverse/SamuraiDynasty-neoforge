package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.onyx;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GraySamuraiArmorMasterItem;

public class GraySamuraiArmorMasterModel extends GeoModel<GraySamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(GraySamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GraySamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/gray_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GraySamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
