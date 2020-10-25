package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTags extends BlockTagsProvider {

	public BlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		
	}
}
