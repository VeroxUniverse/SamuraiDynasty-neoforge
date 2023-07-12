package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.FujinEntity;
import net.veroxuniverse.epicsamurai.entity.custom.RaijinEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RaijinRenderer extends GeoEntityRenderer<RaijinEntity> {
    public RaijinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaijinModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public ResourceLocation getTextureLocation(RaijinEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/raijin.png");
    }

    @Override
    public void render(RaijinEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}