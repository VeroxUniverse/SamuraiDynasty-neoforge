package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.TanukiEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TanukiRenderer extends GeoEntityRenderer<TanukiEntity> {
    public TanukiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TanukiModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TanukiEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/tanuki.png");
    }

    @Override
    public void render(TanukiEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}