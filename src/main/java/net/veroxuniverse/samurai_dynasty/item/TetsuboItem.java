package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.odachi.OdachiItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo.TetsuboItemRenderer;

import java.util.function.Consumer;

public class TetsuboItem extends ESWeaponItem{

    public TetsuboItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<mod.azure.azurelib.common.internal.client.RenderProvider> consumer) {
        consumer.accept(new mod.azure.azurelib.common.internal.client.RenderProvider() {
            private TetsuboItemRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new TetsuboItemRenderer();
                return this.renderer;
            }
        });
    }

}
