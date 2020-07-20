package io.github.championash5357.tutorial.data;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.init.TutorialBlocks;
import io.github.championash5357.tutorial.common.init.TutorialItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class TutorialRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public TutorialRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		addOreSmeltingRecipes(consumer, TutorialBlocks.RUBY_ORE.get(), TutorialItems.RUBY.get(), 1.0f, 200);
		addBasicArmorRecipes(consumer, TutorialItems.RUBY.get(), TutorialItems.RUBY_HELMET.get(), TutorialItems.RUBY_CHESTPLATE.get(), TutorialItems.RUBY_LEGGINGS.get(), TutorialItems.RUBY_BOOTS.get());
		ShapedRecipeBuilder.shapedRecipe(TutorialBlocks.WASHER.get()).key('I', Items.IRON_INGOT).key('W', Items.WATER_BUCKET).patternLine("III").patternLine("IWI").patternLine("III").addCriterion("in_water", enteredBlock(Blocks.WATER)).build(consumer);
	}
	
	protected static void addBasicArmorRecipes(Consumer<IFinishedRecipe> consumer, IItemProvider material, @Nullable Item head, @Nullable Item chest, @Nullable Item legs, @Nullable Item feet) {
		if(head != null) ShapedRecipeBuilder.shapedRecipe(head).key('X', material).patternLine("XXX").patternLine("X X").setGroup("helmets").addCriterion("has_material", hasItem(material)).build(consumer);
		if(chest != null) ShapedRecipeBuilder.shapedRecipe(chest).key('X', material).patternLine("X X").patternLine("XXX").patternLine("XXX").setGroup("chestplates").addCriterion("has_material", hasItem(material)).build(consumer);
		if(legs != null) ShapedRecipeBuilder.shapedRecipe(legs).key('X', material).patternLine("XXX").patternLine("X X").patternLine("X X").setGroup("leggings").addCriterion("has_material", hasItem(material)).build(consumer);
		if(feet != null) ShapedRecipeBuilder.shapedRecipe(feet).key('X', material).patternLine("X X").patternLine("X X").setGroup("boots").addCriterion("has_material", hasItem(material)).build(consumer);
	}

	protected static void addOreSmeltingRecipes(Consumer<IFinishedRecipe> consumer, IItemProvider ore, Item result, float experience, int time) {
		String name = result.getRegistryName().getPath();
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ore), result, experience, time).addCriterion("has_ore", hasItem(ore)).build(consumer, new ResourceLocation(Tutorial.ID, name + "_from_smelting"));
		CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ore), result, experience, time / 2).addCriterion("has_ore", hasItem(ore)).build(consumer, new ResourceLocation(Tutorial.ID, name + "_from_blasting"));
	}
}
