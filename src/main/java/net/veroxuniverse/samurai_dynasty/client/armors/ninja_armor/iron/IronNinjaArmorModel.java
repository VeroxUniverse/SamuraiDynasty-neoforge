package net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.iron;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.IronNinjaArmorItem;

public class IronNinjaArmorModel extends GeoModel<IronNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(IronNinjaArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronNinjaArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/ninja_iron_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronNinjaArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
