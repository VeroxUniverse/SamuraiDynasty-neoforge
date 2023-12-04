package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.kitsune_mask;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.KitsuneMaskArmorItem;

public class KitsuneMaskArmorModel extends GeoModel<KitsuneMaskArmorItem> {
    @Override
    public ResourceLocation  getModelResource(KitsuneMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kitsune_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KitsuneMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/kitsune_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KitsuneMaskArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
