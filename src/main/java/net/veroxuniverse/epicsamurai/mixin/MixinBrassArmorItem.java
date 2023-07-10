package net.veroxuniverse.epicsamurai.mixin;

import com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import net.minecraft.world.entity.player.Player;
import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(GoggleOverlayRenderer.class)
public class MixinBrassArmorItem {
    @Redirect(
            method = "Lcom/simibubi/create/content/equipment/goggles/GoggleOverlayRenderer;renderOverlay(Lnet/minecraftforge/client/gui/overlay/ForgeGui;Lnet/minecraft/client/gui/GuiGraphics;FII)V",
            at = @At(value = "INVOKE",
            target = "Lnet/veroxuniverse/epicsamurai/item/armor/BrassSamuraiArmorItem;isWearingGoggles(Lnet/minecraft/world/entity/player/Player;)Z"))
    private static <GooglesItem> boolean injected(GooglesItem googlesItem, Player player){
        return BrassSamuraiArmorItem.isWearingGoggles(mc.player) && GogglesItem.isWearingGoggles(mc.player);
    }

}
