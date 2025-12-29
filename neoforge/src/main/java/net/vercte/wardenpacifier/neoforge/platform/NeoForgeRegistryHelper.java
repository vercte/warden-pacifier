package net.vercte.wardenpacifier.neoforge.platform;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.core.Registry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.wardenpacifier.WardenPacifier;
import net.vercte.wardenpacifier.platform.services.IRegistryHelper;

import java.util.Map;
import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {
    private final static Map<Registry<?>, DeferredRegister<?>> deferredRegisters = new Object2ObjectLinkedOpenHashMap<>();

    @Override
    public <V, T extends V> Supplier<T> register(Registry<V> registry, String path, Supplier<T> object) {
        return getOrCreateDeferredRegister(registry).register(path, object);
    }

    @SuppressWarnings("unchecked") // IT WILL WORK
    private <T> DeferredRegister<T> getOrCreateDeferredRegister(Registry<T> registry) {
        return (DeferredRegister<T>)deferredRegisters.computeIfAbsent(registry, r -> DeferredRegister.create(registry, WardenPacifier.ID));
    }

    public static void register(IEventBus bus) {
        deferredRegisters.forEach((r, d) -> d.register(bus));
    }
}
