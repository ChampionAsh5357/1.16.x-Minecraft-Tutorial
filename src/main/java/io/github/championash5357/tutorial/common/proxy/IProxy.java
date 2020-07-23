package io.github.championash5357.tutorial.common.proxy;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;

public interface IProxy {

	void setup(IEventBus modEventBus, IEventBus forgeEventBus);
	
	default <A> A getRubyArmorModel(EquipmentSlotType armorSlot) {
		return null;
	}
}
