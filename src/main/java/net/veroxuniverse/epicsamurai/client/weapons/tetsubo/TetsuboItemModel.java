package net.veroxuniverse.epicsamurai.client.weapons.tetsubo;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.TetsuboItem;

public class TetsuboItemModel extends GeoModel<TetsuboItem> {
    @Override
    public ResourceLocation getModelResource(TetsuboItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/tetsubo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TetsuboItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/tetsubo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TetsuboItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
