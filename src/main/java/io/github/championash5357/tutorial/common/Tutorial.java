package io.github.championash5357.tutorial.common;

import io.github.championash5357.tutorial.client.ClientReference;
import io.github.championash5357.tutorial.server.dedicated.DedicatedServerReference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Tutorial.ID)
public class Tutorial {

	public static final String ID = "tutorial116x";
	public static final ISidedReference SIDED_SYSTEM = DistExecutor.safeRunForDist(() -> ClientReference::new, () -> DedicatedServerReference::new);
	
	public Tutorial() {
		final IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus(),
				forge = MinecraftForge.EVENT_BUS;
		
		mod.addListener(this::setup);
		SIDED_SYSTEM.setup(mod, forge);
	}
	
	private void setup(final FMLCommonSetupEvent event) {}
}
