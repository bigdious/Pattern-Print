package com.bigdious.pp.init;

import com.bigdious.pp.PP;
import com.bigdious.pp.items.PatternPrintComponent;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PPDataComponents {

	public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, PP.MODID);

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockState>> BLOCK_STATE = COMPONENTS.register("block_state", () -> DataComponentType.<BlockState>builder().persistent(BlockState.CODEC).networkSynchronized(ByteBufCodecs.fromCodec(BlockState.CODEC)).build());
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<PatternPrintComponent>> PATTERN_PRINT_COMPONENT = COMPONENTS.register("pattern_print_component", () -> DataComponentType.<PatternPrintComponent>builder().persistent(PatternPrintComponent.CODEC).networkSynchronized(PatternPrintComponent.STREAM_CODEC).build());
	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> PRINT_RANGE = COMPONENTS.register("print_range", () -> DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

}
