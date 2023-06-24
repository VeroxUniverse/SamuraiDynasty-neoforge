package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.oni_mask;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.epicsamurai.item.armor.OniMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import top.theillusivec4.curios.api.type.ISlotType;

import java.util.Optional;

public class OniMaskArmorRenderer extends GeoArmorRenderer<OniMaskArmorItem> {
    public OniMaskArmorRenderer() {
        super(new OniMaskArmorModel());

    }

    public void prepForRender(LivingEntity livingEntity, ItemStack itemStack, Optional<ISlotType> head, HumanoidModel<?> original) {
    }
}
