package net.veroxuniverse.samurai_dynasty.block.blockstate;

import net.minecraft.util.StringRepresentable;

public enum FlameType implements StringRepresentable {
    NORMAL("normal"),
    SOUL("soul");

    private final String name;

    FlameType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
