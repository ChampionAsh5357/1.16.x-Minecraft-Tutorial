package io.github.championash5357.tutorial.client.proxy;

import io.github.championash5357.tutorial.proxy.IProxy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy implements IProxy {

	@Override
	public void setup(IEventBus modEventBus, IEventBus forgeEventBus) {
		
		//Mod Event Bus Listeners
		modEventBus.addListener(this::clientSetup);
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {}
}
