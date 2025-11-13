package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.TanukiEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.TwoTailedFox;
import org.jetbrains.annotations.NotNull;

public class TwoTailedAnimator extends AzEntityAnimator<TwoTailedFox> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/kitsune_small.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<TwoTailedFox> animationControllerContainer) {
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
    public @NotNull ResourceLocation getAnimationLocation(TwoTailedFox animatable) {
        return ANIMATIONS;
    }
}
