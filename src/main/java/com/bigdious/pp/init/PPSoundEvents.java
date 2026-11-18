package com.bigdious.pp.init;

import com.bigdious.pp.PP;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PPSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, PP.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> PP_FAILED = register("item.pattern_print.fail");
	public static final DeferredHolder<SoundEvent, SoundEvent> PP_DENIED = register("item.pattern_print.denied");
	public static final DeferredHolder<SoundEvent, SoundEvent> PP_ROTATED = register("item.pattern_print.rotated");

	private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(PP.prefix(name)));
	}

}
