package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.quartz;

import net.veroxuniverse.epicsamurai.item.armor.QuartzSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class QuartzSamuraiArmorRenderer extends GeoArmorRenderer<QuartzSamuraiArmorItem> {
    public QuartzSamuraiArmorRenderer() {
        super(new QuartzSamuraiArmorModel());

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
