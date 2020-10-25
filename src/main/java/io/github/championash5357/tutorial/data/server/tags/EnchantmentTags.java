package io.github.championash5357.tutorial.data.server.tags;

import io.github.championash5357.tutorial.common.Tutorial;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EnchantmentTags extends AbstractTagsProvider<Enchantment> {

	@SuppressWarnings("deprecation")
	public EnchantmentTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, Registry.ENCHANTMENT, "enchantments", Tutorial.ID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
	}
}
