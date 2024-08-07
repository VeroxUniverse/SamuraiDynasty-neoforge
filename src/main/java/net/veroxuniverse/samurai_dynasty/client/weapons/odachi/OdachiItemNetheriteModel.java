package net.veroxuniverse.samurai_dynasty.client.weapons.odachi;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.OdachiNetheriteItem;

public class OdachiItemNetheriteModel extends GeoModel<OdachiNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(OdachiNetheriteItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/odachi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OdachiNetheriteItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/weapon/odachi_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OdachiNetheriteItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
