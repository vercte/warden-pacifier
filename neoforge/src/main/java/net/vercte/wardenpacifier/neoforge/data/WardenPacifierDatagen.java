package net.vercte.wardenpacifier.neoforge.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.vercte.wardenpacifier.neoforge.data.assets.ItemModelGen;
import net.vercte.wardenpacifier.neoforge.data.assets.LangGen;

public class WardenPacifierDatagen {
    public static void gatherData(final GatherDataEvent event) {
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if(event.includeClient()) {
            event.addProvider(new ItemModelGen(output, existingFileHelper));
            event.addProvider(new LangGen(output));
        }
    }
}
