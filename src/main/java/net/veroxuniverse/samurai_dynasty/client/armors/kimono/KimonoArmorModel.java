package net.veroxuniverse.samurai_dynasty.client.armors.kimono;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.KimonoArmorItem;

public class KimonoArmorModel extends GeoModel<KimonoArmorItem> {
    @Override
    public ResourceLocation getModelResource(KimonoArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/kimono.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KimonoArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/kimono_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KimonoArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
