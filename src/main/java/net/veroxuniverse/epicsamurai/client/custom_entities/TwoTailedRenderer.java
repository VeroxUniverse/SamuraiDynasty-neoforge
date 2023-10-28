package net.veroxuniverse.epicsamurai.client.custom_entities;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.KomainuEntity;
import net.veroxuniverse.epicsamurai.entity.custom.TwoTailedFox;
import net.veroxuniverse.epicsamurai.entity.variant.KomainuVariant;
import net.veroxuniverse.epicsamurai.entity.variant.TwoTailedVariant;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class TwoTailedRenderer extends GeoEntityRenderer<TwoTailedFox> {

    private static final Map<TwoTailedVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TwoTailedVariant.class), map -> {
                map.put(TwoTailedVariant.DEFAULT,
                        new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune_small.png"));
                map.put(TwoTailedVariant.BLUE,
                        new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kitsune_small_blue.png"));
            });

    public TwoTailedRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TwoTailedModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(TwoTailedFox instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public void render(TwoTailedFox entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}