package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.netherite;

import net.veroxuniverse.epicsamurai.item.armor.NetheriteNinjaArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteNinjaArmorRenderer extends GeoArmorRenderer<NetheriteNinjaArmorItem> {
    public NetheriteNinjaArmorRenderer() {
        super(new NetheriteNinjaArmorModel());

    }
}