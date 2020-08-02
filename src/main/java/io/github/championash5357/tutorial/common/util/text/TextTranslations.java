package io.github.championash5357.tutorial.common.util.text;

import net.minecraft.util.text.TranslationTextComponent;

public class TextTranslations {

	public static final TranslationTextComponent ADVANCEMENT_MINE_RUBY_TITLE = new TranslationTextComponent("advancements.tutorial.story.mine_ruby.title");
	public static final TranslationTextComponent ADVANCEMENT_MINE_RUBY_DESCRIPTION = new TranslationTextComponent("advancements.tutorial.story.mine_ruby.description");
	
	public static final TranslationTextComponent CONTAINER_WASHER = new TranslationTextComponent("container.tutorial.washer");
	public static TranslationTextComponent containerWasherTime(int time) {
		return new TranslationTextComponent("container.tutorial.washer.time", time);
	}
}
