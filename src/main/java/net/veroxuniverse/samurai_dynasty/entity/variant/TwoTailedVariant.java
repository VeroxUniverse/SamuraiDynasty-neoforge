package net.veroxuniverse.samurai_dynasty.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum TwoTailedVariant {

    DEFAULT(0),
    BLUE(1);

    private static final TwoTailedVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(TwoTailedVariant::getId)).toArray(TwoTailedVariant[]::new);
    private final int id;

    TwoTailedVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static TwoTailedVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
