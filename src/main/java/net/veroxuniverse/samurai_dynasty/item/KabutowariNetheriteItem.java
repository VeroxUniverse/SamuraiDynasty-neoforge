package net.veroxuniverse.samurai_dynasty.item;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari.KabutowariItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemRenderer;

import java.util.function.Consumer;

public class KabutowariNetheriteItem extends ESWeaponItem{

    public KabutowariNetheriteItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private KabutowariItemNetheriteRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new KabutowariItemNetheriteRenderer();
                return this.renderer;
            }
        });
    }

}
