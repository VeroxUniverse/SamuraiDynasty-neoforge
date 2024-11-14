package net.veroxuniverse.samurai_dynasty.curios.layers;

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
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.curios.model.OniMaskModel;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class OniMaskRenderer implements ICurioRenderer {
    private static final ResourceLocation ONI_MASK_LOCATION = ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID,"textures/models/armor/oni_mask.png");
    private final OniMaskModel oniMaskModel;

    public OniMaskRenderer() {
        this.oniMaskModel = new OniMaskModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(OniMaskModel.LAYER_LOCATION));
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing,
                                                                          float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStack.translate(0,0.05,0);
        LivingEntity entity = slotContext.entity();
        ICurioRenderer.followHeadRotations(entity, this.oniMaskModel.bipedArmorHead);
        //ICurioRenderer.rotateIfSneaking(matrixStack, entity);
        this.oniMaskModel.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
        this.oniMaskModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(ONI_MASK_LOCATION), false);
        this.oniMaskModel.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}