package net.veroxuniverse.samurai_dynasty.curios;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class OniMaskCurios extends Item implements ICurioItem {
    public OniMaskCurios(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (!(slotContext.entity() instanceof Player player)){
            return;
        }

        if(player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        if(player.hasEffect(MobEffects.WITHER)) player.removeEffect(MobEffects.WITHER);
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 240, 0, false, false, false));

    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown() && stack.getItem() == ItemsRegistry.ONI_MASK.get()) {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
            components.add(Component.literal(""));
            components.add(Component.literal("§7Applies §bNight Vision§7.").withStyle(ChatFormatting.GRAY));
            components.add(Component.literal("§7Immune to §bBlindness§7.").withStyle(ChatFormatting.GRAY));
            components.add(Component.literal("§7Immune to §bWither§7.").withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem() == ItemsRegistry.ONI_MASK.get()) {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
        }

        super.appendHoverText(stack, context, components, flag);
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }


}
