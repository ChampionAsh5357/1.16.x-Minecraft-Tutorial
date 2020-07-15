package io.github.championash5357.tutorial.data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import io.github.championash5357.tutorial.Tutorial;
import io.github.championash5357.tutorial.init.TutorialBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;

public class TutorialBlockStateProvider extends BlockStateProvider {

	public TutorialBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Tutorial.ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(TutorialBlocks.RUBY_ORE);
		templateExtenderHorizontalBlock(TutorialBlocks.WASHER, Util.make(new HashMap<>(), map -> {
			map.put("base", new ResourceLocation("block/quartz_block_bottom"));
			map.put("frame", blockTexture(Blocks.STONE));
			map.put("buttons", blockTexture(Blocks.POPPY));
			map.put("door", blockTexture(Blocks.LIGHT_BLUE_CONCRETE));
		}));
	}
	
	public void simpleBlock(Supplier<? extends Block> blockSupplier) {
		simpleBlock(blockSupplier.get());
	}
	
	public void templateExtenderHorizontalBlock(Supplier<? extends Block> blockSupplier, Map<String, ResourceLocation> textures) {
		Block block = blockSupplier.get();
		horizontalBlock(block, templateExtender(block, textures));
	}
	
	@Override
	public void simpleBlock(Block block, ModelFile model) {
		super.simpleBlock(block, model);
		this.simpleBlockItem(block, model);
	}
	
	@Override
	public void horizontalBlock(Block block, ModelFile model) {
		super.horizontalBlock(block, model);
		this.simpleBlockItem(block, model);
	}
	
	public BlockModelBuilder templateExtender(Block block, Map<String, ResourceLocation> textures) {
		ResourceLocation name = block.getRegistryName();
		BlockModelBuilder builder = this.models().withExistingParent(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/template_" + name.getPath()));
		textures.forEach((key, texture) -> builder.texture(key, texture));
		return builder;
	}
}