package net.veroxuniverse.epicsamurai.client.weapons.tanegashima;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.ranged.GunItem;

public class TanegashimaItemModel extends GeoModel<GunItem> {
    @Override
    public ResourceLocation getModelResource(GunItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/tanegashima.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GunItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/tanegashima.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GunItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/tanegashima.animation.json");
    }

}
