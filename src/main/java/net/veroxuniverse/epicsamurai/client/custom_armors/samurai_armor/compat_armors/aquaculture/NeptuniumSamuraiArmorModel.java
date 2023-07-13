package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.aquaculture;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class NeptuniumSamuraiArmorModel extends GeoModel<NeptuniumSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(NeptuniumSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NeptuniumSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/neptunium_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NeptuniumSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
