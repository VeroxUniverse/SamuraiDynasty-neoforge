package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.silver;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.WhiteSamuraiArmorItem;

public class WhiteSamuraiArmorModel extends GeoModel<WhiteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(WhiteSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/white_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
