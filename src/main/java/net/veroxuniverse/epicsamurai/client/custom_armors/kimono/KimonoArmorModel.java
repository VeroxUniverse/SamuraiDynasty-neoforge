package net.veroxuniverse.epicsamurai.client.custom_armors.kimono;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.KimonoArmorItem;

public class KimonoArmorModel extends GeoModel<KimonoArmorItem> {
    @Override
    public ResourceLocation getModelResource(KimonoArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kimono.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KimonoArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/kimono_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KimonoArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
