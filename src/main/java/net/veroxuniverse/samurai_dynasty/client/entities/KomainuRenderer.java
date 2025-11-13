package net.veroxuniverse.samurai_dynasty.client.entities;

import com.google.common.collect.Maps;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.KomainuEntity;
import net.veroxuniverse.samurai_dynasty.entity.variant.KomainuVariant;

import java.util.Map;

public class KomainuRenderer extends AzEntityRenderer<KomainuEntity> {

    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/komainu.geo.json"
    );

    private static final Map<KomainuVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KomainuVariant.class), map -> {
                map.put(KomainuVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/komainu.png"
                        ));
                map.put(KomainuVariant.BLUE,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/komainu_blue.png"
                        ));
                map.put(KomainuVariant.RED,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/komainu_red.png"
                        ));
            });

    public KomainuRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<KomainuEntity>builder(
                                komainu -> GEO,
                                komainu -> LOCATION_BY_VARIANT.getOrDefault(
                                        komainu.getVariant(),
                                        LOCATION_BY_VARIANT.get(KomainuVariant.DEFAULT)
                                )
                        )
                        .setAnimatorProvider(KomainuAnimator::new)
                        .setShadowRadius(0.3f)
                        .build(),
                context
        );
    }
}