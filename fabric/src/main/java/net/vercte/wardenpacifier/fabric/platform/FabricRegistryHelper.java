package net.vercte.wardenpacifier.fabric.platform;

import net.minecraft.core.Registry;
import net.vercte.wardenpacifier.WardenPacifier;
import net.vercte.wardenpacifier.platform.services.IRegistryHelper;

import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {
    @Override
    public <V, T extends V> Supplier<T> register(Registry<V> registry, String path, Supplier<T> object) {
        T result = Registry.register(registry, WardenPacifier.at(path), object.get());
        return () -> result;
    }
}

