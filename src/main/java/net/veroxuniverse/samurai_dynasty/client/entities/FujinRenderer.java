package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.FujinEntity;

public class FujinRenderer extends AzEntityRenderer<FujinEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/fujin.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/fujin.png"
    );

    public FujinRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<FujinEntity>builder(GEO, TEX)
                        .setAnimatorProvider(FujinAnimator::new)
                        .setShadowRadius(0.8f)
                        .build(),
                context
        );
    }
}