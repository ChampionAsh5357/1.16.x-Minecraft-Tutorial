package io.github.championash5357.tutorial.common.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public abstract class ItemHandlerTileEntity<INVENTORY extends IItemHandler & INBTSerializable<CompoundNBT>> extends TileEntity {

	protected final INVENTORY inventory = createInventory();
	private final LazyOptional<INVENTORY> inventoryHolder = LazyOptional.of(() -> inventory);

	public ItemHandlerTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	protected abstract INVENTORY createInventory();

	public INVENTORY getInventory() {
		return inventory;
	}

	@Override
	public void read(BlockState stateIn, CompoundNBT nbtIn) {
		super.read(stateIn, nbtIn);
		inventory.deserializeNBT(nbtIn.getCompound("inventory"));
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.put("inventory", inventory.serializeNBT());
		return compound;
	}

	@Override
	protected void invalidateCaps() {
		super.invalidateCaps();
		inventoryHolder.invalidate();
	}

	public boolean canInteractWith(PlayerEntity player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return !(player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) > 64.0D);
		}
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return inventoryHolder.cast();
		}
		return super.getCapability(cap, side);
	}
}
