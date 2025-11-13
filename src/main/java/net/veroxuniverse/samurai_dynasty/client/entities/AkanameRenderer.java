package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.AkanameEntity;

public class AkanameRenderer extends AzEntityRenderer<AkanameEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/akaname.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/akaname.png"
    );

    public AkanameRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<AkanameEntity>builder(GEO, TEX)
                        .setAnimatorProvider(AkanameAnimator::new)
                        .setShadowRadius(0.3f)
                        .build(),
                context
        );
    }
}