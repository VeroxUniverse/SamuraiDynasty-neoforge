package net.veroxuniverse.samurai_dynasty.item;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi.WakizashiItemRenderer;

import java.util.function.Consumer;

public class WakizashiItem extends ESWeaponItem{

    public WakizashiItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private WakizashiItemRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new WakizashiItemRenderer();
                return this.renderer;
            }
        });
    }

}
