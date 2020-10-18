package io.github.championash5357.tutorial.data.client;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {}
}
