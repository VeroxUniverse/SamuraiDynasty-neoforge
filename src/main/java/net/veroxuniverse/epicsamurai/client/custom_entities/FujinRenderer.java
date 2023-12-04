package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.FujinEntity;
import org.jetbrains.annotations.NotNull;
import mod.azure.azurelib.renderer.GeoEntityRenderer;

public class FujinRenderer extends GeoEntityRenderer<FujinEntity> {
    public FujinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FujinModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FujinEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/fujin.png");
    }

    @Override
    public void render(@NotNull FujinEntity entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}