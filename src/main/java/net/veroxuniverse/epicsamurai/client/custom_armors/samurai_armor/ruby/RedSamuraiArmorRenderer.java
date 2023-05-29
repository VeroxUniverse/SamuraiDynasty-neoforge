package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.ruby;

import net.veroxuniverse.epicsamurai.item.armor.RedSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class RedSamuraiArmorRenderer extends GeoArmorRenderer<RedSamuraiArmorItem> {
    public RedSamuraiArmorRenderer() {
        super(new RedSamuraiArmorModel());

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
