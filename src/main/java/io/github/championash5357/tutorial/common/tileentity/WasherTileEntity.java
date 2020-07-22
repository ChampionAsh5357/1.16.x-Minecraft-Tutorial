package io.github.championash5357.tutorial.common.tileentity;

import io.github.championash5357.tutorial.common.init.TutorialTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class WasherTileEntity extends ItemHandlerTileEntity<ItemStackHandler> implements ITickableTileEntity {

	private int cycleTime;
	
	public WasherTileEntity() {
		super(TutorialTileEntities.WASHER.get());
	}

	@Override
	public void tick() {
	}
	
	@Override
	protected ItemStackHandler createInventory() {
		return new ItemStackHandler(9);
	}
	
	@Override
	public void read(BlockState stateIn, CompoundNBT nbtIn) {
		super.read(stateIn, nbtIn);
		cycleTime = nbtIn.getInt("cycleTime");
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putInt("cycleTime", cycleTime);
		return compound;
	}	
}
