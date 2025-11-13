package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.ArmorAnimator;
import net.veroxuniverse.samurai_dynasty.item.armor.NetheriteSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;

public class NetheriteSamuraiArmorRenderer extends AzArmorRenderer {

    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "geo/two_sword_samurai_armor.geo.json"
    );

    private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            SamuraiDynastyMod.MOD_ID,
            "textures/models/armor/netherite_samurai/gray_netherite_samurai.png"
    );

    public NetheriteSamuraiArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(
                                (entity, stack) -> MODEL,
                                (entity, stack) -> {

                                    if (!(stack.getItem() instanceof NetheriteSamuraiArmorItem armor)) {
                                        return DEFAULT_TEXTURE;
                                    }

                                    String colorName = armor.getColorNameFromRGB(NetheriteSamuraiArmorItem.getColor(stack));

                                    return ResourceLocation.fromNamespaceAndPath(
                                            SamuraiDynastyMod.MOD_ID,
                                            "textures/models/armor/netherite_samurai/" + colorName + "_netherite_samurai_armor.png"
                                    );
                                }

                        )
                        .setAnimatorProvider(ArmorAnimator::new)
                        .build()
        );
    }
}