package net.veroxuniverse.epicsamurai.curios.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

public class OniMaskModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(EpicSamuraiMod.MOD_ID, "oni_mask.geo_converted_converted"), "main");
    public final ModelPart bipedArmorHead;

	public OniMaskModel(ModelPart root) {
        super(root);
        this.bipedArmorHead = root.getChild("bipedArmorHead");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bipedArmorHead = partdefinition.addOrReplaceChild("bipedArmorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition armorHead = bipedArmorHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition mask = armorHead.addOrReplaceChild("mask", CubeListBuilder.create().texOffs(5, 5).addBox(-4.5F, -3.5F, -4.5F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition mask_r1 = mask.addOrReplaceChild("mask_r1", CubeListBuilder.create().texOffs(44, 25).addBox(-5.0F, -1.2F, -4.8F, 10.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition nose = mask.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(0.0F, -4.3F, -4.9F));

        PartDefinition nose_r1 = nose.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -1.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition jaw = mask.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(11, 26).addBox(-3.0F, -0.5F, -2.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(29, 26).addBox(-3.5F, -3.2F, -1.3F, 7.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.3F, -3.7F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition hat = partdefinition.addOrReplaceChild("hat", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition body = partdefinition.addOrReplaceChild("body", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", new CubeListBuilder(), PartPose.ZERO);
        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", new CubeListBuilder(), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bipedArmorHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void copyPropertiesTo(HumanoidModel<T> humanoidModel) {
        super.copyPropertiesTo(humanoidModel);
        bipedArmorHead.copyFrom(humanoidModel.head);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(bipedArmorHead);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return null;
    }
}