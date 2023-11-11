package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.eldrithcend;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.EtyriteSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EtyriteSamuraiArmorModel extends GeoModel<EtyriteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(EtyriteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EtyriteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/etyrite_samurai_armor_textures_gray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EtyriteSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
