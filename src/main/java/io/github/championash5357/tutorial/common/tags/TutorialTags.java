package io.github.championash5357.tutorial.common.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.versions.forge.ForgeVersion;

public class TutorialTags {

	public static class Blocks {
		
		public static final ITag.INamedTag<Block> ORES_RUBY = forge("ores/ruby");
		
		@SuppressWarnings("unused")
		private static ITag.INamedTag<Block> tag(String id) {
			return BlockTags.makeWrapperTag(Tutorial.ID + ":" + id);
		}
		
		private static ITag.INamedTag<Block> forge(String id) {
			return BlockTags.makeWrapperTag(ForgeVersion.MOD_ID + ":" + id);
		}
	}

	public static class Items {
		
		public static final ITag.INamedTag<Item> GEMS_RUBY = forge("gems/ruby");
		public static final ITag.INamedTag<Item> ORES_RUBY = forge("ores/ruby");
		public static final ITag.INamedTag<Item> CONTAINERS_WATER = forge("containers/water");
		
		@SuppressWarnings("unused")
		private static ITag.INamedTag<Item> tag(String id) {
			return ItemTags.makeWrapperTag(Tutorial.ID + ":" + id);
		}
		
		private static ITag.INamedTag<Item> forge(String id) {
			return ItemTags.makeWrapperTag(ForgeVersion.MOD_ID + ":" + id);
		}
	}
}
