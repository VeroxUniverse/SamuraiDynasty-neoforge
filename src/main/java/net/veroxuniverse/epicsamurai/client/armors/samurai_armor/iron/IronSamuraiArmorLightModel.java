package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.iron;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.IronSamuraiArmorLightItem;

public class IronSamuraiArmorLightModel extends GeoModel<IronSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(IronSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/iron_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
