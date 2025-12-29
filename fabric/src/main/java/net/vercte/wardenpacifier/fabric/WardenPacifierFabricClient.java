package net.vercte.wardenpacifier.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.vercte.wardenpacifier.pacifier.WardenPacifierModel;

public final class WardenPacifierFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(WardenPacifierModel.LAYER, WardenPacifierModel::createBodyLayer);
    }
}
