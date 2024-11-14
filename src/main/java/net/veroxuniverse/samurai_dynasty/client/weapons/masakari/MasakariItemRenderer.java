package net.veroxuniverse.samurai_dynasty.client.weapons.masakari;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.MasakariItem;
import net.veroxuniverse.samurai_dynasty.item.MasakariNetheriteItem;

public class MasakariItemRenderer extends GeoItemRenderer<MasakariItem> {
    public MasakariItemRenderer() {
        super(new MasakariItemModel());

    }
}