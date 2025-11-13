package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.AkanameEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;
import org.jetbrains.annotations.NotNull;

public class EnentraAnimator extends AzEntityAnimator<EnenraEntity> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/enenra.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<EnenraEntity> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(EnenraEntity animatable) {
        return ANIMATIONS;
    }
}
