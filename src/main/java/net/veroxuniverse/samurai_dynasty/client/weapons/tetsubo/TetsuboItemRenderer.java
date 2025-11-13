package net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class TetsuboItemRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/tetsubo.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/weapon/tetsubo.png"
    );

    public TetsuboItemRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX).build()
        );
    }
}