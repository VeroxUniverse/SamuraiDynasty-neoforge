package net.veroxuniverse.epicsamurai.client.weapons.tetsubo;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.TetsuboNetheriteItem;

public class TetsuboItemNetheriteModel extends GeoModel<TetsuboNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(TetsuboNetheriteItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/tetsubo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TetsuboNetheriteItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/tetsubo_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TetsuboNetheriteItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
