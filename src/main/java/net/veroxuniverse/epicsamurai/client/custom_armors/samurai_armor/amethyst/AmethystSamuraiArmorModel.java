package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.AmethystSamuraiArmorItem;

public class AmethystSamuraiArmorModel extends GeoModel<AmethystSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(AmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/amethyst_samurai_armor_textures_new.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AmethystSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
