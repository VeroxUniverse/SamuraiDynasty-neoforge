package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ronin;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.LightSamuraiArmorItem;

public class RoninSamuraiArmorModel extends GeoModel<LightSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(LightSamuraiArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/light_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LightSamuraiArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/light_samurai.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LightSamuraiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
