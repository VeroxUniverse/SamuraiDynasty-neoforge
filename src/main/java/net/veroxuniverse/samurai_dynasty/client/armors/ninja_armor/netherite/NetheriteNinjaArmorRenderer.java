package net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.netherite;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.NetheriteNinjaArmorItem;

public class NetheriteNinjaArmorRenderer extends GeoArmorRenderer<NetheriteNinjaArmorItem> {
    public NetheriteNinjaArmorRenderer() {
        super(new NetheriteNinjaArmorModel());

    }
}