package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri.TonbukiriItemNetheriteRenderer;

import java.util.function.Consumer;

public class TonbukiriNetheriteItem extends ESWeaponItem{

    public TonbukiriNetheriteItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<mod.azure.azurelib.common.internal.client.RenderProvider> consumer) {
        consumer.accept(new mod.azure.azurelib.common.internal.client.RenderProvider() {
            private TonbukiriItemNetheriteRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new TonbukiriItemNetheriteRenderer();
                return this.renderer;
            }
        });
    }

}
