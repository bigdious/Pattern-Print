package com.bigdious.pp.data;

import com.bigdious.pp.PP;
import com.bigdious.pp.init.PPSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

public class PPSoundDefinitions extends SoundDefinitionsProvider {
	public PPSoundDefinitions(PackOutput output, ExistingFileHelper helper) {
		super(output, PP.MODID, helper);
	}

	@Override
	public void registerSounds() {
		this.generateExistingSoundWithSubtitle(PPSoundEvents.PP_FAILED, SoundEvents.DISPENSER_FAIL, "Pattern Print has no blocks to use");
		this.generateExistingSoundWithSubtitle(PPSoundEvents.PP_DENIED, SoundEvents.DISPENSER_FAIL, "Block is copyrighted, cannot be printed");
		this.generateExistingSoundWithSubtitle(PPSoundEvents.PP_ROTATED, SoundEvents.BOOK_PAGE_TURN, "Pattern rotated");
	}

	public void generateExistingSoundWithSubtitle(DeferredHolder<SoundEvent, SoundEvent> event, SoundEvent referencedSound, String subtitle) {
		this.generateExistingSoundWithSubtitle(event, referencedSound, subtitle, 1.0F, 1.0F);
	}
	public void generateExistingSoundWithSubtitle(DeferredHolder<SoundEvent, SoundEvent> event, SoundEvent referencedSound, String subtitle, float volume, float pitch) {
		this.generateExistingSound(event, referencedSound, subtitle, volume, pitch);
	}
	public void generateExistingSound(DeferredHolder<SoundEvent, SoundEvent> event, SoundEvent referencedSound, @Nullable String subtitle, float volume, float pitch) {
		SoundDefinition definition = SoundDefinition.definition();
		if (subtitle != null) {
			this.createSubtitleAndLangEntry(event, definition, subtitle);
		}
		this.add(event, definition
			.with(SoundDefinition.Sound.sound(referencedSound.getLocation(), SoundDefinition.SoundType.EVENT).volume(volume).pitch(pitch)));
	}
	private void createSubtitleAndLangEntry(DeferredHolder<SoundEvent, SoundEvent> event, SoundDefinition definition, String subtitle) {
		String subtitleKey = "subtitles.risus." + event.getId().getPath();
		definition.subtitle(subtitleKey);
		PPLangGenerator.SUBTITLE_GENERATOR.put(subtitleKey, subtitle);
	}
}
