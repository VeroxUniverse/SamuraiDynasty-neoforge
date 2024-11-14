package net.veroxuniverse.samurai_dynasty.item.armor;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ronin.RoninSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class LightSamuraiArmorItem extends SamuraiArmorItem {

    public ItemStack itemStack;

    public LightSamuraiArmorItem(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private RoninSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    return new RoninSamuraiArmorRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }


    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_STEEL;
    }

}