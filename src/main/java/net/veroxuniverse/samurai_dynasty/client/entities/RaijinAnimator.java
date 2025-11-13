package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzEntityAnimator;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.FujinEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.RaijinEntity;
import org.jetbrains.annotations.NotNull;

public class RaijinAnimator extends AzEntityAnimator<RaijinEntity> {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "animations/raijin.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<RaijinEntity> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(RaijinEntity animatable) {
        return ANIMATIONS;
    }
}
