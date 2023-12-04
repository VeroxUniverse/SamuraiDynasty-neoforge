package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OnibiEntity;

public class OnibiRenderer extends GeoEntityRenderer<OnibiEntity> {

    public OnibiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OnibiModel());
        this.shadowRadius = 0.1f;
    }

    @Override
    public ResourceLocation getTextureLocation(OnibiEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/spirit.png");
    }

    @Override
    public void render(OnibiEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}