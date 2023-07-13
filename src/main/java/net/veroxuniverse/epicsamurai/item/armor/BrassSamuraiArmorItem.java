package net.veroxuniverse.epicsamurai.item.armor;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.compat.CreateCompat;
import net.veroxuniverse.epicsamurai.item.armor.armoritem.SamuraiArmorItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BrassSamuraiArmorItem extends SamuraiArmorItem {

    public BrassSamuraiArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {

        if(Screen.hasShiftDown() && stack.getItem() == CreateCompat.BRASS_SAMURAI_HELMET.get()) {
            components.add(new TranslatableComponent("tooltip." + EpicSamuraiMod.MOD_ID + ".brass_helmet.summary").withStyle(ChatFormatting.GRAY));
            components.add(new TranslatableComponent("tooltip." + EpicSamuraiMod.MOD_ID + ".brass_helmet.empty").withStyle(ChatFormatting.DARK_GREEN));
            components.add(new TranslatableComponent("tooltip." + EpicSamuraiMod.MOD_ID + ".brass_helmet.goggles").withStyle(ChatFormatting.DARK_GREEN));
        } else if (stack.getItem() == CreateCompat.BRASS_SAMURAI_HELMET.get()) {
            components.add(new TranslatableComponent("tooltip." + EpicSamuraiMod.MOD_ID + ".brass_helmet.summary").withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(stack, level, components, flag);
    }

}