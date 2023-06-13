package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.iron;

import net.veroxuniverse.epicsamurai.item.armor.IronSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IronSamuraiArmorRenderer extends GeoArmorRenderer<IronSamuraiArmorItem> {
    public IronSamuraiArmorRenderer() {
        super(new IronSamuraiArmorModel());

    }
}
