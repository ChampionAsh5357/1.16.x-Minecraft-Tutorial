package io.github.championash5357.tutorial.data;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableList;

import io.github.championash5357.tutorial.data.advancements.FinishedAdvancement;
import io.github.championash5357.tutorial.data.advancements.TutorialStoryAdvancements;
import net.minecraft.data.DataGenerator;

public class TutorialAdvancementsProvider extends AdvancementsProvider {
	private final List<Consumer<Consumer<FinishedAdvancement>>> advancements = ImmutableList.of(new TutorialStoryAdvancements());

	public TutorialAdvancementsProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	public List<Consumer<Consumer<FinishedAdvancement>>> getAdvancements() {
		return this.advancements;
	}
}