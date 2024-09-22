package net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.TonbukiriItem;

public class TonbukiriItemRenderer extends GeoItemRenderer<TonbukiriItem> {
    public TonbukiriItemRenderer() {
        super(new TonbukiriItemModel());

    }
}