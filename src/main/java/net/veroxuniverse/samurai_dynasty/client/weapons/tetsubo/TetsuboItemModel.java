package net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.TetsuboItem;

public class TetsuboItemModel extends GeoModel<TetsuboItem> {
    @Override
    public ResourceLocation getModelResource(TetsuboItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/tetsubo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TetsuboItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/tetsubo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TetsuboItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
