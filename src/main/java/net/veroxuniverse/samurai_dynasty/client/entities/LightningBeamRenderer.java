package net.veroxuniverse.samurai_dynasty.client.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.samurai_dynasty.entity.custom.LightningBeamEntity;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LightningBeamRenderer extends EntityRenderer<LightningBeamEntity> {

    private static final float BEAM_WIDTH = 0.12F;
    private static final int SEGMENTS = 20;
    private static final float JITTER_STRENGTH = 0.35F;
    private static final int FULL_LIGHT = 0x00F000F0;

    private final Map<Integer, float[]> jitterCache = new HashMap<>();

    public LightningBeamRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(@NotNull LightningBeamEntity entity, float yaw, float partialTicks,
                       @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {

        float age = entity.tickCount + partialTicks;
        float lifetime = entity.getLifetime();
        float fade = 1.0F - Mth.clamp(age / lifetime, 0.0F, 1.0F);
        if (fade <= 0.0F) {
            return;
        }

        int alpha = (int) (255 * fade);
        int color = FastColor.ARGB32.color(alpha, 180, 220, 255);

        poseStack.pushPose();

        Vec3 direction = entity.getBeamDirection();
        Vector3f dirVec = new Vector3f((float) direction.x, (float) direction.y, (float) direction.z);
        Quaternionf rotation = new Quaternionf().rotationTo(new Vector3f(0f, 1f, 0f), dirVec);
        poseStack.mulPose(rotation);

        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.lightning());
        Matrix4f poseMatrix = poseStack.last().pose();

        float[] jitter = getJitter(entity);
        float beamHeight = entity.getBeamHeight();
        float segmentHeight = beamHeight / SEGMENTS;

        for (int s = 0; s < SEGMENTS; s++) {
            float yStart = s * segmentHeight;
            float yEnd = (s + 1) * segmentHeight;
            float xStart = jitter[s * 2];
            float zStart = jitter[s * 2 + 1];
            float xEnd = jitter[(s + 1) * 2];
            float zEnd = jitter[(s + 1) * 2 + 1];
            addBeamSegment(vertexConsumer, poseMatrix, xStart, yStart, zStart, xEnd, yEnd, zEnd, color);
        }

        poseStack.popPose();

        super.render(entity, yaw, partialTicks, poseStack, buffer, packedLight);
    }

    private float[] getJitter(LightningBeamEntity entity) {
        return jitterCache.computeIfAbsent(entity.getId(), id -> {
            Random rand = new Random(id);
            float[] jitter = new float[(SEGMENTS + 1) * 2];
            for (int i = 1; i < SEGMENTS; i++) {
                jitter[i * 2] = (rand.nextFloat() - 0.5F) * JITTER_STRENGTH;
                jitter[i * 2 + 1] = (rand.nextFloat() - 0.5F) * JITTER_STRENGTH;
            }
            return jitter;
        });
    }

    private void addBeamSegment(VertexConsumer vc, Matrix4f pose,
                                float xStart, float yStart, float zStart,
                                float xEnd, float yEnd, float zEnd, int color) {
        float w = BEAM_WIDTH;

        addPlane(vc, pose, xStart, yStart, zStart, xEnd, yEnd, zEnd, -w, -w, w, w, color);
        addPlane(vc, pose, xStart, yStart, zStart, xEnd, yEnd, zEnd, w, -w, -w, w, color);
        addPlane(vc, pose, xStart, yStart, zStart, xEnd, yEnd, zEnd, w, 0f, -w, 0f, color);
        addPlane(vc, pose, xStart, yStart, zStart, xEnd, yEnd, zEnd, 0f, w, 0f, -w, color);
    }

    private void addPlane(VertexConsumer vc, Matrix4f pose,
                          float xStart, float yStart, float zStart,
                          float xEnd, float yEnd, float zEnd,
                          float offAX, float offAZ, float offBX, float offBZ, int color) {
        Vector3f p1 = pose.transformPosition(xStart + offAX, yStart, zStart + offAZ, new Vector3f());
        Vector3f p2 = pose.transformPosition(xEnd + offAX, yEnd, zEnd + offAZ, new Vector3f());
        Vector3f p3 = pose.transformPosition(xEnd + offBX, yEnd, zEnd + offBZ, new Vector3f());
        Vector3f p4 = pose.transformPosition(xStart + offBX, yStart, zStart + offBZ, new Vector3f());

        vc.addVertex(p1.x(), p1.y(), p1.z(), color, 0f, 0f, 0, FULL_LIGHT, 0f, 1f, 0f);
        vc.addVertex(p2.x(), p2.y(), p2.z(), color, 1f, 0f, 0, FULL_LIGHT, 0f, 1f, 0f);
        vc.addVertex(p3.x(), p3.y(), p3.z(), color, 1f, 1f, 0, FULL_LIGHT, 0f, 1f, 0f);
        vc.addVertex(p4.x(), p4.y(), p4.z(), color, 0f, 1f, 0, FULL_LIGHT, 0f, 1f, 0f);

        vc.addVertex(p4.x(), p4.y(), p4.z(), color, 0f, 1f, 0, FULL_LIGHT, 0f, -1f, 0f);
        vc.addVertex(p3.x(), p3.y(), p3.z(), color, 1f, 1f, 0, FULL_LIGHT, 0f, -1f, 0f);
        vc.addVertex(p2.x(), p2.y(), p2.z(), color, 1f, 0f, 0, FULL_LIGHT, 0f, -1f, 0f);
        vc.addVertex(p1.x(), p1.y(), p1.z(), color, 0f, 0f, 0, FULL_LIGHT, 0f, -1f, 0f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LightningBeamEntity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}