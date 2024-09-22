package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo.TetsuboItemNetheriteRenderer;

import java.util.function.Consumer;

public class TetsuboNetheriteItem extends ESWeaponItem{

    public TetsuboNetheriteItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<mod.azure.azurelib.common.internal.client.RenderProvider> consumer) {
        consumer.accept(new mod.azure.azurelib.common.internal.client.RenderProvider() {
            private TetsuboItemNetheriteRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new TetsuboItemNetheriteRenderer();
                return this.renderer;
            }
        });
    }

}
