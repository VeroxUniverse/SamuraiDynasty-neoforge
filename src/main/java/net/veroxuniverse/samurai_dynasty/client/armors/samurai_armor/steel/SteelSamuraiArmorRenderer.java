package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.core.object.Color;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.component.DyedItemColor;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.armors.ColorGeoLayer;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;

public class SteelSamuraiArmorRenderer extends GeoArmorRenderer<SteelSamuraiArmorItem> {

    public SteelSamuraiArmorRenderer() {
        super(new SteelSamuraiArmorModel());
        ColorGeoLayer<SteelSamuraiArmorItem> colorLayer = new ColorGeoLayer<>(this, ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/steel_samurai_overlay.png"));
        this.addRenderLayer(colorLayer);
    }

    @Override
    public Color getRenderColor(SteelSamuraiArmorItem animatable, float partialTick, int packedLight) {
        if (this.currentStack.is(ItemTags.DYEABLE)) {
            int colorValue = DyedItemColor.getOrDefault(this.currentStack, 0xFFAB1A2D);
            return Color.ofOpaque(colorValue);
        }
        return Color.ofOpaque(0xFFAB1A2D);
    }

}
