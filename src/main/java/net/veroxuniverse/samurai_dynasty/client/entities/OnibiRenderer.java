package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.OnibiEntity;

public class OnibiRenderer extends AzEntityRenderer<OnibiEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/spirit.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/spirit.png"
    );

    public OnibiRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<OnibiEntity>builder(GEO, TEX)
                        .setAnimatorProvider(OnibiAnimator::new)
                        .setShadowRadius(0.1f)
                        .build(),
                context
        );
    }
}