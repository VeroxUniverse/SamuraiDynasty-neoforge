package net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.TetsuboItem;

public class TetsuboItemRenderer extends GeoItemRenderer<TetsuboItem> {
    public TetsuboItemRenderer() {
        super(new TetsuboItemModel());

    }
}