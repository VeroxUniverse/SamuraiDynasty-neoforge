package net.veroxuniverse.epicsamurai.client.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

@OnlyIn(Dist.CLIENT)
public class ShurikenModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(EpicSamuraiMod.MOD_ID,"textures/entity/shuriken.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/shuriken.png"), "main");
    private final ModelPart shuriken;

    public ShurikenModel(ModelPart pRoot) {
        super(RenderType::entitySolid);
        this.shuriken = pRoot;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition shuriken = partdefinition.addOrReplaceChild("shuriken", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -15.7F, 6.0F, 4.0F, 0.4F, 4.0F)
                .texOffs(0, 0).addBox(-9.0F, -15.7F, 9.0F, 2.0F, 0.4F, 0.0F)
                .texOffs(0, 0).mirror().addBox(-9.0F, -15.7F, 7.0F, 2.0F, 0.4F, 0.0F).mirror(false)
                .texOffs(0, -2).addBox(-9.0F, -15.7F, 7.0F, 0.0F, 0.4F, 2.0F)
                .texOffs(0, -2).mirror().addBox(-7.0F, -15.7F, 7.0F, 0.0F, 0.4F, 2.0F).mirror(false), PartPose.offset(8.0F, 24.0F, -8.0F));

        PartDefinition cube_r1 = shuriken.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-2, 14).addBox(-4.7779F, 0.0F, -1.0824F, 3.0F, 0.0F, 2.0F)
                .texOffs(-2, 14).addBox(1.7779F, 0.0F, -0.9176F, 3.0F, 0.0F, 2.0F)
                .texOffs(9, 13).addBox(-1.0824F, 0.0F, 1.7779F, 2.0F, 0.0F, 3.0F)
                .texOffs(9, 13).addBox(-0.9176F, 0.0F, -4.7779F, 2.0F, 0.0F, 3.0F), PartPose.offsetAndRotation(-8.0F, -15.5F, 8.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r2 = shuriken.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).addBox(0.8284F, -0.1F, -4.0F, 2.0F, 0.2F, 4.0F)
                .texOffs(0, 8).addBox(-2.8284F, -0.1F, 0.0F, 2.0F, 0.2F, 4.0F)
                .texOffs(0, 5).addBox(0.0F, -0.1F, 0.8284F, 4.0F, 0.2F, 2.0F)
                .texOffs(0, 5).addBox(-4.0F, -0.1F, -2.8284F, 4.0F, 0.2F, 2.0F), PartPose.offsetAndRotation(-8.0F, -15.5F, 8.0F, 0.0F, 0.7854F, 0.0F));
        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.shuriken.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}