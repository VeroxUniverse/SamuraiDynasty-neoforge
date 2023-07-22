package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.ars_nouveau.geckolib3.renderers.geo.GeoArmorRenderer;

public class MageSamuraiArmorRenderer extends GeoArmorRenderer<MageSamuraiArmorItem> {
    public MageSamuraiArmorRenderer() {
        super(new MageSamuraiArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";

    }

    @Override
    public ResourceLocation getTextureLocation(MageSamuraiArmorItem instance) {
            return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + instance.getColor(itemStack) + ".png");
    }
}
