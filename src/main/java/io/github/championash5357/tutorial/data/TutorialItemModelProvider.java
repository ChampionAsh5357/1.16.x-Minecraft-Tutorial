package io.github.championash5357.tutorial.data;

import java.util.function.Supplier;

import io.github.championash5357.tutorial.Tutorial;
import io.github.championash5357.tutorial.init.TutorialItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class TutorialItemModelProvider extends ItemModelProvider {

	public TutorialItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(TutorialItems.RUBY);
		simpleItem(TutorialItems.RUBY_HELMET);
		simpleItem(TutorialItems.RUBY_CHESTPLATE);
		simpleItem(TutorialItems.RUBY_LEGGINGS);
		simpleItem(TutorialItems.RUBY_BOOTS);
	}
	
	public void simpleItem(Supplier<? extends Item> itemSupplier) {
		ResourceLocation location = itemSupplier.get().getRegistryName();
		this.getBuilder(location.getPath())
		.parent(new ModelFile.UncheckedModelFile("item/generated"))
		.texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
}
