package net.veroxuniverse.epicsamurai.curios.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.epicsamurai.curios.model.KitsuneMaskModel;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class KitsuneMaskRenderer implements ICurioRenderer {
    private static final ResourceLocation KITSUNE_MASK_LOCATION = new ResourceLocation("epicsamurai:textures/armor/kitsune_mask.png");
    private final KitsuneMaskModel kitsuneMaskModel;

    public KitsuneMaskRenderer() {
        this.kitsuneMaskModel = new KitsuneMaskModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(KitsuneMaskModel.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing,
                                                                          float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStack.translate(0,0.02,0);
        LivingEntity entity = slotContext.entity();
        ICurioRenderer.followHeadRotations(entity, this.kitsuneMaskModel.bipedHead);
        //ICurioRenderer.rotateIfSneaking(matrixStack, entity);
        this.kitsuneMaskModel.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
        this.kitsuneMaskModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(KITSUNE_MASK_LOCATION), false, stack.hasFoil());
        this.kitsuneMaskModel.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}