package io.github.championash5357.tutorial.common.init;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.recipe.AbstractSingleItemTimerRecipe;
import io.github.championash5357.tutorial.common.recipe.WasherRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialRecipes {
	
	public static class Type {
		public static final IRecipeType<WasherRecipe> WASHER = IRecipeType.register(Tutorial.ID + ":washer");
	}
	
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Tutorial.ID);
	
	public static final RegistryObject<AbstractSingleItemTimerRecipe.Serializer<WasherRecipe>> WASHER = RECIPES.register("washer", () -> new AbstractSingleItemTimerRecipe.Serializer<>(WasherRecipe::new));
}
