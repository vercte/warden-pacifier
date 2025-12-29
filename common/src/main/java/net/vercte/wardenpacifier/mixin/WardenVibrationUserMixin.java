package net.vercte.wardenpacifier.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.monster.warden.Warden;
import net.vercte.wardenpacifier.pacifier.Pacifiable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Warden.VibrationUser.class)
public class WardenVibrationUserMixin {
    @Final
    @Shadow(aliases = {"field_44600"})
    Warden warden;

    @ModifyReturnValue(method = "canReceiveVibration", at = @At("RETURN"))
    private boolean pacifiedCannotRecieveVibrations(boolean original) {
        return original && !((Pacifiable)warden).wardenpacifier$isPacified();
    }
}
