package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.silver;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.WhiteSamuraiArmorLightItem;

public class WhiteSamuraiArmorLightModel extends GeoModel<WhiteSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(WhiteSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/white_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteSamuraiArmorLightItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
