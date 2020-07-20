package io.github.championash5357.tutorial.data;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.init.TutorialBlocks;
import io.github.championash5357.tutorial.common.init.TutorialItems;
import io.github.championash5357.tutorial.common.util.text.TextTranslations;
import net.minecraft.data.DataGenerator;
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
			
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE.getKey(), "Red Emeralds");
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION.getKey(), "Acquire rubies");
			break;
		case "es_es":
			addBlock(TutorialBlocks.RUBY_ORE, "Mena de rub�");
			addBlock(TutorialBlocks.WASHER, "Lavadora");
			
			addItem(TutorialItems.RUBY, "Rub�");
			addItem(TutorialItems.RUBY_HELMET, "Casco de rub�");
			addItem(TutorialItems.RUBY_CHESTPLATE, "Peto de rub�");
			addItem(TutorialItems.RUBY_LEGGINGS, "Grebas de rub�");
			addItem(TutorialItems.RUBY_BOOTS, "Botas de rub�");
			
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE.getKey(), "Esmeraldas rojas");
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION.getKey(), "Consigue rub�es.");
			break;
		case "fr_fr":
			addBlock(TutorialBlocks.RUBY_ORE, "Minerai de rubis");
			addBlock(TutorialBlocks.WASHER, "Machine � laver");
			
			addItem(TutorialItems.RUBY, "Rubis");
			addItem(TutorialItems.RUBY_HELMET, "Casque de rubis");
			addItem(TutorialItems.RUBY_CHESTPLATE, "Plastron de rubis");
			addItem(TutorialItems.RUBY_LEGGINGS, "Jambi�res de rubis");
			addItem(TutorialItems.RUBY_BOOTS, "Bottes de rubis");
			
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_TITLE.getKey(), "�meraudes rouges");
			add(TextTranslations.ADVANCEMENT_MINE_RUBY_DESCRIPTION.getKey(), "Obtenez des rubis.");
			break;
		default:
			break;
		}
	}
}
