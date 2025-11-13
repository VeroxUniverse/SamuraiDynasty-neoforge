package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.OniEntity;

public class OniRenderer extends AzEntityRenderer<OniEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/oni.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/oni.png"
    );

    public OniRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<OniEntity>builder(GEO, TEX)
                        .setAnimatorProvider(OniAnimator::new)
                        .setShadowRadius(0.8f)
                        .build(),
                context
        );
    }
}