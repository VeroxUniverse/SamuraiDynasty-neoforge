package net.veroxuniverse.samurai_dynasty.client.entities;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KomainuEntity;
import net.veroxuniverse.samurai_dynasty.entity.variant.KomainuVariant;
import mod.azure.azurelib.renderer.GeoEntityRenderer;

import java.util.Map;

public class KomainuRenderer extends GeoEntityRenderer<KomainuEntity> {

    private static final Map<KomainuVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KomainuVariant.class), map -> {
                map.put(KomainuVariant.DEFAULT,
                        new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/komainu.png"));
                map.put(KomainuVariant.BLUE,
                        new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/komainu_blue.png"));
                map.put(KomainuVariant.RED,
                        new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/entity/komainu_red.png"));
            });

    public KomainuRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KomainuModel());
        this.shadowRadius = 0.3f;
        //this.addLayer(new KomainuGlowLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(KomainuEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public void render(KomainuEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.6f, 0.6f, 0.6f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}