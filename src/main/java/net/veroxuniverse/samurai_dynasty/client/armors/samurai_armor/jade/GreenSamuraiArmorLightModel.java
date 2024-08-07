package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.jade;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.GreenSamuraiArmorLightItem;

public class GreenSamuraiArmorLightModel extends GeoModel<GreenSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(GreenSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/green_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenSamuraiArmorLightItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
