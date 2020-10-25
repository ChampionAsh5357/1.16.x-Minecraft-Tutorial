package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FluidTags extends FluidTagsProvider {

	public FluidTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		
	}
}
