package io.github.championash5357.tutorial.init;

import java.util.function.Function;

import javax.annotation.Nullable;

import io.github.championash5357.tutorial.Tutorial;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Tutorial.ID);

	public static final RegistryObject<Block> RUBY_ORE = register("ruby_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).func_235861_h_().hardnessAndResistance(3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2)), block -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	private static <V extends Block> RegistryObject<V> register(String id, V block, @Nullable Function<V, BlockItem> item) {
		if(item != null) TutorialItems.ITEMS.register(id, () -> item.apply(block));
		return BLOCKS.register(id, () -> block);
	}
}
