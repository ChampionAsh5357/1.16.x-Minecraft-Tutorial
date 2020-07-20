package io.github.championash5357.tutorial.data;

import java.util.function.Consumer;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.init.TutorialSounds;
import io.github.championash5357.tutorial.data.sound.SoundBuilder;
import net.minecraft.data.DataGenerator;

public class TutorialSoundsProvider extends SoundsProvider {

	public TutorialSoundsProvider(DataGenerator gen) {
		super(gen, Tutorial.ID);
	}

	@Override
	protected void addSounds(Consumer<SoundBuilder> consumer) {
		SoundBuilder.builder(TutorialSounds.BLOCK_WASHER_RUNNING).subtitle().build(consumer);
	}
}
