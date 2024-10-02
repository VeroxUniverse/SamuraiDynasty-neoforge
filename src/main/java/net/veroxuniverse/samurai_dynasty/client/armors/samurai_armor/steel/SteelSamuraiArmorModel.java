package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;
public class SteelSamuraiArmorModel extends GeoModel<SteelSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SteelSamuraiArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelSamuraiArmorItem object) {
        return null;
        //return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/armor/steel_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelSamuraiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
