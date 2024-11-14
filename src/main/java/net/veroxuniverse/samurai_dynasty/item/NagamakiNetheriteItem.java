package net.veroxuniverse.samurai_dynasty.item;

import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tier;
import net.veroxuniverse.samurai_dynasty.client.weapons.masakari.MasakariItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki.NagamakiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki.NagamakiItemRenderer;

import java.util.function.Consumer;

public class NagamakiNetheriteItem extends ESWeaponItem{

    public NagamakiNetheriteItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    // Creates the render
    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private NagamakiItemNetheriteRenderer renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new NagamakiItemNetheriteRenderer();
                return this.renderer;
            }
        });
    }

}
