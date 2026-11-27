package com.bigdious.pp.network;

import com.bigdious.pp.PP;
import com.bigdious.pp.items.PatternPrintItem;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record RotatePPPacketClient (boolean ignoreThis) implements CustomPacketPayload {
	public static final Type<RotatePPPacketClient> TYPE = new Type<>(PP.prefix("rotate_pattern_print_client"));
	public static final StreamCodec<RegistryFriendlyByteBuf, RotatePPPacketClient> STREAM_CODEC = CustomPacketPayload.codec(RotatePPPacketClient::write, RotatePPPacketClient::new);

	public RotatePPPacketClient(RegistryFriendlyByteBuf buf) {
		this(buf.readBoolean());
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public void write(RegistryFriendlyByteBuf buf) {
		buf.writeBoolean(this.ignoreThis());
	}

	public void handle(IPayloadContext ctx) {
		if (ctx.flow().isClientbound()) {
			ctx.enqueueWork(() -> {
				Player player = ctx.player();
				ItemStack stack = player.getMainHandItem();
				PatternPrintItem.rotationLogic(stack, player, ctx.player().level());
			});
		}
	}
}
