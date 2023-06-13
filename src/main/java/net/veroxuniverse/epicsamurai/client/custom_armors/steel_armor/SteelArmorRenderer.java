package net.veroxuniverse.epicsamurai.client.custom_armors.steel_armor;

import net.veroxuniverse.epicsamurai.item.armor.SteelArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SteelArmorRenderer extends GeoArmorRenderer<SteelArmorItem> {
    public SteelArmorRenderer() {
        super(new SteelArmorModel());

    }
}
