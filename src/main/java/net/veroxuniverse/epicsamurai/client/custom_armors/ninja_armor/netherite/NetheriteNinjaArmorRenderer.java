package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.netherite;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.NetheriteNinjaArmorItem;

public class NetheriteNinjaArmorRenderer extends GeoArmorRenderer<NetheriteNinjaArmorItem> {
    public NetheriteNinjaArmorRenderer() {
        super(new NetheriteNinjaArmorModel());

    }
}