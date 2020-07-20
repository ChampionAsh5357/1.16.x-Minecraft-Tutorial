package io.github.championash5357.tutorial.data.advancements;

import java.util.function.Consumer;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.init.TutorialItems;
import io.github.championash5357.tutorial.common.util.text.TextTranslations;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.util.ResourceLocation;

public class TutorialStoryAdvancements implements Consumer<Consumer<FinishedAdvancement>> {

	@Override
	public void accept(Consumer<FinishedAdvancement> consumer) {
		FinishedAdvancement.Builder.builder().advancement(Advancement.Builder.builder().withParentId(new ResourceLocation("story/iron_tools")).withDisplay(TutorialItems.RUBY.get(), TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE, TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION, null, FrameType.TASK, true, true, false).withCriterion("ruby", InventoryChangeTrigger.Instance.forItems(TutorialItems.RUBY.get()))).build(consumer, new ResourceLocation(Tutorial.ID, "story/mine_ruby"));
	}
}
