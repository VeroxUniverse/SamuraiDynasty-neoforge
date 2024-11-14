package net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.WakizashiItem;

public class WakizashiItemRenderer extends GeoItemRenderer<WakizashiItem> {
    public WakizashiItemRenderer() {
        super(new WakizashiItemModel());

    }
}