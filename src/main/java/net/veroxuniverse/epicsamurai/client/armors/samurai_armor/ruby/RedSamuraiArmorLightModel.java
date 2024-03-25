package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.ruby;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.RedSamuraiArmorLightItem;

public class RedSamuraiArmorLightModel extends GeoModel<RedSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(RedSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/red_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
