package net.veroxuniverse.samurai_dynasty.curios.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.samurai_dynasty.curios.model.OniMaskModel;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.theillusivec4.curios.api.client.ICurioRenderer.HumanoidRender;

public class OniMaskRenderer implements HumanoidRender {
    private static final ResourceLocation ONI_MASK_LOCATION = new ResourceLocation("samurai_dynasty:textures/armor/oni_mask.png");
    private final OniMaskModel oniMaskModel;

    public OniMaskRenderer() {
        this.oniMaskModel = new OniMaskModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(OniMaskModel.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing,
                                                                          float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStack.translate(0,0,0);
        LivingEntity entity = slotContext.entity();
        ICurioRenderer.followHeadRotations(entity, this.oniMaskModel.bipedArmorHead);
        //ICurioRenderer.rotateIfSneaking(matrixStack, entity);
        this.oniMaskModel.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
        this.oniMaskModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(ONI_MASK_LOCATION), false, stack.hasFoil());
        this.oniMaskModel.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public HumanoidModel<LivingEntity> getModel(ItemStack arg0, SlotContext arg1) {
        return this.oniMaskModel;
    }

    @Override
    public ResourceLocation getModelTexture(ItemStack arg0, SlotContext arg1) {
        return ONI_MASK_LOCATION;
    }
}