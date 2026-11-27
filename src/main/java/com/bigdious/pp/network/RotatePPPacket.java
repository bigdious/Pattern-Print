package com.bigdious.pp.network;

import com.bigdious.pp.PP;
import com.bigdious.pp.init.PPDataComponents;
import com.bigdious.pp.init.PPItems;
import com.bigdious.pp.items.PatternPrintItem;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class RotatePPPacket implements CustomPacketPayload {
	public static final Type<RotatePPPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PP.MODID, "rotate_pattern_print"));
	public static final RotatePPPacket INSTANCE = new RotatePPPacket();
	public static final StreamCodec<ByteBuf, RotatePPPacket> STREAM_CODEC = StreamCodec.unit(INSTANCE);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(IPayloadContext ctx) {
		if (ctx.flow().isServerbound()) {
			ctx.enqueueWork(() -> {
				Player player = ctx.player();
				ItemStack stack = player.getMainHandItem();
				if (stack.has(PPDataComponents.BLOCK_STATE) && stack.has(PPDataComponents.PATTERN_PRINT_COMPONENT) && player instanceof ServerPlayer sp) {
					PatternPrintItem.rotationLogic(stack, player, ctx.player().level());
					PacketDistributor.sendToPlayer(sp, new RotatePPPacketClient(true));
				}
			});
		}
	}
}
