package net.veroxuniverse.samurai_dynasty.client.armors.steel_armor;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelArmorItem;

public class SteelArmorModel extends GeoModel<SteelArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SteelArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/steel_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/armor/steel_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
