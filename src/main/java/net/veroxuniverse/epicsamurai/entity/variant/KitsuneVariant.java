package net.veroxuniverse.epicsamurai.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum KitsuneVariant {

    DEFAULT(0),
    BLUE(1);

    private static final KitsuneVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(KitsuneVariant::getId)).toArray(KitsuneVariant[]::new);
    private final int id;

    KitsuneVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static KitsuneVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
