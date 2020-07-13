package io.github.championash5357.tutorial.data;

import java.util.function.Supplier;

import io.github.championash5357.tutorial.Tutorial;
import io.github.championash5357.tutorial.init.TutorialBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;

public class TutorialBlockStateProvider extends BlockStateProvider {

	public TutorialBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Tutorial.ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(TutorialBlocks.RUBY_ORE);
	}
	
	public void simpleBlock(Supplier<? extends Block> blockSupplier) {
		simpleBlock(blockSupplier.get());
	}
	
	@Override
	public void simpleBlock(Block block, ModelFile model) {
		super.simpleBlock(block, model);
		this.simpleBlockItem(block, model);
	}
}