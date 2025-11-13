package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KawausoEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.KitsuneEntity;
import org.jetbrains.annotations.NotNull;

public class KitsuneAnimator extends AzEntityAnimator<KitsuneEntity> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/kitsune.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<KitsuneEntity> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
        animationControllerContainer.add(
                AzAnimationController.builder(this, "attack_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(KitsuneEntity animatable) {
        return ANIMATIONS;
    }
}
