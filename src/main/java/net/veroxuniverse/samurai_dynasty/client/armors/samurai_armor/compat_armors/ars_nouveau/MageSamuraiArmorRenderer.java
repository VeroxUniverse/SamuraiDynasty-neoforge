package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.ars_nouveau;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.ArmorAnimator;
import net.veroxuniverse.samurai_dynasty.item.armor.MageSamuraiArmorItem;

public class MageSamuraiArmorRenderer extends AzArmorRenderer {

    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/two_sword_samurai_armor.geo.json"
    );

    private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_purple.png"
    );

    public MageSamuraiArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(
                                (entity, stack) -> MODEL,
                                (entity, stack) -> {

                                    if (!(stack.getItem() instanceof MageSamuraiArmorItem armor)) {
                                        return DEFAULT_TEXTURE;
                                    }

                                    String color = armor.getColor(stack);

                                    return ResourceLocation.fromNamespaceAndPath(
                                            SamuraiDynastyMod.MOD_ID,
                                            "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + color + ".png"
                                    );
                                }

                        )
                        .setAnimatorProvider(ArmorAnimator::new)
                        .build()
        );
    }
}




