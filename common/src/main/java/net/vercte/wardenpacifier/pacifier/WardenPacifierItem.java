package net.vercte.wardenpacifier.pacifier;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WardenPacifierItem extends Item {
    public WardenPacifierItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @NotNull
    public static InteractionResult useOnWarden(Player player, InteractionHand hand, Level level, Warden warden) {
        Pacifiable pacifiable = (Pacifiable)warden;
        if(pacifiable.wardenpacifier$isPacified()) return InteractionResult.PASS;

        player.getItemInHand(hand).shrink(1);
        warden.playSound(SoundEvents.ZOMBIE_VILLAGER_CURE);

        pacifiable.wardenpacifier$pacify();
        return InteractionResult.SUCCESS;
    }
}
