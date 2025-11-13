package net.veroxuniverse.samurai_dynasty.client.entities;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.veroxuniverse.samurai_dynasty.entity.custom.EnenraEntity;

public class EnenraDispatcher {
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


    private final EnenraEntity entity;

    public EnenraDispatcher(EnenraEntity animatable) {
        this.entity = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(entity);
    }

    public void walk() {
        WALK_COMMAND.sendForEntity(entity);
    }

}