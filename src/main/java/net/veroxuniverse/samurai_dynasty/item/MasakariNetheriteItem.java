package net.veroxuniverse.samurai_dynasty.item;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.masakari.MasakariItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.masakari.MasakariItemRenderer;

import java.util.function.Consumer;

public class MasakariNetheriteItem extends ESWeaponItem{

    public MasakariNetheriteItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private MasakariItemNetheriteRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new MasakariItemNetheriteRenderer();
                return this.renderer;
            }
        });
    }

}
