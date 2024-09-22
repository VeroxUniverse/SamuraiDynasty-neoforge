package net.veroxuniverse.samurai_dynasty.client.projectiles;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.ThrownShurikenEntity;

public class ThrownShurkienModel extends GeoModel<ThrownShurikenEntity> {
    @Override
    public ResourceLocation getModelResource(ThrownShurikenEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/shuriken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThrownShurikenEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/item/shuriken.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThrownShurikenEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }
}
