package io.github.championash5357.tutorial.data.server.tags;

import java.nio.file.Path;

import org.codehaus.plexus.util.StringUtils;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

public abstract class AbstractTagsProvider<T> extends TagsProvider<T> {
	
	private final String folderName;
	
	protected AbstractTagsProvider(DataGenerator generatorIn, Registry<T> registryIn, String folderName, String modId, ExistingFileHelper existingFileHelper) {
		super(generatorIn, registryIn, modId, existingFileHelper);
		this.folderName = folderName;
	}
	
	@Override
	protected Path makePath(ResourceLocation id) {
		return this.generator.getOutputFolder().resolve("data/" + id.getNamespace() + "/tags/" + this.folderName + "/" + id.getPath() + ".json");
	}
	
	@Override
	public String getName() {
		return StringUtils.capitaliseAllWords(this.folderName.replace('_', ' ')) + " Tags";
	}	
}
