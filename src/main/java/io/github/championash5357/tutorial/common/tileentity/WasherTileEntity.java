package io.github.championash5357.tutorial.common.tileentity;

import java.util.Optional;

import io.github.championash5357.tutorial.common.init.TutorialRecipes;
import io.github.championash5357.tutorial.common.init.TutorialTileEntities;
import io.github.championash5357.tutorial.common.inventory.container.WasherContainer;
import io.github.championash5357.tutorial.common.recipe.WasherRecipe;
import io.github.championash5357.tutorial.common.tags.TutorialTags;
import io.github.championash5357.tutorial.common.util.text.TextTranslations;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.IntArray;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class WasherTileEntity extends ItemHandlerTileEntity<ItemStackHandler> implements ITickableTileEntity, INamedContainerProvider {

	private int cycleTime;
	private final IntReferenceHolder washerData = new IntReferenceHolder() {
		
		@Override
		public void set(int value) {
			WasherTileEntity.this.cycleTime = value;
		}
		
		@Override
		public int get() {
			return WasherTileEntity.this.cycleTime;
		}
	};
	private final IntArray washTimeInformation = new IntArray(8);
	
	public WasherTileEntity() {
		super(TutorialTileEntities.WASHER.get());
	}

	public boolean isWashing() {
		return cycleTime > 0;
	}
	
	@Override
	public void tick() {
		boolean washing = isWashing();
		boolean updateInventory = false;
		if(washing) {
			--cycleTime;
		}
		
		if(!this.world.isRemote) {
			
			if(!isWashing() && washing) {
				ItemStack stack = this.inventory.getStackInSlot(0);
				if(stack.hasContainerItem()) {
					this.inventory.setStackInSlot(0, stack.getContainerItem());
				} else if(!stack.isEmpty()) {
					stack.shrink(1);
					if(stack.isEmpty()) {
						this.inventory.setStackInSlot(0, stack.getContainerItem());
					}
				}
				
				for(int i = 1; i < 9; i++) {
					ItemStack item = this.inventory.getStackInSlot(i);
					RecipeWrapper wrapper = new RecipeWrapper(new ItemStackHandler(NonNullList.withSize(1, item)));
					Optional<WasherRecipe> washer = this.world.getRecipeManager().getRecipe(TutorialRecipes.Type.WASHER, wrapper, world);
					if(washer.isPresent()) {
						ItemStack result = washer.get().getCraftingResult(wrapper);
						result.setCount(item.getCount());
						this.inventory.setStackInSlot(i, result);
					}
				}
				
				updateInventory = true;
			}
			
			if(!washing && TutorialTags.Items.CONTAINERS_WATER.contains(inventory.getStackInSlot(0).getItem())) {
				for(int i = 0; i < 8; i++) cycleTime += washTimeInformation.get(i);
			}
		}
		
		if(updateInventory) this.markDirty();
	}
	
	@Override
	protected ItemStackHandler createInventory() {
		return new ItemStackHandler(9) {
			@Override
			protected void onContentsChanged(int slot) {
				super.onContentsChanged(slot);
				if(slot != 0) {
					infoUpdate(this.getStackInSlot(slot), slot);
				}
			}
		};
	}
	
	public void infoUpdate(ItemStack stack, int slot) {
		Optional<WasherRecipe> opt = world.getRecipeManager().getRecipe(TutorialRecipes.Type.WASHER, new RecipeWrapper(new ItemStackHandler(NonNullList.withSize(1, stack))), world);
		washTimeInformation.set(slot - 1, opt.isPresent() ? stack.getCount() * opt.get().getTime() : 0);
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

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		return super.canInteractWith(player) && !isWashing();
	}
	
	@Override
	public Container createMenu(int windowID, PlayerInventory inventory, PlayerEntity player) {
		for(int i = 1; i < 9; i++) infoUpdate(getInventory().getStackInSlot(i), i);
		return new WasherContainer(windowID, inventory, getInventory(), this::canInteractWith, this::infoUpdate, washerData, washTimeInformation);
	}

	@Override
	public ITextComponent getDisplayName() {
		return TextTranslations.CONTAINER_WASHER;
	}	
}
