package net.veroxuniverse.samurai_dynasty.client.weapons.kamayari;

import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;

public class KamayariItemRenderer extends GeoItemRenderer<KamayariItem> {
    public KamayariItemRenderer() {
        super(new KamayariItemModel());

    }
}