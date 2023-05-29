package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.deeperdarker;

import net.veroxuniverse.epicsamurai.item.armor.SculkSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SculkSamuraiArmorRenderer extends GeoArmorRenderer<SculkSamuraiArmorItem> {
    public SculkSamuraiArmorRenderer() {
        super(new SculkSamuraiArmorModel());

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
