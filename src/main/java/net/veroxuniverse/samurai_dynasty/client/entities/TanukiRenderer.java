package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.TanukiEntity;

public class TanukiRenderer extends AzEntityRenderer<TanukiEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/tanuki.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/tanuki.png"
    );

    public TanukiRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<TanukiEntity>builder(GEO, TEX)
                        .setAnimatorProvider(TanukiAnimator::new)
                        .setShadowRadius(0.3f)
                        .build(),
                context
        );
    }
}