package net.veroxuniverse.epicsamurai.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HelperMethods {
    public static void appendMaskHoverText(@NotNull List<Component> components) {
        components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".summary.text"));
        components.add(Component.literal(""));
        components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask_name.text"));
        components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask.ability_1"));
        components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask.ability_2"));
        components.add(Component.translatable("info." + EpicSamuraiMod.MOD_ID + ".mask.ability_3"));
    }

    public static void onMaskArmorTick(Level level, Player player, boolean isHelmet) {
        if(!level.isClientSide()) {
            if(player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(ItemsRegistry.MASK_AMETHYST_SAMURAI_HELMET.get())
                    || player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(ItemsRegistry.MASK_QUARTZ_SAMURAI_HELMET.get())
                    || player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(ItemsRegistry.MASK_NETHERITE_SAMURAI_HELMET.get())
                    || player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(ItemsRegistry.ONI_MASK.get())
                    || player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(ItemsRegistry.MASK_STRAW_HAT.get())) {
                if(player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                if(player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
            }
        }
        if (isHelmet) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, false, false, false));
        }
    }
}
