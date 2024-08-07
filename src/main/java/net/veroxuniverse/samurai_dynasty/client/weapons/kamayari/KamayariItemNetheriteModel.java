package net.veroxuniverse.samurai_dynasty.client.weapons.kamayari;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KamayariNetheriteItem;

public class KamayariItemNetheriteModel extends GeoModel<KamayariNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(KamayariNetheriteItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/kamayari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KamayariNetheriteItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/weapon/kamayari_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KamayariNetheriteItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
