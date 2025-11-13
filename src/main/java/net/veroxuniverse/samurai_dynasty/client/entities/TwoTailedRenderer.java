package net.veroxuniverse.samurai_dynasty.client.entities;

import com.google.common.collect.Maps;
import mod.azure.azurelib.common.render.entity.AzEntityRenderer;
import mod.azure.azurelib.common.render.entity.AzEntityRendererConfig;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.TwoTailedFox;
import net.veroxuniverse.samurai_dynasty.entity.variant.TwoTailedVariant;

import java.util.Map;

public class TwoTailedRenderer extends AzEntityRenderer<TwoTailedFox> {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/kitsune_small.geo.json"
    );

    private static final Map<TwoTailedVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TwoTailedVariant.class), map -> {
                map.put(TwoTailedVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/kitsune_small.png"
                        ));
                map.put(TwoTailedVariant.BLUE,
                        ResourceLocation.fromNamespaceAndPath(
                                SamuraiDynastyMod.MOD_ID,
                                "textures/entity/kitsune_small_blue.png"
                        ));
            });

    public TwoTailedRenderer(EntityRendererProvider.Context context) {
        super(
                AzEntityRendererConfig.<TwoTailedFox>builder(
                                entity -> GEO,
                                entity -> LOCATION_BY_VARIANT.getOrDefault(
                                        entity.getVariant(),
                                        LOCATION_BY_VARIANT.get(TwoTailedVariant.DEFAULT)
                                )
                        )
                        .setAnimatorProvider(TwoTailedAnimator::new)
                        .setShadowRadius(0.3f)
                        .build(),
                context
        );
    }
}
