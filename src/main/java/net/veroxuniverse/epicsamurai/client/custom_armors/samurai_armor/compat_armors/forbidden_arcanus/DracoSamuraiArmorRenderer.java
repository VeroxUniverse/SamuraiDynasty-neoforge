package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.forbidden_arcanus;

import net.veroxuniverse.epicsamurai.item.armor.DracoSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.TyrSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class DracoSamuraiArmorRenderer extends GeoArmorRenderer<DracoSamuraiArmorItem> {
    public DracoSamuraiArmorRenderer() {
        super(new DracoSamuraiArmorModel());

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
