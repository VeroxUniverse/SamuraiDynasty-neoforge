package net.veroxuniverse.epicsamurai.client;

public class ClientKiData {

    private static int playerKi;

    public static void set(int ki) {
        ClientKiData.playerKi = ki;
    }

    public static int getPlayerKi() {
        return playerKi;
    }
}
