package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;

public class SteelSamuraiArmorRenderer extends GeoArmorRenderer<SteelSamuraiArmorItem> {

    public SteelSamuraiArmorRenderer() {
        super(new SteelSamuraiArmorModel());
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
    public ResourceLocation getTextureLocation(SteelSamuraiArmorItem instance) {
        String colorName = getColorNameFromRGB(instance.getColor(getCurrentStack()));
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/steel_samurai/" + colorName + "_samurai_armor.png");
    }
}
