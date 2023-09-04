package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.steel;

import net.veroxuniverse.epicsamurai.item.armor.SteelNinjaArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SteelNinjaArmorRenderer extends GeoArmorRenderer<SteelNinjaArmorItem> {
    public SteelNinjaArmorRenderer() {
        super(new SteelNinjaArmorModel());

    }
}