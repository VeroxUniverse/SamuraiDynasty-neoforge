package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.FujinEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.RaijinEntity;

public class RaijinRenderer extends AzEntityRenderer<RaijinEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/raijin.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/raijin.png"
    );

    public RaijinRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<RaijinEntity>builder(GEO, TEX)
                        .setAnimatorProvider(RaijinAnimator::new)
                        .setShadowRadius(0.8f)
                        .build(),
                context
        );
    }
}