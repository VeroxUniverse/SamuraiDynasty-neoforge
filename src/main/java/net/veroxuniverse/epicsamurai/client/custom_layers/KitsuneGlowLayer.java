package net.veroxuniverse.epicsamurai.client.custom_layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneEntity;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class KitsuneGlowLayer<T extends KitsuneEntity> extends GeoLayerRenderer<T> {

    protected static final ResourceLocation KITSUNE_GLOW = new ResourceLocation(EpicSamuraiMod.MOD_ID,"textures/entity/kitsune_glow_layer.png");
    protected static final ResourceLocation KITSUNE_ENTITY = new ResourceLocation(EpicSamuraiMod.MOD_ID,"geo/kitsune.geo.json");

    public KitsuneGlowLayer(IGeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn,
                       int packedLightIn, T entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch){
        RenderType glow = RenderType.entityTranslucentEmissive(KITSUNE_GLOW);
        this.getRenderer().render(this.getEntityModel().getModel(KITSUNE_ENTITY),entityLivingBaseIn,partialTicks,glow,
                matrixStackIn,bufferIn,bufferIn.getBuffer(glow),packedLightIn, OverlayTexture.NO_OVERLAY,1f,1f,1f,0.5f
        );
    }
}
