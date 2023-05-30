package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.create;

import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BrassSamuraiArmorRenderer extends GeoArmorRenderer<BrassSamuraiArmorItem> {
    public BrassSamuraiArmorRenderer() {
        super(new BrassSamuraiArmorModel());

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
