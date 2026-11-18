package com.bigdious.pp;

import com.bigdious.pp.client.PPClientEvents;
import com.bigdious.pp.config.ConfigSetup;
import com.bigdious.pp.data.*;
import com.bigdious.pp.init.*;
import com.bigdious.pp.network.SyncCommonConfigPacket;
import com.google.common.reflect.Reflection;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

@Mod(PP.MODID)
public class PP {
	public static final String MODID = "pp";

	public static final Logger LOGGER = LogManager.getLogger();

	public PP(IEventBus bus, Dist dist) {
		Reflection.initialize(ConfigSetup.class);
		ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> ConfigurationScreen::new);
		bus.addListener(ConfigSetup::loadConfigs);
		bus.addListener(ConfigSetup::reloadConfigs);
		NeoForge.EVENT_BUS.addListener(ConfigSetup::syncConfigOnLogin);
		bus.addListener(this::registerPacket);
		bus.addListener(PPTab::addToTabs);
		PPSoundEvents.SOUNDS.register(bus);
		PPDataComponents.COMPONENTS.register(bus);
		PPMobEffects.MOB_EFFECTS.register(bus);



		PPItems.ITEMS.register(bus);

		if (dist.isClient()) {
			PPClientEvents.initEvents(bus);
		}

		bus.addListener(this::gatherData);
	}

	private void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		DatapackBuiltinEntriesProvider datapackProvider = new PPRegistryDataGenerator(packOutput, event.getLookupProvider());

		boolean isClient = event.includeClient();
		generator.addProvider(isClient, new PPLangGenerator(packOutput));

		boolean isServer = event.includeServer();

		PPRegistryDataGenerator registryDataGenerator = new PPRegistryDataGenerator(packOutput, datapackProvider.getRegistryProvider());
		var lookupProvider = registryDataGenerator.getRegistryProvider();
		generator.addProvider(isServer, new PPCraftingGenerator(packOutput, lookupProvider));
	}

	public void registerPacket(RegisterPayloadHandlersEvent event) {
//		PayloadRegistrar registrar = event.registrar(MODID).versioned("1.0.0");
//		registrar.playToClient(SyncCommonConfigPacket.TYPE, SyncCommonConfigPacket.STREAM_CODEC, SyncCommonConfigPacket::handle);
	}
	public static ResourceLocation prefix(String name) {
		return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
	}

}
