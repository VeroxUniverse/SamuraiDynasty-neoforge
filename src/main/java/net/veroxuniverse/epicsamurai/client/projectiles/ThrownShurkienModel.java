package net.veroxuniverse.epicsamurai.client.projectiles;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.ThrownShurikenEntity;

public class ThrownShurkienModel extends GeoModel<ThrownShurikenEntity> {
    @Override
    public ResourceLocation getModelResource(ThrownShurikenEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/shuriken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThrownShurikenEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/item/shuriken.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThrownShurikenEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }
}
