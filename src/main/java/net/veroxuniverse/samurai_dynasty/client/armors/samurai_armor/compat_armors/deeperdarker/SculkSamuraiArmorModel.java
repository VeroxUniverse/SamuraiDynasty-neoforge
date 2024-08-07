package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.deeperdarker;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.SculkSamuraiArmorItem;

public class SculkSamuraiArmorModel extends GeoModel<SculkSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SculkSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/sculk_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
