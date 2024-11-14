package net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.NagamakiItem;

public class NagamakiItemRenderer extends GeoItemRenderer<NagamakiItem> {
    public NagamakiItemRenderer() {
        super(new NagamakiItemModel());

    }
}