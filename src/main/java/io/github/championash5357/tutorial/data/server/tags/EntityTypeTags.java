package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EntityTypeTags extends EntityTypeTagsProvider {

	public EntityTypeTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		
	}
}
