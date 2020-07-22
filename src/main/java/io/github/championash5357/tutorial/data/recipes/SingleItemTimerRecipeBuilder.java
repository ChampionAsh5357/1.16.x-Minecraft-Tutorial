package io.github.championash5357.tutorial.data.recipes;

import java.util.function.Consumer;

import com.google.gson.JsonObject;

import io.github.championash5357.tutorial.common.init.TutorialRecipes;
import io.github.championash5357.tutorial.common.recipe.AbstractSingleItemTimerRecipe;
import io.github.championash5357.tutorial.common.util.text.RecipeHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

public class SingleItemTimerRecipeBuilder {

	private String group;
	private final Ingredient ingredient;
	private final int time;
	private final ItemStack result;
	private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
	private final AbstractSingleItemTimerRecipe.Serializer<?> recipeSerializer;

	private SingleItemTimerRecipeBuilder(Ingredient ingredient, ItemStack result, int time, AbstractSingleItemTimerRecipe.Serializer<?> serializer) {
		this.ingredient = ingredient;
		this.result = result;
		this.time = time;
		this.recipeSerializer = serializer;
	}

	public static SingleItemTimerRecipeBuilder recipe(Ingredient ingredient, ItemStack result, int time, AbstractSingleItemTimerRecipe.Serializer<?> serializer) {
		return new SingleItemTimerRecipeBuilder(ingredient, result, time, serializer);
	}

	public static SingleItemTimerRecipeBuilder washerRecipe(Ingredient ingredient, ItemStack result, int time) {
		return recipe(ingredient, result, time, TutorialRecipes.WASHER.get());
	}

	public static SingleItemTimerRecipeBuilder washerRecipe(Ingredient ingredient, IItemProvider result, int count, int time) {
		return recipe(ingredient, new ItemStack(result, count), time, TutorialRecipes.WASHER.get());
	}

	public static SingleItemTimerRecipeBuilder washerRecipe(Ingredient ingredient, IItemProvider result, int time) {
		return recipe(ingredient, new ItemStack(result), time, TutorialRecipes.WASHER.get());
	}

	public SingleItemTimerRecipeBuilder addCriterion(String name, ICriterionInstance criterion) {
		this.advancementBuilder.withCriterion(name, criterion);
		return this;
	}

	public SingleItemTimerRecipeBuilder setGroup(String group) {
		this.group = group;
		return this;
	}

	public void build(Consumer<IFinishedRecipe> consumerIn) {
		this.build(consumerIn, this.result.getItem().getRegistryName());
	}

	public void build(Consumer<IFinishedRecipe> consumerIn, String save) {
		ResourceLocation resourcelocation = this.result.getItem().getRegistryName();
		ResourceLocation resourcelocation1 = new ResourceLocation(save);
		if (resourcelocation1.equals(resourcelocation)) {
			throw new IllegalStateException("Recipe " + resourcelocation1 + " should remove its 'save' argument");
		} else {
			this.build(consumerIn, resourcelocation1);
		}
	}

	public void build(Consumer<IFinishedRecipe> consumerIn, ResourceLocation id) {
		this.validate(id);
		this.advancementBuilder.withParentId(new ResourceLocation("recipes/root")).withCriterion("has_the_recipe", RecipeUnlockedTrigger.func_235675_a_(id)).withRewards(AdvancementRewards.Builder.recipe(id)).withRequirementsStrategy(IRequirementsStrategy.OR);
		consumerIn.accept(new SingleItemTimerRecipeBuilder.Result(id, this.group == null ? "" : this.group, this.ingredient, this.time, this.result, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + this.result.getItem().getGroup().getPath() + "/" + id.getPath()), this.recipeSerializer));
	}

	private void validate(ResourceLocation id) {
		if (this.advancementBuilder.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	public static class Result implements IFinishedRecipe {

		private final ResourceLocation id;
		private final String group;
		private final Ingredient ingredient;
		private final ItemStack result;
		private final int time;
		private final Advancement.Builder advancementBuilder;
		private final ResourceLocation advancementId;
		private final IRecipeSerializer<? extends AbstractSingleItemTimerRecipe> serializer;

		public Result(ResourceLocation id, String group, Ingredient ingredient, int time, ItemStack result, Advancement.Builder advancementBuilder, ResourceLocation advancementId, IRecipeSerializer<? extends AbstractSingleItemTimerRecipe> serializer) {
			this.id = id;
			this.group = group;
			this.ingredient = ingredient;
			this.time = time;
			this.result = result;
			this.advancementBuilder = advancementBuilder;
			this.advancementId = advancementId;
			this.serializer = serializer;
		}

		@Override
		public void serialize(JsonObject json) {
			if(!this.group.isEmpty()) {
				json.addProperty("group", this.group);
			}
			
			json.add("ingredient", this.ingredient.serialize());
			json.addProperty("time", this.time);
			json.add("result", RecipeHelper.serializeItemStack(this.result));
		}

		@Override
		public ResourceLocation getID() {
			return this.id;
		}

		@Override
		public IRecipeSerializer<?> getSerializer() {
			return this.serializer;
		}

		@Override
		public JsonObject getAdvancementJson() {
			return this.advancementBuilder.serialize();
		}

		@Override
		public ResourceLocation getAdvancementID() {
			return this.advancementId;
		}
	}
}
