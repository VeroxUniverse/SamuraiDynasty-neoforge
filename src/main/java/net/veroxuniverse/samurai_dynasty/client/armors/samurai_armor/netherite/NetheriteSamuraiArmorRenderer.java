package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.NetheriteSamuraiArmorItem;

public class NetheriteSamuraiArmorRenderer extends GeoArmorRenderer<NetheriteSamuraiArmorItem> {
    public NetheriteSamuraiArmorRenderer() {
        super(new NetheriteSamuraiArmorModel());
    }

    public String getColorNameFromRGB(int rgbValue) {
        for (DyeColor color : DyeColor.values()) {
            if (color.getTextureDiffuseColor() == rgbValue) {
                return color.getName().toLowerCase();
            }
        }
        return DyeColor.WHITE.getName().toLowerCase();
    }

    @Override
    public ResourceLocation getTextureLocation(NetheriteSamuraiArmorItem instance) {
        String colorName = getColorNameFromRGB(instance.getColor(getCurrentStack()));
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/netherite_samurai/" + colorName + "_netherite_samurai_armor.png");
    }
}

