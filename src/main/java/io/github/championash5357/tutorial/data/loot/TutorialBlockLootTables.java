package io.github.championash5357.tutorial.data.loot;

import io.github.championash5357.tutorial.init.TutorialBlocks;
import io.github.championash5357.tutorial.init.TutorialItems;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class TutorialBlockLootTables extends BlockLootTables {
	
	@Override
	protected void addTables() {
		this.registerLootTable(TutorialBlocks.RUBY_ORE.get(), (block) -> {
			return droppingItemWithFortune(block, TutorialItems.RUBY.get());
		});
		this.registerDropSelfLootTable(TutorialBlocks.WASHER.get());
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return TutorialBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
