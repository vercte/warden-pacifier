package net.vercte.wardenpacifier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.vercte.wardenpacifier.pacifier.WardenPacifierItem;
import net.vercte.wardenpacifier.platform.Services;

import java.util.function.Supplier;

public class ModItems {
    public static final Supplier<Item> WARDEN_PACIFIER = Services.REGISTRY.register(BuiltInRegistries.ITEM, "warden_pacifier", WardenPacifierItem::new);

    public static void init() {}
}
