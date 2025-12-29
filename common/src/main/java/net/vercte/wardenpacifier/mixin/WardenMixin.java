package net.vercte.wardenpacifier.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.phys.Vec3;
import net.vercte.wardenpacifier.pacifier.Pacifiable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Warden.class)
@Debug(export = true)
public class WardenMixin implements Pacifiable {
    @Unique
    private boolean wardenpacifier$pacified = false;

    @Override
    public void wardenpacifier$pacify() {
        wardenpacifier$pacified = true;
    }

    @Override
    public boolean wardenpacifier$isPacified() {
        return wardenpacifier$pacified;
    }

    @WrapWithCondition(method = "customServerAiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/warden/Warden;applyDarknessAround(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;I)V"))
    private boolean canApplyDarkness(ServerLevel serverLevel, Vec3 vec3, Entity entity, int i) {
        return !wardenpacifier$isPacified();
    }

    @ModifyReturnValue(method = "canTargetEntity", at = @At("RETURN"))
    private boolean cannotTargetEntityIfPacified(boolean original) {
        return original && !wardenpacifier$isPacified();
    }

    @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"), index = 5)
    private float quieterHeartbeatIfPacified(float volume) {
        if(wardenpacifier$isPacified()) return 0.5f;
        return volume;
    }
}
