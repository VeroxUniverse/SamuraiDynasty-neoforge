package net.veroxuniverse.samurai_dynasty.client.projectiles;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.veroxuniverse.samurai_dynasty.entity.custom.ThrownShurikenEntity;

public class ThrownShurikenDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );
    private final ThrownShurikenEntity entity;

    public ThrownShurikenDispatcher(ThrownShurikenEntity animatable) {
        this.entity = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(entity);
    }

}