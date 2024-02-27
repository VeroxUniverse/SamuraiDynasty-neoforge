package net.veroxuniverse.epicsamurai.client.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.veroxuniverse.epicsamurai.curios.model.OniMaskModel;
import net.veroxuniverse.epicsamurai.entity.custom.ThrownShurikenEntity;

@OnlyIn(Dist.CLIENT)
public class ThrownShurikenRenderer extends EntityRenderer<ThrownShurikenEntity> {
    public static final ResourceLocation SHURIKEN_LOCATION = new ResourceLocation("textures/entity/shuriken.png");
    private final ShurikenModel model;


    public ThrownShurikenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ShurikenModel(pContext.bakeLayer(OniMaskModel.LAYER_LOCATION));
    }

    public void render(ThrownShurikenEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        pPoseStack.scale(0.6f, 0.6f, 0.6f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    public ResourceLocation getTextureLocation(ThrownShurikenEntity pEntity) {
        return SHURIKEN_LOCATION;
    }
}