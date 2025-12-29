package net.vercte.wardenpacifier.neoforge;

import net.vercte.wardenpacifier.WardenPacifier;
import net.neoforged.fml.common.Mod;

@Mod(WardenPacifier.ID)
public final class WardenPacifierNeoForge {
    public WardenPacifierNeoForge() {
        // Run our common setup.
        WardenPacifier.init();
    }
}
