package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.silver;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.WhiteSamuraiArmorMasterItem;

public class WhiteSamuraiArmorMasterModel extends GeoModel<WhiteSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(WhiteSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/white_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
