package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.straw_hat;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.StrawHatArmorItem;

public class StrawHatArmorModel extends GeoModel<StrawHatArmorItem> {
    @Override
    public ResourceLocation  getModelResource(StrawHatArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/straw_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrawHatArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/armor/straw_hat_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StrawHatArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
