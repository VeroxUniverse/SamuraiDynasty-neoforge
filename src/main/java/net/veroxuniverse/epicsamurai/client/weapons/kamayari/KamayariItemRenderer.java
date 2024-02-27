package net.veroxuniverse.epicsamurai.client.weapons.kamayari;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.veroxuniverse.epicsamurai.item.KamayariItem;

public class KamayariItemRenderer extends GeoItemRenderer<KamayariItem> {
    public KamayariItemRenderer() {
        super(new KamayariItemModel());

    }
}