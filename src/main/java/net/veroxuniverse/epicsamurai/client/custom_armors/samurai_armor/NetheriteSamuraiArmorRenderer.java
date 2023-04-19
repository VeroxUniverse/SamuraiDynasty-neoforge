package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.veroxuniverse.epicsamurai.item.NetheriteSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class NetheriteSamuraiArmorRenderer extends GeoArmorRenderer<NetheriteSamuraiArmorItem> {
    public NetheriteSamuraiArmorRenderer() {
        super(new NetheriteSamuraiArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";

    }
}
