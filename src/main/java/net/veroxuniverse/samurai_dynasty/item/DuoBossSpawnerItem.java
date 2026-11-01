package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossPair;
import net.veroxuniverse.samurai_dynasty.entity.custom.FujinEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.RaijinEntity;
import org.jetbrains.annotations.NotNull;

public class DuoBossSpawnerItem extends Item {

    public DuoBossSpawnerItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if (context.getLevel() instanceof ServerLevel serverLevel) {
            BlockPos pos = context.getClickedPos().above();

            RaijinEntity raijin = ModEntityTypes.RAIJIN.get().create(serverLevel);
            FujinEntity fujin = ModEntityTypes.FUJIN.get().create(serverLevel);

            if (raijin != null && fujin != null) {
                raijin.moveTo(pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() - 2.5D, 0.0F, 0.0F);
                fujin.moveTo(pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 2.5D, 0.0F, 0.0F);

                DuoBossPair pair = new DuoBossPair();
                pair.link(raijin, fujin);
                raijin.duoBossPair = pair;
                fujin.duoBossPair = pair;

                serverLevel.addFreshEntity(raijin);
                serverLevel.addFreshEntity(fujin);
            }
        }
        return InteractionResult.SUCCESS;
    }
}