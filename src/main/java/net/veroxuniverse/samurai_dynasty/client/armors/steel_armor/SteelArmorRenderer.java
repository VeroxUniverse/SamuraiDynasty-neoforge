package net.veroxuniverse.samurai_dynasty.client.armors.steel_armor;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.ArmorAnimator;

public class SteelArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/steel_armor_new.geo.json"
    );

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/models/armor/steel.png"
    );

    public SteelArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(MODEL, TEXTURE)
                        .setAnimatorProvider(ArmorAnimator::new)
                        .build()
        );
    }
}
