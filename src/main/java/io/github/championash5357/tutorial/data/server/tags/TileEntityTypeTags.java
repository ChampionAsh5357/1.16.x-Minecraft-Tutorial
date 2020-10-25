package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TileEntityTypeTags extends AbstractTagsProvider<TileEntityType<?>> {

	@SuppressWarnings("deprecation")
	public TileEntityTypeTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Registry.BLOCK_ENTITY_TYPE, "tile_entity_types", Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
	}
}
