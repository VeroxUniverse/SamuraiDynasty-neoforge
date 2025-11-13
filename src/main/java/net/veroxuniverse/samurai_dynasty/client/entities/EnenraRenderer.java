package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;

public class EnenraRenderer extends AzEntityRenderer<EnenraEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/enenra.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/enenra.png"
    );

    public EnenraRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<EnenraEntity>builder(GEO, TEX)
                        .setAnimatorProvider(EnentraAnimator::new)
                        .setShadowRadius(0.3f)
                        .build(),
                context
        );
    }
}