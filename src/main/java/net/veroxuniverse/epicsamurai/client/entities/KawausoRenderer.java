package net.veroxuniverse.epicsamurai.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.KawausoEntity;
import mod.azure.azurelib.renderer.GeoEntityRenderer;

public class KawausoRenderer extends GeoEntityRenderer<KawausoEntity> {
    public KawausoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KawausoModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(KawausoEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kawauso.png");
    }

    @Override
    public void render(KawausoEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}