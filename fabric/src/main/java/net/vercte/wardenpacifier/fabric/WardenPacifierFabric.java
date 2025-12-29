package net.vercte.wardenpacifier.fabric;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.vercte.wardenpacifier.ModItems;
import net.vercte.wardenpacifier.WardenPacifier;
import net.fabricmc.api.ModInitializer;
import net.vercte.wardenpacifier.pacifier.WardenPacifierItem;

public final class WardenPacifierFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        WardenPacifier.init();

        UseEntityCallback.EVENT.register(WardenPacifierFabric::useEntity);
    }

    private static InteractionResult useEntity(Player player, Level level, InteractionHand hand, Entity entity, EntityHitResult hitResult) {
        boolean isPacifier = player.getItemInHand(hand).is(ModItems.WARDEN_PACIFIER.get());
        boolean isWarden = entity instanceof Warden;
        if(!isPacifier || !isWarden) return InteractionResult.PASS;

        return WardenPacifierItem.useOnWarden(player, hand, level, (Warden)entity);
    }
}
