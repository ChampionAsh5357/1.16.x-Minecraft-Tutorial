package io.github.championash5357.tutorial.data.advancements;

import java.util.function.Consumer;

import com.google.gson.JsonObject;

import net.minecraft.advancements.Advancement;
import net.minecraft.util.ResourceLocation;

public class FinishedAdvancement {

	private final ResourceLocation id;
	private final Advancement.Builder builder;
	
	private FinishedAdvancement(ResourceLocation idIn, Advancement.Builder builderIn) {
		this.id = idIn;
		this.builder = builderIn;
	}

	public JsonObject serialize() {
		return this.builder.serialize();
	}
	
	public ResourceLocation getId() {
		return id;
	}
	
	public static class Builder {
		
		private Advancement.Builder builder;
		
		private Builder() {}
		
		public static FinishedAdvancement.Builder builder() {
			return new FinishedAdvancement.Builder();
		}
		
		public FinishedAdvancement.Builder advancement(Advancement.Builder builderIn) {
			this.builder = builderIn;
			return this;
		}
		
		public FinishedAdvancement build(Consumer<FinishedAdvancement> consumer, ResourceLocation id) {
			FinishedAdvancement advancement = new FinishedAdvancement(id, builder);
			consumer.accept(advancement);
			return advancement;
		}
	}
}
