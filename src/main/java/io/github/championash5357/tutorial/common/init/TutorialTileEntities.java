package io.github.championash5357.tutorial.common.init;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.tileentity.WasherTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialTileEntities {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Tutorial.ID);
	
	public static final RegistryObject<TileEntityType<WasherTileEntity>> WASHER = TILE_ENTITIES.register("washer", () -> TileEntityType.Builder.create(WasherTileEntity::new, TutorialBlocks.WASHER.get()).build(null));
}
