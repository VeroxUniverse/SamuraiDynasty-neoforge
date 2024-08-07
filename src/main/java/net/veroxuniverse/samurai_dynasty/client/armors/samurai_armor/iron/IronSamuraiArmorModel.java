package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.iron;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.IronSamuraiArmorItem;

public class IronSamuraiArmorModel extends GeoModel<IronSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(IronSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/iron_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
