package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.ArmorAnimator;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;

public class SteelSamuraiArmorRenderer extends AzArmorRenderer {

    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/samurai_armor_new.geo.json"
    );

    private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/models/armor/steel_samurai/red_samurai_armor.png"
    );

    public SteelSamuraiArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(
                                (entity, stack) -> MODEL,
                                (entity, stack) -> {

                                    if (!(stack.getItem() instanceof SteelSamuraiArmorItem armor)) {
                                        return DEFAULT_TEXTURE;
                                    }

                                    String colorName = armor.getColorNameFromRGB(SteelSamuraiArmorItem.getColor(stack));

                                    return ResourceLocation.fromNamespaceAndPath(
                                            SamuraiDynastyMod.MOD_ID,
                                            "textures/models/armor/steel_samurai/" + colorName + "_samurai_armor.png"
                                    );
                                }

                        )
                        .setAnimatorProvider(ArmorAnimator::new)
                        .build()
        );
    }
}
