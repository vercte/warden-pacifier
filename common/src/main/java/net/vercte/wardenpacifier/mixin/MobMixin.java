package net.vercte.wardenpacifier.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.Mob;
import net.vercte.wardenpacifier.pacifier.Pacifiable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Mob.class)
public class MobMixin {
    @ModifyReturnValue(method = "requiresCustomPersistence", at = @At("RETURN"))
    public boolean persistIfPacified(boolean original) {
        if(this instanceof Pacifiable pacifiable) return original || pacifiable.wardenpacifier$isPacified();
        return original;
    }
}
