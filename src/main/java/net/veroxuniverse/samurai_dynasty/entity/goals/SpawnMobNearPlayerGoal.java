package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.entity.custom.OnibiEntity;

import java.util.EnumSet;
import java.util.List;

public class SpawnMobNearPlayerGoal<T extends Mob> extends Goal {
    private final T mob;
    private final int spawnRange;
    private final int spawnCount;
    private int delay;

    public SpawnMobNearPlayerGoal(T mob, int spawnRange, int spawnCount) {
        this.mob = mob;
        this.spawnRange = spawnRange;
        this.spawnCount = spawnCount;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        List<LivingEntity> nearbyPlayers = mob.level().getEntitiesOfClass(
                LivingEntity.class,
                mob.getBoundingBox().inflate(spawnRange),
                entity -> entity instanceof Player
        );
        return !nearbyPlayers.isEmpty() && allOnibisAreDead();
    }

    private boolean allOnibisAreDead() {
        List<OnibiEntity> entityList = mob.level().getEntitiesOfClass(OnibiEntity.class,
                mob.getBoundingBox().inflate(spawnRange),
                onibi -> onibi.isAlive());
        return entityList.isEmpty();
    }

    @Override
    public void start() {
        delay = 20 * 3;
    }

    @Override
    public void tick() {
        if (delay > 0) {
            delay--;
            return;
        }

        for (int i = 0; i < spawnCount; i++) {
            spawnOnibi();
        }

        delay = 20;
    }

    private void spawnOnibi() {
        Level level = mob.level();
        BlockPos mobPos = mob.blockPosition();

        BlockPos spawnPos = mobPos.offset(mob.getRandom().nextInt(3) - 1, 0, mob.getRandom().nextInt(3) - 1);

        if (level.isEmptyBlock(spawnPos) && spawnPos.getY() < level.getMaxBuildHeight()) {
            OnibiEntity onibiEntity = new OnibiEntity(ModEntityTypes.ONIBI.get(), level);
            onibiEntity.moveTo(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), mob.getYRot(), 0.0F);
            onibiEntity.setTarget(mob.getTarget());

            level.addFreshEntity(onibiEntity);
        }
    }
}