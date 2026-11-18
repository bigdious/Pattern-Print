package com.bigdious.pp.client.renderer;

import com.bigdious.pp.init.PPDataComponents;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

public class PatternPrintItemRenderer extends BlockEntityWithoutLevelRenderer {
	//made based off Swedz's BlockOverlayingItemRenderer class
	//https://github.com/Swedz/MI-Tweaks/blob/1.21.1/src/main/java/net/swedz/mi_tweaks/item/renderer/BlockOverlayingItemRenderer.java
	private final int number;
	private final ModelResourceLocation itemModelLocation;
	private final ModelResourceLocation emptyItemModelLocation;

	public PatternPrintItemRenderer(int number, ModelResourceLocation itemModelLocation, ModelResourceLocation emptyItemModelLocation) {
		super(null, null);
		this.number = number;
		this.itemModelLocation = itemModelLocation;
		this.emptyItemModelLocation = emptyItemModelLocation;
	}
	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
		ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
		poseStack.pushPose();
		poseStack.translate(0.5, 0.5, 0.5);
		BakedModel model = renderer.getItemModelShaper().getModelManager().getModel(stack.has(PPDataComponents.BLOCK_STATE) ? emptyItemModelLocation : itemModelLocation);
		renderer.render(stack, displayContext, isLeftHand(displayContext), poseStack, buffer, packedLight, packedOverlay, model);

		Block block = stack.getOrDefault(PPDataComponents.BLOCK_STATE, Blocks.AIR.defaultBlockState()).getBlock();
		poseStack.pushPose();
		poseStack.popPose();

		if (displayContext == ItemDisplayContext.GUI) {
			poseStack.translate(-0.26, -0.23, 0);
			poseStack.scale(0.45f, 0.45f, 0.45f);
			poseStack.rotateAround(Axis.XP.rotationDegrees(30), 0.5f, 0.5f, 0.5f);
			poseStack.rotateAround(Axis.YP.rotationDegrees(45), 0.5f, 0.5f, 0.5f);
		} else if (displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND ){
			poseStack.translate(-0.14, 0.05, 0.05);
			poseStack.scale(0.25f, 0.25f, 0.25f);
		} else {
			poseStack.translate(-0.13, 0.10, -0.06);
			poseStack.scale(0.25f, 0.25f, 0.25f);
			poseStack.rotateAround(Axis.XP.rotationDegrees(-30), 0.5f, 0.5f, 0.5f);
			poseStack.rotateAround(Axis.YP.rotationDegrees(15), 0.5f, 0.5f, 0.5f);
		}

		BlockState blockState = block.defaultBlockState();
		BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
		blockRenderer.renderSingleBlock(blockState, poseStack, buffer, packedLight, packedOverlay, ModelData.EMPTY, null);

		poseStack.popPose();
	}

	private static boolean isLeftHand(ItemDisplayContext context)
	{
		return context == ItemDisplayContext.FIRST_PERSON_LEFT_HAND ||
			context == ItemDisplayContext.THIRD_PERSON_LEFT_HAND;
	}
}
