package io.github.championash5357.tutorial.tags;

import io.github.championash5357.tutorial.Tutorial;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TutorialTags {

	public static class Blocks {
		
		public static final ITag.INamedTag<Block> ORES_RUBY = tag("ores/ruby");
		
		private static ITag.INamedTag<Block> tag(String id) {
			return BlockTags.makeWrapperTag(Tutorial.ID + ":" + id);
		}
	}

	public static class Items {
		
		public static final ITag.INamedTag<Item> GEMS_RUBY = tag("gems/ruby");
		public static final ITag.INamedTag<Item> ORES_RUBY = tag("ores/ruby");
		
		private static ITag.INamedTag<Item> tag(String id) {
			return ItemTags.makeWrapperTag(Tutorial.ID + ":" + id);
		}
	}
}
