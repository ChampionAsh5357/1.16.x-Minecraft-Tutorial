package io.github.championash5357.tutorial.common.inventory.container;

import java.util.function.BiConsumer;
import java.util.function.Function;

import com.mojang.datafixers.util.Pair;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.init.TutorialContainerTypes;
import io.github.championash5357.tutorial.common.tags.TutorialTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class WasherContainer extends Container {

	public static final ResourceLocation EMPTY_WASHER_WATER_CONTAINER = new ResourceLocation(Tutorial.ID, "item/empty_washer_water_container");

	private final Function<PlayerEntity, Boolean> interactFunction;
	private final BiConsumer<ItemStack, Integer> updateFunction;
	private final IntReferenceHolder data;
	private final IIntArray time;

	public WasherContainer(int id, PlayerInventory inventory) {
		this(id, inventory, new ItemStackHandler(9), (player) -> false, (a, b) -> {}, IntReferenceHolder.single(), new IntArray(8));
	}

	public WasherContainer(int id, PlayerInventory playerInventory, ItemStackHandler inventory, Function<PlayerEntity, Boolean> interact, BiConsumer<ItemStack, Integer> update, IntReferenceHolder data, IIntArray info) {
		super(TutorialContainerTypes.WASHER.get(), id);
		this.interactFunction = interact;
		this.updateFunction = update;
		this.data = data;
		this.time = info;

		this.addSlot(new SlotItemHandler(inventory, 0, 134, 35) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return TutorialTags.Items.CONTAINERS_WATER.contains(stack.getItem()) && getWashTime() > 0;
			}

			@Override
			public Pair<ResourceLocation, ResourceLocation> func_225517_c_() {
				return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, EMPTY_WASHER_WATER_CONTAINER);
			}
		});

		boolean reg = false;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(!(i == 1 && j == 1)) this.addSlot(new SlotItemHandler(inventory, j + i * 3 + (reg ? 0 : 1), 62 + j * 18, 17 + i * 18) {
					@Override
					public void onSlotChanged() {
						super.onSlotChanged();
						updateFunction.accept(getStack(), getSlotIndex());
					}
				});
				else reg = true;
			}
		}

		createPlayerInventory(playerInventory);

		this.trackInt(data);
		this.trackIntArray(info);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return interactFunction.apply(playerIn);
	}

	public int getCycleTime() {
		return data.get();
	}

	public int getWashTime() {
		int time = 0;
		for(int i = 0; i < 8; i++) time += this.time.get(i);
		return time;
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			if (index < 9) {
				if (!this.mergeItemStack(stack1, 9, 45, true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(stack1, 0, 9, false)) {
				return ItemStack.EMPTY;
			}

			if (stack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (stack1.getCount() == stack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, stack1);
		}

		return stack;
	}

	private void createPlayerInventory(PlayerInventory playerInventory) {
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 9; ++x) {
				this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}

		for(int x = 0; x < 9; ++x) {
			this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 142));
		}
	}
}
