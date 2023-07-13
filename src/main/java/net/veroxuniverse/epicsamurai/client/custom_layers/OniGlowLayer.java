package net.veroxuniverse.epicsamurai.client.custom_layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OniEntity;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class OniGlowLayer<T extends OniEntity> extends GeoLayerRenderer<T> {

    protected static final ResourceLocation ONI_GLOW = new ResourceLocation(EpicSamuraiMod.MOD_ID,"textures/entity/oni_glow_layer.png");
    protected static final ResourceLocation ONI_ENTITY = new ResourceLocation(EpicSamuraiMod.MOD_ID,"geo/oni.geo.json");

    public OniGlowLayer(IGeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn,
                       int packedLightIn, T entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch){
        RenderType glow = RenderType.entityTranslucentCull(ONI_GLOW);
        this.getRenderer().render(this.getEntityModel().getModel(ONI_ENTITY),entityLivingBaseIn,partialTicks,glow,
                matrixStackIn,bufferIn,bufferIn.getBuffer(glow),packedLightIn, OverlayTexture.NO_OVERLAY,1f,1f,1f,5.0f
        );
    }
}
