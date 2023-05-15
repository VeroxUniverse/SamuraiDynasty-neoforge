package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneProjectileEntity;

@OnlyIn(Dist.CLIENT)
public class KitsuneProjectileRenderer extends EntityRenderer<KitsuneProjectileEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("textures/entity/kitsune_projectile.png");
    private static final RenderType RENDER_TYPE = RenderType.entityTranslucent(TEXTURE_LOCATION);
    private final KitsuneProjectileModel<KitsuneProjectileEntity> model;

    public KitsuneProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new KitsuneProjectileModel<>(pContext.bakeLayer(ModelLayers.SHULKER_BULLET));
    }

    protected int getBlockLightLevel(KitsuneProjectileEntity pEntity, BlockPos pPos) {
        return 15;
    }

    public void render(KitsuneProjectileEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        float f = Mth.rotlerp(pEntity.yRotO, pEntity.getYRot(), pPartialTicks);
        float f1 = Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot());
        float f2 = (float)pEntity.tickCount + pPartialTicks;
        pMatrixStack.translate(0.0D, (double)0.15F, 0.0D);
        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.sin(f2 * 0.1F) * 180.0F));
        pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(Mth.cos(f2 * 0.1F) * 180.0F));
        pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.sin(f2 * 0.15F) * 360.0F));
        pMatrixStack.scale(-0.5F, -0.5F, 0.5F);
        this.model.setupAnim(pEntity, 0.0F, 0.0F, 0.0F, f, f1);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(TEXTURE_LOCATION));
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.scale(1.5F, 1.5F, 1.5F);
        VertexConsumer vertexconsumer1 = pBuffer.getBuffer(RENDER_TYPE);
        this.model.renderToBuffer(pMatrixStack, vertexconsumer1, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    public ResourceLocation getTextureLocation(KitsuneProjectileEntity pEntity) {
        return TEXTURE_LOCATION;
    }
}