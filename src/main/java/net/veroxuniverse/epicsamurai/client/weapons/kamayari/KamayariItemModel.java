package net.veroxuniverse.epicsamurai.client.weapons.kamayari;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.KamayariItem;

public class KamayariItemModel extends GeoModel<KamayariItem> {
    @Override
    public ResourceLocation getModelResource(KamayariItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kamayari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KamayariItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/weapon/kamayari.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KamayariItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
