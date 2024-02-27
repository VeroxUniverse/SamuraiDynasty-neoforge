package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.straw_hat;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MaskStrawHatArmorItem;

public class MaskStrawHatArmorModel extends GeoModel<MaskStrawHatArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MaskStrawHatArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/straw_hat_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaskStrawHatArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/mask_straw_hat_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaskStrawHatArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
