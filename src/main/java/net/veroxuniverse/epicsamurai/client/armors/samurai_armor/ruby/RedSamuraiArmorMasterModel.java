package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.ruby;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.RedSamuraiArmorMasterItem;

public class RedSamuraiArmorMasterModel extends GeoModel<RedSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(RedSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/red_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
