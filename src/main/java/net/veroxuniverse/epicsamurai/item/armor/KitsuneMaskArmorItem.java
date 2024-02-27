package net.veroxuniverse.epicsamurai.item.armor;

import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.veroxuniverse.epicsamurai.client.armors.samurai_armor.kitsune_mask.KitsuneMaskArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class KitsuneMaskArmorItem extends SamuraiArmorItem{

    public KitsuneMaskArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown() && stack.getItem() == ItemsRegistry.KITSUNE_MASK.get()) {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
            components.add(Component.literal(""));
            components.add(Component.literal("§7Applies §bFire Resistance§7.").withStyle(ChatFormatting.GRAY));
            components.add(Component.literal("§7Immune to §bBlindness§7.").withStyle(ChatFormatting.GRAY));
            components.add(Component.literal("§7Immune to §bSlowness§7.").withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem() == ItemsRegistry.KITSUNE_MASK.get()) {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    // Creates the render
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private KitsuneMaskArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new KitsuneMaskArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_STEEL;
    }

}