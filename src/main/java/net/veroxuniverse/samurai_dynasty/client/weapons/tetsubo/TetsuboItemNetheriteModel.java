package net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.TetsuboNetheriteItem;

public class TetsuboItemNetheriteModel extends GeoModel<TetsuboNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(TetsuboNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/tetsubo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TetsuboNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/tetsubo_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TetsuboNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
