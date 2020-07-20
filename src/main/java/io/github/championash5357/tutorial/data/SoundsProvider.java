package io.github.championash5357.tutorial.data;

import java.io.IOException;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import io.github.championash5357.tutorial.data.sound.SoundBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;

public abstract class SoundsProvider implements IDataProvider {

	private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
	private final DataGenerator gen;
	private final String modid;

	public SoundsProvider(DataGenerator gen, String modid) {
		this.gen = gen;
		this.modid = modid;
	}

	protected abstract void addSounds(Consumer<SoundBuilder> consumer);
	
	@Override
	public void act(DirectoryCache cache) throws IOException {
		JsonObject object = new JsonObject();
		addSounds(builder -> builder.serialize(object));
		IDataProvider.save(GSON, cache, object, this.gen.getOutputFolder().resolve("assets/" + modid + "/sounds.json"));
	}

	@Override
	public String getName() {
		return "Sounds";
	}

}
