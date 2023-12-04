package net.veroxuniverse.epicsamurai.item.armor;

import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst.MaskAmethystSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.bloodmagic.LivingSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import net.veroxuniverse.epicsamurai.utils.HelperMethods;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MaskAmethystSamuraiArmorItem extends SamuraiArmorItem {

    public MaskAmethystSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }



    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if(Screen.hasShiftDown() && stack.getItem() == ItemsRegistry.MASK_AMETHYST_SAMURAI_HELMET.get()) {
            HelperMethods.appendMaskHoverText(components);
        } else if (stack.getItem() == ItemsRegistry.MASK_AMETHYST_SAMURAI_HELMET.get()) {
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".summary.text"));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    // Creates the render
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private MaskAmethystSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new MaskAmethystSamuraiArmorRenderer();

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
        return this.material == ArmorMaterialsRegistry.SAMURAI_AMETHYST;
    }
}