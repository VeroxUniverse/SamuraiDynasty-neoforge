package net.veroxuniverse.samurai_dynasty.client.weapons.odachi;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.OdachiItem;

public class OdachiItemModel extends GeoModel<OdachiItem> {
    @Override
    public ResourceLocation getModelResource(OdachiItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/odachi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OdachiItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/weapon/odachi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OdachiItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
