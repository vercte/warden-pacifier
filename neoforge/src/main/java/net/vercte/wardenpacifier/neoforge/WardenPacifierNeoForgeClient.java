package net.vercte.wardenpacifier.neoforge;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.WardenRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.warden.Warden;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.vercte.wardenpacifier.pacifier.WardenPacifierLayer;
import net.vercte.wardenpacifier.pacifier.WardenPacifierModel;

public class WardenPacifierNeoForgeClient {
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WardenPacifierModel.LAYER, WardenPacifierModel::createBodyLayer);
    }

    public static void addEntityRenderLayers(final EntityRenderersEvent.AddLayers event) {
        EntityRenderer<Warden> renderer = event.getRenderer(EntityType.WARDEN);
        if(renderer instanceof WardenRenderer wardenRenderer) {
            wardenRenderer.addLayer(new WardenPacifierLayer<>(wardenRenderer));
        }
    }
}
