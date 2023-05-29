package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.straw_hat;

import net.veroxuniverse.epicsamurai.item.armor.StrawHatArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class StrawHatArmorRenderer extends GeoArmorRenderer<StrawHatArmorItem> {
    public StrawHatArmorRenderer() {
        super(new StrawHatArmorModel());

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
