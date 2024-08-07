package net.veroxuniverse.samurai_dynasty.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.samurai_dynasty.item.ranged.GunItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerRenderer.class)
public class WeaponRenderingMixin {
    protected WeaponRenderingMixin(){
    }
    @Inject(method = "getArmPose", at = @At(value = "TAIL"), cancellable = true)
    private static void tryItemPose(AbstractClientPlayer player, InteractionHand hand, CallbackInfoReturnable<HumanoidModel.ArmPose> returnable) {
        final ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.getItem() instanceof GunItem) {
            returnable.setReturnValue(HumanoidModel.ArmPose.CROSSBOW_HOLD);
        }
    }

}
