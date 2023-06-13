package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.netherite;

import net.veroxuniverse.epicsamurai.item.armor.NetheriteSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NetheriteSamuraiArmorRenderer extends GeoArmorRenderer<NetheriteSamuraiArmorItem> {
    public NetheriteSamuraiArmorRenderer() {
        super(new NetheriteSamuraiArmorModel());

    }
}
