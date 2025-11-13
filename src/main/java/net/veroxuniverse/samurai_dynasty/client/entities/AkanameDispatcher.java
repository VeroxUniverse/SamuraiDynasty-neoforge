package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.veroxuniverse.samurai_dynasty.entity.custom.AkanameEntity;

public class AkanameDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand WALK_COMMAND = AzCommand.create(
            "base_controller",
            "walk",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand ATTACK_COMMAND = AzCommand.create(
            "attack_controller",
            "attack",
            AzPlayBehaviors.PLAY_ONCE
    );

    private final AkanameEntity akanameEntity;

    public AkanameDispatcher(AkanameEntity animatable) {
        this.akanameEntity = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(akanameEntity);
    }

    public void walk() {
        WALK_COMMAND.sendForEntity(akanameEntity);
    }

    public void attack() {
        ATTACK_COMMAND.sendForEntity(akanameEntity);
    }

}