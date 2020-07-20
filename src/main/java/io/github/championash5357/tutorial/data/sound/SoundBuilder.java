package io.github.championash5357.tutorial.data.sound;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;

public class SoundBuilder {

	private ResourceLocation name;
	private boolean replace;
	@Nullable
	private String subtitleTranslationKey;
	private final List<SoundExtension> sounds = new ArrayList<>();
	
	private SoundBuilder(ResourceLocation location) {
		this.name = location;
	}
	
	public static SoundBuilder builder(SoundEvent sound) {
		return builder(sound.getRegistryName());
	}
	
	public static SoundBuilder builder(Supplier<? extends SoundEvent> soundSupplier) {
		return builder(soundSupplier.get());
	}
	
	public static SoundBuilder builder(ResourceLocation location) {
		return new SoundBuilder(location);
	}

	public SoundBuilder replace() {
		this.replace = true;
		return this;
	}
	
	public SoundBuilder subtitle() {
		return subtitle("subtitle." + name.getNamespace() + "." + name.getPath());
	}
	
	public SoundBuilder subtitle(String translationKey) {
		this.subtitleTranslationKey = translationKey;
		return this;
	}
	
	private SoundBuilder defaultSound() {
		return sound(this.name);
	}
	
	public SoundBuilder sound(ResourceLocation name) {
		this.sounds.add(new SoundExtension(name));
		return this;
	}
	
	public SoundBuilder sound(SoundExtension soundIn) {
		this.sounds.add(soundIn);
		return this;
	}
	
	public void build(Consumer<SoundBuilder> consumer) {
		this.validate();
		consumer.accept(this);
	}
	
	private void validate() {
		if(this.sounds.isEmpty()) {
			this.defaultSound();
		}
		this.sounds.forEach(SoundExtension::validate);
	}
	
	public void serialize(JsonObject parentObject) {
		JsonObject object = new JsonObject();
		
		object.addProperty("replace", this.replace);
		if(subtitleTranslationKey != null) {
			object.addProperty("subtitle", this.subtitleTranslationKey);
		}
		
		JsonArray array = new JsonArray();
		this.sounds.forEach(sound -> array.add(sound.serialize()));
		object.add("sounds", array);
		
		parentObject.add(this.name.getPath(), object);
	}
	
	public static class SoundExtension {
		
		private final String name;
		private float volume = 1.0f, pitch = 1.0f;
		private int weight = 1, attenuation_distance = 16;
		private boolean stream, preload;
		
		private SoundExtension(ResourceLocation name) {
			this.name = name.toString().replaceAll("[.]", "/");
		}
		
		public static SoundExtension builder(ResourceLocation name) {
			return new SoundExtension(name);
		}
		
		public SoundExtension volume(float volumeIn) {
			this.volume = volumeIn;
			return this;
		}
		
		public SoundExtension pitch(float pitchIn) {
			this.pitch = pitchIn;
			return this;
		}
		
		public SoundExtension weight(int weightIn) {
			this.weight = weightIn;
			return this;
		}
		
		public SoundExtension stream() {
			this.stream = true;
			return this;
		}
		
		public SoundExtension attenuationDistance(int attenuationDistanceIn) {
			this.attenuation_distance = attenuationDistanceIn;
			return this;
		}
		
		public SoundExtension preload() {
			this.preload = true;
			return this;
		}
		
		private void validate() {
			if(this.volume != MathHelper.clamp(this.volume, 0, 1.0)) {
				throw new IllegalArgumentException("Sound " + name + " has a volume not between 0 and 1.");
			} else if(this.pitch != MathHelper.clamp(this.pitch, 0, 2.0)) {
				throw new IllegalArgumentException("Sound " + name + " has a pitch not between 0 and 2.");
			} else if(this.weight <= 0) {
				throw new IllegalArgumentException("Sound " + name + " has a negative or zero weight.");
			} else if(this.attenuation_distance <= 0) {
				throw new IllegalArgumentException("Sound " + name + " has a negative or zero attenuation distance.");
			}
		}
		
		private JsonObject serialize() {
			JsonObject object = new JsonObject();
			
			object.addProperty("name", this.name);
			object.addProperty("volume", this.volume);
			object.addProperty("pitch", this.pitch);
			object.addProperty("weight", this.weight);
			object.addProperty("weight", this.weight);
			object.addProperty("stream", this.stream);
			object.addProperty("attenuation_distance", this.attenuation_distance);
			object.addProperty("preload", this.preload);
			
			return object;
		}
	}
}
