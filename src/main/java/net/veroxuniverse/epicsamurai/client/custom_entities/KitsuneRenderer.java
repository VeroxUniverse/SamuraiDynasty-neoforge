package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KitsuneRenderer extends GeoEntityRenderer<KitsuneEntity> {
    public KitsuneRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KitsuneModel());
        this.shadowRadius = 0.3f;
        //this.addLayer(new KitsuneGlowLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(KitsuneEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune.png");
    }

    @Override
    public void render(KitsuneEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}