package net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KabutowariNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.KatanaNetheriteItem;

public class KabutowariItemNetheriteModel extends GeoModel<KabutowariNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(KabutowariNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/kabutowari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KabutowariNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/kabutowari_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KabutowariNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
