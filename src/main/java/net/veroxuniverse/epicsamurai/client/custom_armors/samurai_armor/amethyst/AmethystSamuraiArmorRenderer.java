package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import net.veroxuniverse.epicsamurai.item.armor.AmethystSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AmethystSamuraiArmorRenderer extends GeoArmorRenderer<AmethystSamuraiArmorItem> {
    public AmethystSamuraiArmorRenderer() {
        super(new AmethystSamuraiArmorModel());
    }
}
