package io.github.championash5357.tutorial.proxy;

import net.minecraftforge.eventbus.api.IEventBus;

public interface IProxy {

	void setup(IEventBus modEventBus, IEventBus forgeEventBus);
}
