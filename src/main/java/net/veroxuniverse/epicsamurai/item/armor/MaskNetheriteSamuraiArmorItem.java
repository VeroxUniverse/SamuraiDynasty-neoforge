package net.veroxuniverse.epicsamurai.item.armor;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.netherite.MaskNetheriteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class MaskNetheriteSamuraiArmorItem extends SamuraiArmorItem {

    public MaskNetheriteSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown() && stack.getItem() == ItemsRegistry.MASK_NETHERITE_SAMURAI_HELMET.get()) {
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".summary.text"));
            components.add(Component.literal(""));
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask_name.text"));
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask.ability_1"));
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask.ability_2"));
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask.ability_3"));
        } else if (stack.getItem() == ItemsRegistry.MASK_NETHERITE_SAMURAI_HELMET.get()) {
            components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".summary.text"));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private MaskNetheriteSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new MaskNetheriteSamuraiArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_NETHERITE;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide()) {
            if(player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(ItemsRegistry.MASK_AMETHYST_SAMURAI_HELMET.get())) {
                if(player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                if(player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
            }
        }
        if (this.type == Type.HELMET) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, false, false, false));
        }
    }

}