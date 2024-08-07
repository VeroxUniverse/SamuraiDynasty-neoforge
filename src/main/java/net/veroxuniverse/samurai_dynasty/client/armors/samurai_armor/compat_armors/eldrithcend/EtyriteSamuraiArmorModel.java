package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.eldrithcend;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.EtyriteSamuraiArmorItem;

public class EtyriteSamuraiArmorModel extends GeoModel<EtyriteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(EtyriteSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EtyriteSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/etyrite_samurai_armor_textures_gray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EtyriteSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
