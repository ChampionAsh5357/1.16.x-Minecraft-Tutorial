package io.github.championash5357.tutorial.client;

import io.github.championash5357.tutorial.common.ISidedReference;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientReference implements ISidedReference {

	@Override
	public void setup(final IEventBus mod, final IEventBus forge) {
		mod.addListener(this::clientSetup);
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {}
}
