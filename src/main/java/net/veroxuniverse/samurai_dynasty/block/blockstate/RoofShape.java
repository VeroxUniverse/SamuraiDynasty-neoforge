package net.veroxuniverse.samurai_dynasty.block.blockstate;

import net.minecraft.util.StringRepresentable;

public enum RoofShape implements StringRepresentable {
    STRAIGHT("straight"),
    OUTER_LEFT("outer_left"),
    OUTER_RIGHT("outer_right"),
    INNER_LEFT("inner_left"),
    INNER_RIGHT("inner_right");

    private final String name;

    RoofShape(String name) {
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