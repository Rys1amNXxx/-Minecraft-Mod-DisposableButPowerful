package com.rysiamn.disposablebutpowerful;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.rysiamn.disposablebutpowerful.Entity.ThunderArrowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class ThunderArrowRenderer extends EntityRenderer<ThunderArrowEntity> {
    private final ItemRenderer itemRenderer;

    public ThunderArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ThunderArrowEntity entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

        this.itemRenderer.renderStatic(
                new ItemStack(Items.ARROW), // 使用你的自定义箭矢物品
                ItemDisplayContext.GROUND,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                poseStack,
                buffer,
                entity.level(),
                entity.getId()
        );

        poseStack.popPose();
        super.render(entity, yaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThunderArrowEntity entity) {
        return new ResourceLocation("minecraft:textures/item/arrow.png"); // 你的纹理路径
    }
}

