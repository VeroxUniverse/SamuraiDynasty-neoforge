package net.veroxuniverse.samurai_dynasty.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.JorogumoEntity;
import mod.azure.azurelib.renderer.GeoEntityRenderer;

public class JorogumoRenderer extends GeoEntityRenderer<JorogumoEntity> {
    public JorogumoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JorogumoModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public ResourceLocation getTextureLocation(JorogumoEntity instance) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/jorogumo.png");
    }

    @Override
    public void render(JorogumoEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}