package io.github.championash5357.tutorial.common.init;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.inventory.container.WasherContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Tutorial.ID);
	
	public static final RegistryObject<ContainerType<WasherContainer>> WASHER = CONTAINERS.register("washer", () -> new ContainerType<>(WasherContainer::new));
}
