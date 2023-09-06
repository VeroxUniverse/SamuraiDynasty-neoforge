package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.diamond;

import net.veroxuniverse.epicsamurai.item.armor.DiamondNinjaArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DiamondNinjaArmorRenderer extends GeoArmorRenderer<DiamondNinjaArmorItem> {
    public DiamondNinjaArmorRenderer() {
        super(new DiamondNinjaArmorModel());

    }
}