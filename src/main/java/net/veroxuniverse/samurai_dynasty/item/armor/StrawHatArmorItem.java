package net.veroxuniverse.samurai_dynasty.item.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.straw_hat.StrawHatArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class StrawHatArmorItem extends SamuraiArmorItem {

    public StrawHatArmorItem(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<mod.azure.azurelib.common.internal.client.RenderProvider> consumer) {
        consumer.accept(new mod.azure.azurelib.common.internal.client.RenderProvider() {
            private StrawHatArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    return new StrawHatArmorRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

}