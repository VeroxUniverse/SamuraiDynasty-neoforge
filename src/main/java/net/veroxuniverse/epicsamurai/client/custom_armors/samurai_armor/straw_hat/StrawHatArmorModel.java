package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.straw_hat;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.StrawHatArmorItem;

public class StrawHatArmorModel extends GeoModel<StrawHatArmorItem> {
    @Override
    public ResourceLocation  getModelResource(StrawHatArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/straw_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrawHatArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/straw_hat_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StrawHatArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
