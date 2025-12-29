package net.vercte.wardenpacifier.neoforge.data.assets;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.vercte.wardenpacifier.ModItems;
import net.vercte.wardenpacifier.WardenPacifier;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WardenPacifier.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.WARDEN_PACIFIER.get());
    }
}