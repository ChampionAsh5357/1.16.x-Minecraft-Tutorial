package io.github.championash5357.tutorial;

import io.github.championash5357.tutorial.client.proxy.ClientProxy;
import io.github.championash5357.tutorial.init.TutorialBlocks;
import io.github.championash5357.tutorial.init.TutorialItems;
import io.github.championash5357.tutorial.proxy.IProxy;
import io.github.championash5357.tutorial.server.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Tutorial.ID)
public class Tutorial {

	public static final String ID = "tutorial";
	
	public static final IProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	
	public Tutorial() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(),
				forgeEventBus = MinecraftForge.EVENT_BUS;
		
		//Basic Setup
		PROXY.setup(modEventBus, forgeEventBus);
		addRegistries(modEventBus);
		
		//Mod Event Bus Listeners
		modEventBus.addListener(this::commonSetup);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {}
	
	private void addRegistries(final IEventBus modEventBus) {
		TutorialBlocks.BLOCKS.register(modEventBus);
		TutorialItems.ITEMS.register(modEventBus);
	}
}
