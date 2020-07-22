package io.github.championash5357.tutorial.common.recipe;

import com.google.gson.JsonObject;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public abstract class AbstractSingleItemTimerRecipe implements IRecipe<IInventory> {

	protected final ResourceLocation id;
	protected final String group;
	protected final Ingredient ingredient;
	protected final int time;
	protected final ItemStack result;
	private final IRecipeType<?> type;
	private final IRecipeSerializer<?> serializer;
	
	public AbstractSingleItemTimerRecipe(IRecipeType<?> type, IRecipeSerializer<?> serializer, ResourceLocation id, String group, Ingredient ingredient, int time, ItemStack result) {
		this.type = type;
		this.serializer = serializer;
		this.id = id;
		this.group = group;
		this.ingredient = ingredient;
		this.time = time;
		this.result = result;
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return this.ingredient.test(inv.getStackInSlot(0));
	}

	@Override
	public ItemStack getCraftingResult(IInventory inv) {
		return this.result.copy();
	}

	@Override
	public boolean canFit(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.result;
	}
	
	@Override
	public String getGroup() {
		return this.group;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> ingredients = NonNullList.create();
		ingredients.add(ingredient);
		return ingredients;
	}
	
	@Override
	public NonNullList<ItemStack> getRemainingItems(IInventory inv) {
		return NonNullList.create();
	}
	
	@Override
	public ResourceLocation getId() {
		return this.id;
	}
	
	public int getTime() {
		return time;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return this.serializer;
	}

	@Override
	public IRecipeType<?> getType() {
		return this.type;
	}
	
	public static class Serializer<T extends AbstractSingleItemTimerRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {

		private final IRecipeFactory<T> factory;

		public Serializer(IRecipeFactory<T> factory) {
			this.factory = factory;
		}

		@Override
		public T read(ResourceLocation recipeId, JsonObject json) {
			String group = JSONUtils.getString(json, "group", "");
			Ingredient ingredient = JSONUtils.isJsonArray(json, "ingredient") ? Ingredient.deserialize(JSONUtils.getJsonArray(json, "ingredient")) : Ingredient.deserialize(JSONUtils.getJsonObject(json, "ingredient"));
			int time = JSONUtils.getInt(json, "time");
			ItemStack stack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
			return this.factory.create(recipeId, group, ingredient, time, stack);
		}

		@Override
		public T read(ResourceLocation recipeId, PacketBuffer buffer) {
			String group = buffer.readString();
			Ingredient ingredient = Ingredient.read(buffer);
			int time = buffer.readInt();
			ItemStack stack = buffer.readItemStack();
			return this.factory.create(recipeId, group, ingredient, time, stack);
		}

		@Override
		public void write(PacketBuffer buffer, T recipe) {
			buffer.writeString(recipe.group);
			recipe.ingredient.write(buffer);
			buffer.writeInt(recipe.time);
			buffer.writeItemStack(recipe.result);
		}

		public interface IRecipeFactory<T extends AbstractSingleItemTimerRecipe> {
			T create(ResourceLocation id, String group, Ingredient ingredient, int time, ItemStack result);
		}
	}
}