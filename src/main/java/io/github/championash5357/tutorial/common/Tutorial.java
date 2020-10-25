package io.github.championash5357.tutorial.common;

import java.util.stream.Stream;

import io.github.championash5357.tutorial.client.ClientReference;
import io.github.championash5357.tutorial.data.client.*;
import io.github.championash5357.tutorial.data.server.Recipes;
import io.github.championash5357.tutorial.server.dedicated.DedicatedServerReference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Tutorial.ID)
public class Tutorial {

	public static final String ID = "tutorial116x";
	public static final ISidedReference SIDED_SYSTEM = DistExecutor.safeRunForDist(() -> ClientReference::new, () -> DedicatedServerReference::new);
	
	public Tutorial() {
		final IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus(),
				forge = MinecraftForge.EVENT_BUS;
		
		addRegistries(mod);
		mod.addListener(this::setup);
		mod.addListener(this::data);
		SIDED_SYSTEM.setup(mod, forge);
	}
	
	private void setup(final FMLCommonSetupEvent event) {}
	
	private void addRegistries(final IEventBus mod) {}
	
	private void data(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		if(event.includeClient()) {
			Stream.of("en_us", "es_es", "fr_fr").forEach(locale -> gen.addProvider(new Localization(gen, locale)));
			gen.addProvider(new ItemModels(gen, helper));
			gen.addProvider(new BlockStates(gen, helper));
		}
		if(event.includeServer()) {
			gen.addProvider(new Recipes(gen));
		}
	}
}
