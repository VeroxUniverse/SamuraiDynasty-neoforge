package net.veroxuniverse.samurai_dynasty.client.armors;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.layer.GeoRenderLayer;
import mod.azure.azurelib.common.internal.client.renderer.GeoRenderer;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.object.Color;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class ColorGeoLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {

    private final ResourceLocation textureLocation;

    public ColorGeoLayer(GeoRenderer<T> renderer, ResourceLocation textureLocation) {
        super(renderer);
        this.textureLocation = textureLocation;
    }


    protected RenderType getRenderType(T animatable) {
        RenderType renderType = RenderType.armorCutoutNoCull(textureLocation);
        return renderType;
    }

    @Override
    public void render(
            PoseStack poseStack,
            T animatable,
            BakedGeoModel bakedModel,
            RenderType renderType,
            MultiBufferSource bufferSource,
            VertexConsumer buffer,
            float partialTick,
            int packedLight,
            int packedOverlay
    ) {
        Color color = getRenderer().getRenderColor(animatable, partialTick, packedLight);

        System.out.println("Overlay Color: R:" + color.getRedFloat() + " G:" + color.getGreenFloat() + " B:" + color.getBlueFloat() + " A:" + color.getAlphaFloat());

        RenderType overlayRenderType = getRenderType(animatable);
        VertexConsumer overlayBuffer = bufferSource.getBuffer(overlayRenderType);

        getRenderer().reRender(
                bakedModel,
                poseStack,
                bufferSource,
                animatable,
                renderType,
                overlayBuffer,
                partialTick,
                packedLight,
                packedOverlay,
                color.getRedFloat(),
                color.getGreenFloat(),
                color.getBlueFloat(),
                color.getAlphaFloat()
        );
    }


}
