package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.AmethystSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class AmethystSamuraiArmorModel extends GeoModel<AmethystSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(AmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/amethyst_samurai_armor_textures_new.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AmethystSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
