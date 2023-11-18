package net.veroxuniverse.epicsamurai.network;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;

public class FriendlyByteBufs {

    public static FriendlyByteBuf create() {
        return new FriendlyByteBuf(Unpooled.buffer());
    }

}
