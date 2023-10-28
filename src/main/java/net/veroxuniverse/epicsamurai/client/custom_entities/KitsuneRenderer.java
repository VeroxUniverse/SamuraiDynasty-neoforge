package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneEntity;
import net.veroxuniverse.epicsamurai.entity.custom.KomainuEntity;
import net.veroxuniverse.epicsamurai.entity.variant.KitsuneVariant;
import net.veroxuniverse.epicsamurai.entity.variant.KomainuVariant;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class KitsuneRenderer extends GeoEntityRenderer<KitsuneEntity> {

    private static final Map<KitsuneVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KitsuneVariant.class), map -> {
                map.put(KitsuneVariant.DEFAULT,
                        new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune.png"));
                map.put(KitsuneVariant.BLUE,
                        new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune_blue.png"));
            });

    public KitsuneRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KitsuneModel());
        this.shadowRadius = 0.3f;
        //this.addLayer(new KitsuneGlowLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(KitsuneEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public void render(KitsuneEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}