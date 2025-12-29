package net.vercte.wardenpacifier.neoforge;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.vercte.wardenpacifier.ModItems;
import net.vercte.wardenpacifier.WardenPacifier;
import net.neoforged.fml.common.Mod;
import net.vercte.wardenpacifier.neoforge.data.WardenPacifierDatagen;
import net.vercte.wardenpacifier.neoforge.platform.NeoForgeRegistryHelper;
import net.vercte.wardenpacifier.pacifier.WardenPacifierItem;

@Mod(WardenPacifier.ID)
public final class WardenPacifierNeoForge {
    public WardenPacifierNeoForge(IEventBus modEventBus) {
        WardenPacifier.init();
        NeoForgeRegistryHelper.register(modEventBus);

        modEventBus.addListener(WardenPacifierDatagen::gatherData);

        NeoForge.EVENT_BUS.addListener(WardenPacifierNeoForge::onPlayerInteract);
    }

    public static void onPlayerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        Entity target = event.getTarget();

        boolean isPacifier = player.getItemInHand(hand).is(ModItems.WARDEN_PACIFIER.get());
        boolean isWarden = target instanceof Warden;
        if(!isPacifier || !isWarden) return;

        InteractionResult result = WardenPacifierItem.useOnWarden(player, hand, event.getLevel(), (Warden)target);
        event.setCancellationResult(result);
    }
}
