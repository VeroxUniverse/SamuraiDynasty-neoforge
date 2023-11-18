package net.veroxuniverse.epicsamurai.reiki;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerKiProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerKi> PLAYER_KI = CapabilityManager.get(new CapabilityToken<PlayerKi>() {
    });

    private PlayerKi ki = null;
    private final LazyOptional<PlayerKi> optional = LazyOptional.of(this::createPlayerKi);

    private PlayerKi createPlayerKi() {
        if (this.ki == null) {
            this.ki = new PlayerKi();
        }

        return this.ki;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_KI) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerKi().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerKi().loadNBTData(nbt);
    }
}