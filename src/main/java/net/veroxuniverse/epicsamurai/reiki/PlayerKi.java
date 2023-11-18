package net.veroxuniverse.epicsamurai.reiki;

import net.minecraft.nbt.CompoundTag;

public class PlayerKi {
    private int ki;
    private final int MIN_KI = 0;
    private final int MAX_KI = 400;

    public int getKi() {
        return ki;
    }

    public void addKi(int add) {
        this.ki = Math.min(ki + add, MAX_KI);
    }

    public void subKi(int sub) {
        this.ki = Math.max(ki - sub, MIN_KI);
    }

    public void copyFrom(PlayerKi source) {
        this.ki = source.ki;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ki", ki);
    }

    public void loadNBTData(CompoundTag nbt) {
        ki = nbt.getInt("ki");
    }
}