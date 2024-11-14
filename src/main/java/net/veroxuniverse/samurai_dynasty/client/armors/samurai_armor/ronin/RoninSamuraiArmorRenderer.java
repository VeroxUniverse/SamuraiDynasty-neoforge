package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ronin;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.LightSamuraiArmorItem;

public class RoninSamuraiArmorRenderer extends GeoArmorRenderer<LightSamuraiArmorItem> {

    public RoninSamuraiArmorRenderer() {
        super(new RoninSamuraiArmorModel());
    }

}
