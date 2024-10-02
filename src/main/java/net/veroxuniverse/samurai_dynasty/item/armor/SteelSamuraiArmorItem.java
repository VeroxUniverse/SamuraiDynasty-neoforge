package net.veroxuniverse.samurai_dynasty.item.armor;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel.SteelSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class SteelSamuraiArmorItem extends SamuraiArmorItem {

    private final DyeColor color;

    public SteelSamuraiArmorItem(DyeColor color,Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties);
        this.color = color;
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private SteelSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    return new SteelSamuraiArmorRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }


    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_STEEL;
    }

    //DyedItemColor.getOrDefault(itemstack)

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

}