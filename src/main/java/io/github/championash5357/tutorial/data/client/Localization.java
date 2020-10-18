package io.github.championash5357.tutorial.data.client;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Localization extends LanguageProvider {

	public Localization(DataGenerator gen, String locale) {
		super(gen, Tutorial.ID, locale);
	}

	@Override
	protected void addTranslations() {
		String locale = this.getName().replace("Languages: ", "");
		switch(locale) {
		case "en_us":
			break;
		case "es_es":
			break;
		case "fr_fr":
			break;
		default:
			break;
		}
	}
}
