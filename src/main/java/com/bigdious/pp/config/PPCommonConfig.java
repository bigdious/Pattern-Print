package com.bigdious.pp.config;

import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class PPCommonConfig {
	final ModConfigSpec.BooleanValue combatNerf;

	public PPCommonConfig(ModConfigSpec.Builder builder) {
		this.combatNerf = builder
			.translation("config.pp.combat_nerf")
			.comment(ConfigComments.COMBAT_NERF)
			.define("combatNerf", ModList.get().isLoaded("risus"));

	}
}
