package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ruby;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.RedSamuraiArmorItem;

public class RedSamuraiArmorModel extends GeoModel<RedSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(RedSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/red_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
