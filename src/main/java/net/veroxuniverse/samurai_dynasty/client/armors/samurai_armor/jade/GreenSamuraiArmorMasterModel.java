package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.jade;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.GreenSamuraiArmorMasterItem;

public class GreenSamuraiArmorMasterModel extends GeoModel<GreenSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(GreenSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/green_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
