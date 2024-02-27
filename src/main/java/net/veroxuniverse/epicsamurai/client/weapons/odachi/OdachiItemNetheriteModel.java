package net.veroxuniverse.epicsamurai.client.weapons.odachi;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.OdachiNetheriteItem;

public class OdachiItemNetheriteModel extends GeoModel<OdachiNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(OdachiNetheriteItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/odachi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OdachiNetheriteItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/odachi_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OdachiNetheriteItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
