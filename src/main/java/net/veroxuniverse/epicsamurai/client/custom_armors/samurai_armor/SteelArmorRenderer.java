package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.veroxuniverse.epicsamurai.item.SteelArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SteelArmorRenderer extends GeoArmorRenderer<SteelArmorItem> {
    public SteelArmorRenderer() {
        super(new SteelArmorModel());

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
