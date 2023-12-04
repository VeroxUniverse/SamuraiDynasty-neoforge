package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.bloodmagic;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.LivingSamuraiArmorItem;

public class LivingSamuraiArmorModel extends GeoModel<LivingSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(LivingSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LivingSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/living_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LivingSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
