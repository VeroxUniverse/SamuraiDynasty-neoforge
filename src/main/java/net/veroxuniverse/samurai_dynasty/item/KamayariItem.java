package net.veroxuniverse.samurai_dynasty.item;

import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemRenderer;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class KamayariItem extends ESWeaponItem{
    public KamayariItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    // Creates the render
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            // Your render made above
            private KamayariItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new KamayariItemRenderer();
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

}
