package io.github.championash5357.tutorial.common.recipe;

import io.github.championash5357.tutorial.common.init.TutorialBlocks;
import io.github.championash5357.tutorial.common.init.TutorialRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class WasherRecipe extends AbstractSingleItemTimerRecipe {

	public WasherRecipe(ResourceLocation id, String group, Ingredient ingredient, int time, ItemStack result) {
		super(TutorialRecipes.Type.WASHER, TutorialRecipes.WASHER.get(), id, group, ingredient, time, result);
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStack(TutorialBlocks.WASHER.get());
	}
}
