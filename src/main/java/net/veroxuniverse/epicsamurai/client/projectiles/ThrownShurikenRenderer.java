package net.veroxuniverse.epicsamurai.client.projectiles;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.ThrownShurikenEntity;

public class ThrownShurikenRenderer extends GeoEntityRenderer<ThrownShurikenEntity> {
    public ThrownShurikenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ThrownShurkienModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownShurikenEntity instance) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/item/shuriken.png");
    }

}
