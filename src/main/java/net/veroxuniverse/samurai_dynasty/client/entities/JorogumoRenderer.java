package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.JorogumoEntity;

public class JorogumoRenderer extends AzEntityRenderer<JorogumoEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/jorogumo.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/jorogumo.png"
    );

    public JorogumoRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<JorogumoEntity>builder(GEO, TEX)
                        .setAnimatorProvider(JorogumoAnimator::new)
                        .setShadowRadius(0.8f)
                        .build(),
                context
        );
    }
}