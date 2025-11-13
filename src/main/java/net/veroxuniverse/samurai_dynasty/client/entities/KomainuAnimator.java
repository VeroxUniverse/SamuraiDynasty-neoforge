package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.animation.controller.AzAnimationController;
import mod.azure.azurelib.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KitsuneEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.KomainuEntity;
import org.jetbrains.annotations.NotNull;

public class KomainuAnimator extends AzEntityAnimator<KomainuEntity> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/komainu.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<KomainuEntity> animationControllerContainer) {
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
    public @NotNull ResourceLocation getAnimationLocation(KomainuEntity animatable) {
        return ANIMATIONS;
    }
}
