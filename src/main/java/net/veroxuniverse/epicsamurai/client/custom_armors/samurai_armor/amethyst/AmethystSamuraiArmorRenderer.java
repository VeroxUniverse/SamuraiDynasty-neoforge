package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.AmethystSamuraiArmorItem;

public class AmethystSamuraiArmorRenderer extends GeoArmorRenderer<AmethystSamuraiArmorItem> {
    public AmethystSamuraiArmorRenderer() {
        super(new AmethystSamuraiArmorModel());
    }
}
