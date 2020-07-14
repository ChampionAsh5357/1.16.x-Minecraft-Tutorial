package io.github.championash5357.tutorial.world.biome;

import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

import io.github.championash5357.tutorial.Tutorial;
import io.github.championash5357.tutorial.init.TutorialBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialBiomeFeatures {

	private static Stream<Biome> biomes;
	
	public static void applyBiomeFeatures() {
		biomes = getDifferentBiomes();
		
		generateFeatures(Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), TutorialBlocks.RUBY_ORE.get().getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)), Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.DESERT_LAKES, Biomes.BADLANDS, Biomes.BADLANDS_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_BADLANDS_PLATEAU, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.WOODED_BADLANDS_PLATEAU);
	}
	
	protected static void generateFeatures(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn, Biome... biomesIn) {
		for(Biome biome : biomesIn) biome.addFeature(stageIn, featureIn);
	}
	
	protected static void generateFeaturesExcept(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn, Biome... biomesIn) {
		List<Biome> list = Lists.newArrayList(biomesIn);
		biomes.filter(biome -> !list.contains(biome)).forEach(biome -> biome.addFeature(stageIn, featureIn));
	}
	
	protected static void generateFeaturesInAllBiomes(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn) {
		biomes.forEach(biome -> biome.addFeature(stageIn, featureIn));
	}
	
	private static Stream<Biome> getDifferentBiomes() {
		return ForgeRegistries.BIOMES.getValues().stream().filter(biome -> !biome.getRegistryName().getNamespace().equals(Tutorial.ID));
	}
}