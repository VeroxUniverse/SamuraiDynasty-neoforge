package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EnenraRenderer extends GeoEntityRenderer<EnenraEntity> {
    public EnenraRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EnenraModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(EnenraEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/enenra.png");
    }

    @Override
    public void render(EnenraEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}