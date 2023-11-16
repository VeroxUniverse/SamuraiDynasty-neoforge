package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.bloodmagic;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.LivingSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

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
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
