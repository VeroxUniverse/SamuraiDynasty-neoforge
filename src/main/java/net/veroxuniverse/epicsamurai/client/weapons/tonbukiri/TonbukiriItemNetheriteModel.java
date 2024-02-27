package net.veroxuniverse.epicsamurai.client.weapons.tonbukiri;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.TonbukiriNetheriteItem;

public class TonbukiriItemNetheriteModel extends GeoModel<TonbukiriNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(TonbukiriNetheriteItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/tonbukiri.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TonbukiriNetheriteItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/tonbukiri_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TonbukiriNetheriteItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
