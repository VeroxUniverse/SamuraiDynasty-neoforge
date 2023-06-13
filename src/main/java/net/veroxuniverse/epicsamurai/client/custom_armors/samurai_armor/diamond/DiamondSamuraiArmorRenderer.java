package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.diamond;

import net.veroxuniverse.epicsamurai.item.armor.DiamondSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DiamondSamuraiArmorRenderer extends GeoArmorRenderer<DiamondSamuraiArmorItem> {
    public DiamondSamuraiArmorRenderer() {
        super(new DiamondSamuraiArmorModel());

    }
}
