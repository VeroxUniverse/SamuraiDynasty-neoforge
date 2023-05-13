package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_layers.OniGlowLayer;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import net.veroxuniverse.epicsamurai.entity.custom.OniEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OniRenderer extends GeoEntityRenderer<OniEntity> {
    public OniRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OniModel());
        this.shadowRadius = 0.8f;
        this.addLayer(new OniGlowLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(OniEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/oni.png");
    }

    @Override
    public RenderType getRenderType(OniEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}