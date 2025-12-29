package net.vercte.wardenpacifier.neoforge.data.assets;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.vercte.wardenpacifier.ModItems;
import net.vercte.wardenpacifier.WardenPacifier;

public class LangGen extends LanguageProvider {
    public LangGen(PackOutput output) {
        super(output, WardenPacifier.ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.WARDEN_PACIFIER, "Warden Pacifier");
    }
}
