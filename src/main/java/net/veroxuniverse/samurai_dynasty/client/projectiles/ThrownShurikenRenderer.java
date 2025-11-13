package net.veroxuniverse.samurai_dynasty.client.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.ThrownShurikenEntity;

public class ThrownShurikenRenderer extends AzEntityRenderer<ThrownShurikenEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/shuriken.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/entity/shuriken.png"
    );

    @Override
    public void render(ThrownShurikenEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getXRot() + 90.0F));

        poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));

        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    public ThrownShurikenRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<ThrownShurikenEntity>builder(GEO, TEX)
                        .setAnimatorProvider(ThrownShurikenAnimator::new)
                        .setShadowRadius(0.25f)
                        .build(),
                context
        );
    }
}
