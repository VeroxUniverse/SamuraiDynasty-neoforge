package net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class TonbukiriItemNetheriteRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/tonbukiri.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/weapon/tonbukiri_netherite.png"
    );

    public TonbukiriItemNetheriteRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX).build()
        );
    }
}