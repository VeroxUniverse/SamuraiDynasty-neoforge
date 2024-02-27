package net.veroxuniverse.epicsamurai.client.weapons.tonbukiri;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.TonbukiriItem;

public class TonbukiriItemModel extends GeoModel<TonbukiriItem> {
    @Override
    public ResourceLocation getModelResource(TonbukiriItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/tonbukiri.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TonbukiriItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/tonbukiri.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TonbukiriItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
