package net.vercte.wardenpacifier;

import net.minecraft.resources.ResourceLocation;

public final class WardenPacifier {
    public static final String ID = "wardenpacifier";

    public static void init() {
        ModItems.init();
    }

    public static ResourceLocation at(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}
