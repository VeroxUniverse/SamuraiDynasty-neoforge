package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.NetheriteSamuraiArmorItem;

public class NetheriteSamuraiArmorModel extends GeoModel<NetheriteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(NetheriteSamuraiArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteSamuraiArmorItem object) {
        //return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/netherite_samurai.png");
        return null;
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteSamuraiArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
