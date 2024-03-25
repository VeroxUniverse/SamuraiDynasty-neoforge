package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NetheriteSamuraiArmorLightItem;

public class NetheriteSamuraiArmorLightModel extends GeoModel<NetheriteSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(NetheriteSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/netherite_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
