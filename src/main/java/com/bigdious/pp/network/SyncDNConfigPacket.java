//package com.bigdious.pp.network;
//
//import com.bigdious.pp.PP;
//import com.bigdious.pp.blocks.DisplayNotchBlock;
//import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
//import net.minecraft.resources.ResourceLocation;
//
//import java.util.Map;
//
//public record SyncDNConfigPacket(Map<ResourceLocation, DisplayNotchBlock> notches) implements CustomPacketPayload {
//	public static final Type<SyncDNConfigPacket> TYPE = new Type<>(PP.prefix("sync_dn_configs"));
//
//	@Override
//	public Type<? extends CustomPacketPayload> type() {
//		return TYPE;
//	}
//
//}
