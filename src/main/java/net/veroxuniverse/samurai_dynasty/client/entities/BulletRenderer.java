package net.veroxuniverse.samurai_dynasty.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.azure.azurelib.util.RenderUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.veroxuniverse.samurai_dynasty.entity.custom.BulletEntity;
import org.jetbrains.annotations.NotNull;

public class BulletRenderer extends GeoEntityRenderer<BulletEntity> {

    public BulletRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new BulletModel());
    }

    @Override
    protected int getBlockLightLevel(@NotNull BulletEntity entityIn, @NotNull BlockPos partialTicks) {
        return 2;
    }

    @Override
    public void preRender(PoseStack poseStack, BulletEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        RenderUtils.faceRotation(poseStack, animatable, partialTick);
        poseStack.scale(animatable.tickCount > 2 ? 0.5F : 0.0F, animatable.tickCount > 2 ? 0.5F : 0.0F,
                animatable.tickCount > 2 ? 0.5F : 0.0F);
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight,
                packedOverlay, red, green, blue, alpha);
    }
}