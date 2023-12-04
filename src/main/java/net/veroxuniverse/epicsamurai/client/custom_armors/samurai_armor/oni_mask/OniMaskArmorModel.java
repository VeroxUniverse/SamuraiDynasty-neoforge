package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.oni_mask;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.OniMaskArmorItem;

public class OniMaskArmorModel extends GeoModel<OniMaskArmorItem> {
    @Override
    public ResourceLocation  getModelResource(OniMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/oni_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OniMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/oni_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OniMaskArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
