package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.*;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTags extends ItemTagsProvider {

	public ItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		
	}
}
