package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.veroxuniverse.samurai_dynasty.entity.custom.KomainuEntity;
import net.veroxuniverse.samurai_dynasty.entity.custom.OnibiEntity;

public class OnibiDispatcher {
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

    private final OnibiEntity entity;

    public OnibiDispatcher(OnibiEntity animatable) {
        this.entity = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(entity);
    }

    public void walk() {
        WALK_COMMAND.sendForEntity(entity);
    }

    public void attack() {
        ATTACK_COMMAND.sendForEntity(entity);
    }

}