package net.veroxuniverse.samurai_dynasty.block.blockstate;

import net.minecraft.util.StringRepresentable;

public enum SupportType implements StringRepresentable {
    NORMAL("normal"),
    WALL("wall"),
    HANGING("hanging");

    private final String name;

    SupportType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}