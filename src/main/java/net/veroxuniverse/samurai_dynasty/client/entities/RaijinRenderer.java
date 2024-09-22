package net.veroxuniverse.samurai_dynasty.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.RaijinEntity;
import org.jetbrains.annotations.NotNull;

public class RaijinRenderer extends GeoEntityRenderer<RaijinEntity> {
    public RaijinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaijinModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull RaijinEntity instance) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/entity/raijin.png");
    }

    @Override
    public void render(@NotNull RaijinEntity entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}