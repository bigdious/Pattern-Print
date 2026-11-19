package com.bigdious.pp.config;

public class PPConfig {
	// -- COMMON CONFIG --
	public static boolean combatNerf = false;

	static void rebakeCommonOptions(PPCommonConfig config) {
		combatNerf = config.combatNerf.get();
	}
}
