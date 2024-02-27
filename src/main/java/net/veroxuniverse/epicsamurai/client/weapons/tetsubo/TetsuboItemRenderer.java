package net.veroxuniverse.epicsamurai.client.weapons.tetsubo;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.veroxuniverse.epicsamurai.item.TetsuboItem;

public class TetsuboItemRenderer extends GeoItemRenderer<TetsuboItem> {
    public TetsuboItemRenderer() {
        super(new TetsuboItemModel());

    }
}