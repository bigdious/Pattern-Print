package com.bigdious.pp.client;

import com.bigdious.pp.PP;
import com.bigdious.pp.client.renderer.PatternPrintItemRenderer;
import com.bigdious.pp.init.PPDataComponents;
import com.bigdious.pp.init.PPItems;
import com.bigdious.pp.items.PatternPrintItem;
import com.bigdious.pp.network.RotatePPPacket;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

public class PPClientEvents {
	public static final ModelResourceLocation PRINT_MODEL_1 =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_1_base"));
	public static final ModelResourceLocation PRINT_MODEL_2 =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_2_base"));
	public static final ModelResourceLocation PRINT_MODEL_3 =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_3_base"));
	public static final ModelResourceLocation PRINT_MODEL_4 =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_4_base"));
	public static final ModelResourceLocation PRINT_MODEL_5 =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_5_base"));
	public static final ModelResourceLocation PRINT_MODEL_1_EMPTY =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_1_empty"));
	public static final ModelResourceLocation PRINT_MODEL_2_EMPTY =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_2_empty"));
	public static final ModelResourceLocation PRINT_MODEL_3_EMPTY =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_3_empty"));
	public static final ModelResourceLocation PRINT_MODEL_4_EMPTY =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_4_empty"));
	public static final ModelResourceLocation PRINT_MODEL_5_EMPTY =  ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(PP.MODID, "item/pattern_print_5_empty"));
	private static final KeyMapping ROTATE_PP_KEY = new KeyMapping(
		"keybind.rotate_pattern_print",
		KeyConflictContext.IN_GAME,
		InputConstants.Type.KEYSYM,
		GLFW.GLFW_KEY_R,
		"key.categories.misc");

	public static void initEvents(IEventBus bus) {
		bus.addListener(RegisterKeyMappingsEvent.class, event -> {
			event.register(ROTATE_PP_KEY);
		});
		NeoForge.EVENT_BUS.addListener(PPClientEvents::renderPatternPrintOutlines);
		bus.addListener(RegisterClientExtensionsEvent.class, event -> event.registerItem(new IClientItemExtensions() {@Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new PatternPrintItemRenderer(1, PRINT_MODEL_1, PRINT_MODEL_1_EMPTY);}}, PPItems.PATTERN_PRINT_1.get()));
		bus.addListener(RegisterClientExtensionsEvent.class, event -> event.registerItem(new IClientItemExtensions() {@Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new PatternPrintItemRenderer(2, PRINT_MODEL_2, PRINT_MODEL_2_EMPTY);}}, PPItems.PATTERN_PRINT_2.get()));
		bus.addListener(RegisterClientExtensionsEvent.class, event -> event.registerItem(new IClientItemExtensions() {@Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new PatternPrintItemRenderer(3, PRINT_MODEL_3, PRINT_MODEL_3_EMPTY);}}, PPItems.PATTERN_PRINT_3.get()));
		bus.addListener(RegisterClientExtensionsEvent.class, event -> event.registerItem(new IClientItemExtensions() {@Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new PatternPrintItemRenderer(4, PRINT_MODEL_4, PRINT_MODEL_4_EMPTY);}}, PPItems.PATTERN_PRINT_4.get()));
		bus.addListener(RegisterClientExtensionsEvent.class, event -> event.registerItem(new IClientItemExtensions() {@Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new PatternPrintItemRenderer(5, PRINT_MODEL_5, PRINT_MODEL_5_EMPTY);}}, PPItems.PATTERN_PRINT_5.get()));
		bus.addListener(PPClientEvents::registerModels);
		NeoForge.EVENT_BUS.addListener(PPClientEvents::rotatePP);
	}

	public static void registerModels(ModelEvent.RegisterAdditional event) {
		event.register(PRINT_MODEL_1);
		event.register(PRINT_MODEL_2);
		event.register(PRINT_MODEL_3);
		event.register(PRINT_MODEL_4);
		event.register(PRINT_MODEL_5);
		event.register(PRINT_MODEL_1_EMPTY);
		event.register(PRINT_MODEL_2_EMPTY);
		event.register(PRINT_MODEL_3_EMPTY);
		event.register(PRINT_MODEL_4_EMPTY);
		event.register(PRINT_MODEL_5_EMPTY);
	}

	private static void rotatePP(InputEvent.Key event) {
		if (event.getAction() == GLFW.GLFW_PRESS && Minecraft.getInstance().player != null) {
			if (event.getKey() == ROTATE_PP_KEY.getKey().getValue() && ROTATE_PP_KEY.consumeClick()) {
				PacketDistributor.sendToServer(RotatePPPacket.INSTANCE);
			}
		}
	}


	private static void renderPatternPrintOutlines(RenderHighlightEvent.Block event) {
		//inspired from Twilight Forest's ClientGameEvents#renderGiantBlockOutlines
		BlockPos pos = event.getTarget().getBlockPos();
		BlockState state = event.getCamera().getEntity().level().getBlockState(pos);

		LocalPlayer player = Minecraft.getInstance().player;
		if (player != null && player.getMainHandItem().getItem() instanceof PatternPrintItem && player.getMainHandItem().has(PPDataComponents.PRINT_RANGE)) {
			event.setCanceled(true);
			if (!state.isAir() && player.level().getWorldBorder().isWithinBounds(pos)) {
				VertexConsumer consumer = event.getMultiBufferSource().getBuffer(RenderType.lines());
				//split mode based on if pattern is saved (has blockstate=is saved)
				if (player.getMainHandItem().has(PPDataComponents.BLOCK_STATE)) {
					for (BlockPos position : player.getMainHandItem().get(PPDataComponents.PATTERN_PRINT_COMPONENT).positions()) {
						Direction offset = event.getTarget().getDirection();
						Vec3 xyz = Vec3.atLowerCornerWithOffset(pos,
							position.getX()+ (offset.getAxis() == Direction.Axis.X ? offset == Direction.WEST ? -1 : 1 : 0),
							position.getY()+ (offset.getAxis() == Direction.Axis.Y ? offset == Direction.DOWN ? -1 : 1 : 0),
							position.getZ()+ (offset.getAxis() == Direction.Axis.Z ? offset == Direction.NORTH ? -1 : 1 : 0)
						).subtract(event.getCamera().getPosition());
						//we are double dipping to get a clearer outline
						LevelRenderer.renderShape(event.getPoseStack(), consumer, Shapes.block(), xyz.x(), xyz.y(), xyz.z(), 1.0F, 1.0F, 1.0F, 0.6F);
						LevelRenderer.renderShape(event.getPoseStack(), consumer, Shapes.box(0, 0, 0, 0.95, 0.95, 0.95), xyz.x()+0.025, xyz.y()+0.025, xyz.z()+0.025, 0.0F, 0.0F, 0.0F, 0.6F);
					}

				} else {
					//range is the size for the outline
					int range = player.getMainHandItem().getOrDefault(PPDataComponents.PRINT_RANGE, 0);
					Direction dir = PatternPrintItem.facingDirection(Mth.wrapDegrees(player.getViewYRot(1F)));

					Vec3 xyz = Vec3.atLowerCornerWithOffset(pos, dir == Direction.WEST ? -(range*2) : dir == Direction.EAST ? 0 : -range, 0, dir == Direction.NORTH ? -(range*2) : dir == Direction.SOUTH ? 0 : -range).subtract(event.getCamera().getPosition());
					VoxelShape shape = Shapes.box(0, 0, 0, 1 + 2 * range, 1 + 2 * range, 1 + 2 * range);
					VoxelShape shapeInner = Shapes.box(0, 0, 0, 0.95 + 2 * range, 0.95 + 2 * range, 0.95 + 2 * range);
					LevelRenderer.renderShape(event.getPoseStack(), consumer, shape, xyz.x(), xyz.y(), xyz.z(), 1.0F, 1.0F, 1.0F, 0.6F);
					LevelRenderer.renderShape(event.getPoseStack(), consumer, shapeInner, xyz.x()+0.025, xyz.y()+0.025, xyz.z()+0.025, 0.0F, 0.0F, 0.0F, 0.6F);

				}
			}
		}
	}

}
