package net.veroxuniverse.samurai_dynasty.client.projectiles;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.ThrownShurikenEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.TwoTailedFox;
import org.jetbrains.annotations.NotNull;

public class ThrownShurikenAnimator extends AzEntityAnimator<ThrownShurikenEntity> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/empty.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<ThrownShurikenEntity> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ThrownShurikenEntity animatable) {
        return ANIMATIONS;
    }
}
