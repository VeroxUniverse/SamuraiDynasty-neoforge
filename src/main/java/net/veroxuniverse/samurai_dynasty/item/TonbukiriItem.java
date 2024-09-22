package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri.TonbukiriItemRenderer;

import java.util.function.Consumer;

public class TonbukiriItem extends ESWeaponItem{

    public TonbukiriItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<mod.azure.azurelib.common.internal.client.RenderProvider> consumer) {
        consumer.accept(new mod.azure.azurelib.common.internal.client.RenderProvider() {
            private TonbukiriItemRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new TonbukiriItemRenderer();
                return this.renderer;
            }
        });
    }

}
