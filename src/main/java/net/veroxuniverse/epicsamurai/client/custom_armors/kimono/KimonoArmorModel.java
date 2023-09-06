package net.veroxuniverse.epicsamurai.client.custom_armors.kimono;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.KimonoArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class KimonoArmorModel extends GeoModel<KimonoArmorItem> {
    @Override
    public ResourceLocation getModelResource(KimonoArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kimono.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KimonoArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/kimono_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KimonoArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
