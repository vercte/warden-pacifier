package net.vercte.wardenpacifier.pacifier;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.WardenModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.warden.Warden;
import net.vercte.wardenpacifier.WardenPacifier;

public class WardenPacifierLayer<T extends Warden, M extends WardenModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation PACIFIER_TEXTURE = WardenPacifier.at("textures/entity/warden_pacifier.png");

    public WardenPacifierLayer(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);
        WardenPacifierModel.init();
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int light, T entity, float f, float g, float h, float j, float k, float l) {
        if(!(entity instanceof Pacifiable pacifiable)) return;
        if(!pacifiable.wardenpacifier$isPacified()) return;

        poseStack.pushPose();
        getParentModel().root()
                .getChild("bone")
                .translateAndRotate(poseStack);

        getParentModel().root()
                .getChild("bone")
                .getChild("body")
                .translateAndRotate(poseStack);

        getParentModel().root()
                .getChild("bone")
                .getChild("body")
                .getChild("head")
                .translateAndRotate(poseStack);

        poseStack.translate(0, -22/16f, -6/16f);

        WardenPacifierModel.INSTANCE.renderToBuffer(
                poseStack,
                multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(PACIFIER_TEXTURE)),
                light,
                OverlayTexture.NO_OVERLAY
        );
        poseStack.popPose();
    }
}
