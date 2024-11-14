package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.master;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.MasterSamuraiArmorItem;

public class MasterSamuraiArmorModel extends GeoModel<MasterSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MasterSamuraiArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/master_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MasterSamuraiArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/master_samurai.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MasterSamuraiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
