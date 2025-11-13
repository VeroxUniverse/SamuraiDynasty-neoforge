package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.JorogumoEntity;
import org.jetbrains.annotations.NotNull;

public class JorogumoAnimator extends AzEntityAnimator<JorogumoEntity> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/jorogumo.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<JorogumoEntity> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(JorogumoEntity animatable) {
        return ANIMATIONS;
    }
}
