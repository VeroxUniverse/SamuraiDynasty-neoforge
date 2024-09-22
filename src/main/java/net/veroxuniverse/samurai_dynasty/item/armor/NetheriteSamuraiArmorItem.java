package net.veroxuniverse.samurai_dynasty.item.armor;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite.NetheriteSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NetheriteSamuraiArmorItem extends SamuraiArmorItem {

    public NetheriteSamuraiArmorItem(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<mod.azure.azurelib.common.internal.client.RenderProvider> consumer) {
        consumer.accept(new mod.azure.azurelib.common.internal.client.RenderProvider() {
            private NetheriteSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    return new NetheriteSamuraiArmorRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_NETHERITE;
    }

}