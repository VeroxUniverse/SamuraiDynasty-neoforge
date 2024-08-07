package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.quartz;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.QuartzSamuraiArmorItem;

public class QuartzSamuraiArmorModel extends GeoModel<QuartzSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(QuartzSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(QuartzSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/quartz_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(QuartzSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
