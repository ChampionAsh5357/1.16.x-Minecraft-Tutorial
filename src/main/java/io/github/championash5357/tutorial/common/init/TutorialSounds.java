package io.github.championash5357.tutorial.common.init;

import java.util.function.Function;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialSounds {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Tutorial.ID);
	
	public static final RegistryObject<SoundEvent> BLOCK_WASHER_RUNNING = register("block.washer.running", name -> new SoundEvent(name));
			
	private static <V extends SoundEvent> RegistryObject<V> register(String id, Function<ResourceLocation, V> function) {
		return SOUNDS.register(id, () -> function.apply(new ResourceLocation(Tutorial.ID, id)));
	}
}
