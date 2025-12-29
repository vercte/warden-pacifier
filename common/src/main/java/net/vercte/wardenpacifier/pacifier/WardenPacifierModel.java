package net.vercte.wardenpacifier.pacifier;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.monster.warden.Warden;
import net.vercte.wardenpacifier.WardenPacifier;

public class WardenPacifierModel extends EntityModel<Warden> {
	public static final ModelLayerLocation LAYER = new ModelLayerLocation(WardenPacifier.at("pacifier"), "main");
	private final ModelPart root;

	public WardenPacifierModel(ModelPart root) {
		this.root = root.getChild("shield");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("shield", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -13.0F, -1.0F, 12.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 12).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
			.texOffs(0, 19).addBox(-5.0F, -8.0F, -2.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 32, 32);
	}

	@Override
	public void setupAnim(Warden entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, int k) {
		root.render(poseStack, vertexConsumer, i, j, k);
	}

	public static WardenPacifierModel INSTANCE;

	// I kinda stole this from sophisticated backpacks
	public static void init() {
		EntityModelSet entityModelSet = Minecraft.getInstance().getEntityModels();
		WardenPacifierModel.INSTANCE = new WardenPacifierModel(entityModelSet.bakeLayer(LAYER));
	}
}