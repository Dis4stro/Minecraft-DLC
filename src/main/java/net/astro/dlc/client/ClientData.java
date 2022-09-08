package net.astro.dlc.client;

public class ClientData {
    private static boolean isFrozen;

    public static void setIsFrozen(boolean pIsFrozen) {
        ClientData.isFrozen = pIsFrozen;
    }

    public static boolean getIsFrozen() {
        return isFrozen;
    }
}
