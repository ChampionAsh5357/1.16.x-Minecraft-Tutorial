package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PotionTags extends AbstractTagsProvider<Potion> {

	@SuppressWarnings("deprecation")
	public PotionTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Registry.POTION, "potions", Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
	}
}
