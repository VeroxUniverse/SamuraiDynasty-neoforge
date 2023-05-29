package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.oni_mask;

import net.veroxuniverse.epicsamurai.item.armor.OniMaskArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class OniMaskArmorRenderer extends GeoArmorRenderer<OniMaskArmorItem> {
    public OniMaskArmorRenderer() {
        super(new OniMaskArmorModel());

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
