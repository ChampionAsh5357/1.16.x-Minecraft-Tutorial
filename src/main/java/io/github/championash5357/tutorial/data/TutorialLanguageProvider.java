package io.github.championash5357.tutorial.data;

import java.util.function.Supplier;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.init.TutorialBlocks;
import io.github.championash5357.tutorial.common.init.TutorialItems;
import io.github.championash5357.tutorial.common.init.TutorialSounds;
import io.github.championash5357.tutorial.common.util.text.TextTranslations;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.data.LanguageProvider;

public class TutorialLanguageProvider extends LanguageProvider {

	public TutorialLanguageProvider(DataGenerator gen, String locale) {
		super(gen, Tutorial.ID, locale);
	}

	@Override
	protected void addTranslations() {
		String locale = this.getName().replace("Languages: ", "");
		switch(locale) {
		case "en_us":
			addBlock(TutorialBlocks.RUBY_ORE, "Ruby Ore");
			addBlock(TutorialBlocks.WASHER, "Washer");
			
			addItem(TutorialItems.RUBY, "Ruby");
			addItem(TutorialItems.RUBY_HELMET, "Ruby Helmet");
			addItem(TutorialItems.RUBY_CHESTPLATE, "Ruby Chestplate");
			addItem(TutorialItems.RUBY_LEGGINGS, "Ruby Leggings");
			addItem(TutorialItems.RUBY_BOOTS, "Ruby Boots");
			
			addSubtitle(TutorialSounds.BLOCK_WASHER_RUNNING, "Washer Running");
			
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE.getKey(), "Red Emeralds");
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION.getKey(), "Acquire rubies");
			add(TextTranslations.CONTAINER_WASHER.getKey(), "Washer");
			add(TextTranslations.containerWasherTime(0).getKey(), "Wash Time: %s");
			break;
		case "es_es":
			addBlock(TutorialBlocks.RUBY_ORE, "Mena de rubí");
			addBlock(TutorialBlocks.WASHER, "Lavadora");
			
			addItem(TutorialItems.RUBY, "Rubí");
			addItem(TutorialItems.RUBY_HELMET, "Casco de rubí");
			addItem(TutorialItems.RUBY_CHESTPLATE, "Peto de rubí");
			addItem(TutorialItems.RUBY_LEGGINGS, "Grebas de rubí");
			addItem(TutorialItems.RUBY_BOOTS, "Botas de rubí");
			
			addSubtitle(TutorialSounds.BLOCK_WASHER_RUNNING, "Lavadora en funcionamiento");
			
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE.getKey(), "Esmeraldas rojas");
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION.getKey(), "Consigue rubíes.");
			add(TextTranslations.CONTAINER_WASHER.getKey(), "Lavadora");
			add(TextTranslations.containerWasherTime(0).getKey(), "Tiempo de lavado: %s");
			break;
		case "fr_fr":
			addBlock(TutorialBlocks.RUBY_ORE, "Minerai de rubis");
			addBlock(TutorialBlocks.WASHER, "Machine à laver");
			
			addItem(TutorialItems.RUBY, "Rubis");
			addItem(TutorialItems.RUBY_HELMET, "Casque de rubis");
			addItem(TutorialItems.RUBY_CHESTPLATE, "Plastron de rubis");
			addItem(TutorialItems.RUBY_LEGGINGS, "Jambières de rubis");
			addItem(TutorialItems.RUBY_BOOTS, "Bottes de rubis");
			
			addSubtitle(TutorialSounds.BLOCK_WASHER_RUNNING, "Course à pied de machine à laver");
			
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE.getKey(), "Émeraudes rouges");
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION.getKey(), "Obtenez des rubis.");
			add(TextTranslations.CONTAINER_WASHER.getKey(), "Machine à laver");
			add(TextTranslations.containerWasherTime(0).getKey(), "Temps de lavage: %s");
			break;
		default:
			break;
		}
	}
	
	public void addSubtitle(Supplier<? extends SoundEvent> key, String name) {
		add(key.get(), name);
	}
	
	public void add(SoundEvent key, String name) {
		ResourceLocation loc = key.getRegistryName();
		add("subtitle." + loc.getNamespace() + "." + loc.getPath(), name);
	}
}
