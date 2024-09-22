package net.veroxuniverse.samurai_dynasty.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.FujinEntity;
import org.jetbrains.annotations.NotNull;

public class FujinRenderer extends GeoEntityRenderer<FujinEntity> {
    public FujinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FujinModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FujinEntity instance) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/entity/fujin.png");
    }

    @Override
    public void render(@NotNull FujinEntity entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}