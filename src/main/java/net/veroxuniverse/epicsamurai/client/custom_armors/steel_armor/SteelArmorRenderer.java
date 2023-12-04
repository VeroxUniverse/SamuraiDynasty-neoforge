package net.veroxuniverse.epicsamurai.client.custom_armors.steel_armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.SteelArmorItem;

public class SteelArmorRenderer extends GeoArmorRenderer<SteelArmorItem> {
    public SteelArmorRenderer() {
        super(new SteelArmorModel());

    }
}
