package net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class NagamakiItemNetheriteRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/nagamaki.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/weapon/nagamaki_netherite.png"
    );

    public NagamakiItemNetheriteRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX).build()
        );
    }
}