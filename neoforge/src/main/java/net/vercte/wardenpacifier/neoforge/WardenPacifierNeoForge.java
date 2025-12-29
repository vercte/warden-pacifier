package net.vercte.wardenpacifier.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.vercte.wardenpacifier.WardenPacifier;
import net.neoforged.fml.common.Mod;
import net.vercte.wardenpacifier.neoforge.platform.NeoForgeRegistryHelper;

@Mod(WardenPacifier.ID)
public final class WardenPacifierNeoForge {
    public WardenPacifierNeoForge(IEventBus modEventBus) {
        WardenPacifier.init();
        NeoForgeRegistryHelper.register(modEventBus);
    }
}
