package net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemNetheriteModel;
import net.veroxuniverse.samurai_dynasty.item.KatanaNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.WakizashiNetheriteItem;

public class WakizashiItemNetheriteRenderer extends GeoItemRenderer<WakizashiNetheriteItem> {
    public WakizashiItemNetheriteRenderer() {
        super(new WakizashiItemNetheriteModel());

    }
}