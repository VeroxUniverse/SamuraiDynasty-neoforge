package net.veroxuniverse.samurai_dynasty.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;
import mod.azure.azurelib.renderer.GeoEntityRenderer;

public class EnenraRenderer extends GeoEntityRenderer<EnenraEntity> {
    public EnenraRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EnenraModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(EnenraEntity instance) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/enenra.png");
    }

    @Override
    public void render(EnenraEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}