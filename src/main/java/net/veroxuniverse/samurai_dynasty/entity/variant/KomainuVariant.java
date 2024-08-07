package net.veroxuniverse.samurai_dynasty.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum KomainuVariant {

    DEFAULT(0),
    BLUE(1),
    RED(2);

    private static final KomainuVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(KomainuVariant::getId)).toArray(KomainuVariant[]::new);
    private final int id;

    KomainuVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static KomainuVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
