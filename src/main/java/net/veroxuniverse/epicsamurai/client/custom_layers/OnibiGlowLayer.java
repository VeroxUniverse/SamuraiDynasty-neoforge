package net.veroxuniverse.epicsamurai.client.custom_layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OnibiEntity;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class OnibiGlowLayer<T extends OnibiEntity> extends GeoLayerRenderer<T> {

    protected static final ResourceLocation ONIBI_GLOW = new ResourceLocation(EpicSamuraiMod.MOD_ID,"textures/entity/spirit_glow_layer.png");
    protected static final ResourceLocation ONIBI_ENTITY = new ResourceLocation(EpicSamuraiMod.MOD_ID,"geo/spirit.geo.json");

    public OnibiGlowLayer(IGeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn,
                       int packedLightIn, T entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch){
        RenderType glow = RenderType.entityTranslucentCull(ONIBI_GLOW);
        this.getRenderer().render(this.getEntityModel().getModel(ONIBI_ENTITY),entityLivingBaseIn,partialTicks,glow,
                matrixStackIn,bufferIn,bufferIn.getBuffer(glow),packedLightIn, OverlayTexture.NO_OVERLAY,1f,1f,1f,5.0f
        );
    }
}
