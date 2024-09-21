package net.veroxuniverse.samurai_dynasty.client.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.ThrownShurikenEntity;

public class ThrownShurikenRenderer extends GeoEntityRenderer<ThrownShurikenEntity> {
    public ThrownShurikenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ThrownShurkienModel());
        this.shadowRadius = 0.25F;
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownShurikenEntity instance) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/item/shuriken.png");
    }

    @Override
    public void render(ThrownShurikenEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getXRot() + 90.0F));

        poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));

        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

}
