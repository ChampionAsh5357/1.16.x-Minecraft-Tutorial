package io.github.championash5357.tutorial.data;

import io.github.championash5357.tutorial.common.init.TutorialBlocks;
import io.github.championash5357.tutorial.common.tags.TutorialTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;

public class TutorialBlockTagsProvider extends BlockTagsProvider {

	public TutorialBlockTagsProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerTags() {
		func_240522_a_(Tags.Blocks.ORES).func_240531_a_(TutorialTags.Blocks.ORES_RUBY);
		
		func_240522_a_(TutorialTags.Blocks.ORES_RUBY).func_240534_a_(TutorialBlocks.RUBY_ORE.get());
	}
}
