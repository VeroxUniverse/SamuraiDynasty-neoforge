package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.aquamarine;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.BlueSamuraiArmorMasterItem;

public class BlueSamuraiArmorMasterModel extends GeoModel<BlueSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(BlueSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/blue_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
