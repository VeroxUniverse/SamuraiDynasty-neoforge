package net.veroxuniverse.samurai_dynasty.item;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi.WakizashiItemNetheriteRenderer;

import java.util.function.Consumer;

public class WakizashiNetheriteItem extends ESWeaponItem{

    public WakizashiNetheriteItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private WakizashiItemNetheriteRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new WakizashiItemNetheriteRenderer();
                return this.renderer;
            }
        });
    }

}
