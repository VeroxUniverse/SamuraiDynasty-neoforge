package net.veroxuniverse.samurai_dynasty.client.entities;

import com.google.common.collect.Maps;
import mod.azure.azurelib.render.entity.AzEntityRenderer;
import mod.azure.azurelib.render.entity.AzEntityRendererConfig;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.KitsuneEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.TwoTailedFox;
import net.veroxuniverse.samurai_dynasty.entity.variant.KitsuneVariant;
import net.veroxuniverse.samurai_dynasty.entity.variant.TwoTailedVariant;

import java.util.Map;

public class KitsuneRenderer extends AzEntityRenderer<KitsuneEntity> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/kitsune.geo.json"
    );

    private static final Map<KitsuneVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KitsuneVariant.class), map -> {
                map.put(KitsuneVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/kitsune.png"
                        ));
                map.put(KitsuneVariant.BLUE,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/kitsune_blue.png"
                        ));
            });

    public KitsuneRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<KitsuneEntity>builder(
                                entity -> GEO,
                                entity -> LOCATION_BY_VARIANT.getOrDefault(
                                        entity.getVariant(),
                                        LOCATION_BY_VARIANT.get(KitsuneVariant.DEFAULT)
                                )
                        )
                        .setAnimatorProvider(KitsuneAnimator::new)
                        .setShadowRadius(0.4f)
                        .build(),
                context
        );
    }
}