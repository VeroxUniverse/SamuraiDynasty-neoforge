package net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class WakizashiItemRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/wakizashi.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/weapon/katana.png"
    );

    public WakizashiItemRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX).build()
        );
    }
}