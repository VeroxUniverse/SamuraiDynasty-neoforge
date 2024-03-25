package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.gold;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GoldSamuraiArmorMasterItem;

public class GoldSamuraiArmorMasterModel extends GeoModel<GoldSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(GoldSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/gold_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
