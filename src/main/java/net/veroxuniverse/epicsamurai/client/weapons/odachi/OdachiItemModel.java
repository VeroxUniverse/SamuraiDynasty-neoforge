package net.veroxuniverse.epicsamurai.client.weapons.odachi;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.OdachiItem;

public class OdachiItemModel extends GeoModel<OdachiItem> {
    @Override
    public ResourceLocation getModelResource(OdachiItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/odachi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OdachiItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/odachi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OdachiItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
