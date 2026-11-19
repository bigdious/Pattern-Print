package com.bigdious.pp.config;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigSetup {
	private static final ModConfigSpec COMMON_SPEC;
	private static final PPCommonConfig COMMON_CONFIG;

	static {
		{
			final Pair<PPCommonConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(PPCommonConfig::new);
			ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, COMMON_SPEC = specPair.getRight());
			COMMON_CONFIG = specPair.getLeft();
		}

	}

	public static void loadConfigs(ModConfigEvent.Loading event) {
		if (event.getConfig().getSpec() == COMMON_SPEC) {
			PPConfig.rebakeCommonOptions(COMMON_CONFIG);
		}
	}

	public static void reloadConfigs(ModConfigEvent.Reloading event) {
		 if (event.getConfig().getSpec() == ConfigSetup.COMMON_SPEC) {
			PPConfig.rebakeCommonOptions(COMMON_CONFIG);
		}
	}
}
