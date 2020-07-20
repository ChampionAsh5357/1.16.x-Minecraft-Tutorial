package io.github.championash5357.tutorial;

import io.github.championash5357.tutorial.client.proxy.ClientProxy;
import io.github.championash5357.tutorial.data.TutorialAdvancementsProvider;
import io.github.championash5357.tutorial.data.TutorialBlockStateProvider;
import io.github.championash5357.tutorial.data.TutorialBlockTagsProvider;
import io.github.championash5357.tutorial.data.TutorialItemModelProvider;
import io.github.championash5357.tutorial.data.TutorialItemTagsProvider;
import io.github.championash5357.tutorial.data.TutorialLanguageProvider;
import io.github.championash5357.tutorial.data.TutorialLootTableProvider;
import io.github.championash5357.tutorial.data.TutorialRecipeProvider;
import io.github.championash5357.tutorial.init.TutorialBlocks;
import io.github.championash5357.tutorial.init.TutorialItems;
import io.github.championash5357.tutorial.proxy.IProxy;
import io.github.championash5357.tutorial.server.proxy.ServerProxy;
import io.github.championash5357.tutorial.world.biome.TutorialBiomeFeatures;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("deprecation")
@Mod(Tutorial.ID)
public class Tutorial {

	public static final String ID = "tutorial";
	
	public static final IProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	
	private static final String[] LOCALE_CODES = new String[] {
			"en_us",
			"es_es",
			"fr_fr"
	};
	
	public Tutorial() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(),
				forgeEventBus = MinecraftForge.EVENT_BUS;
		
		//Basic Setup
		PROXY.setup(modEventBus, forgeEventBus);
		addRegistries(modEventBus);
		
		//Mod Event Bus Listeners
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::gatherData);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			TutorialBiomeFeatures.applyBiomeFeatures();
		});
	}
	
	private void addRegistries(final IEventBus modEventBus) {
		TutorialBlocks.BLOCKS.register(modEventBus);
		TutorialItems.ITEMS.register(modEventBus);
	}
	
	private void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		
		if(event.includeClient()) {
			ExistingFileHelper helper = event.getExistingFileHelper();
			
			addLanguageProviders(gen);
			gen.addProvider(new TutorialItemModelProvider(gen, helper));
			gen.addProvider(new TutorialBlockStateProvider(gen, helper));
		}
		if(event.includeServer()) {
			TutorialBlockTagsProvider block_tags = new TutorialBlockTagsProvider(gen);
			
			gen.addProvider(block_tags);
			gen.addProvider(new TutorialItemTagsProvider(gen, block_tags));
			gen.addProvider(new TutorialRecipeProvider(gen));
			gen.addProvider(new TutorialLootTableProvider(gen));
			gen.addProvider(new TutorialAdvancementsProvider(gen));
		}
	}
	
	private void addLanguageProviders(DataGenerator gen) {
		for(String locale : LOCALE_CODES) {
			gen.addProvider(new TutorialLanguageProvider(gen, locale));
		}
	}
}
