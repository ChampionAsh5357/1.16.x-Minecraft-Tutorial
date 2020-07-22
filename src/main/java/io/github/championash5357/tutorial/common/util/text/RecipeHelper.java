package io.github.championash5357.tutorial.common.util.text;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;

public class RecipeHelper {

	public static JsonElement serializeItemStack(ItemStack stack) {
		JsonObject json = new JsonObject();
		json.addProperty("item", stack.getItem().getRegistryName().toString());
		json.addProperty("count", stack.getCount());
		if(stack.hasTag()) {
			json.addProperty("nbt", stack.getTag().toString());
		}
		return json;
	}
}
