package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KawausoEntity;

public class KawausoRenderer extends AzEntityRenderer<KawausoEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/kawauso.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/kawauso.png"
    );

    public KawausoRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<KawausoEntity>builder(GEO, TEX)
                        .setAnimatorProvider(KawausoAnimator::new)
                        .setShadowRadius(0.3f)
                        .build(),
                context
        );
    }
}