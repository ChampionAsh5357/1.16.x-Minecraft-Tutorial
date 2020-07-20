package io.github.championash5357.tutorial.client.proxy;

import io.github.championash5357.tutorial.client.renderer.entity.model.RubyArmorModel;
import io.github.championash5357.tutorial.common.proxy.IProxy;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy implements IProxy {

	private final RubyArmorModel rubyArmorModel = new RubyArmorModel(1.0f);
	private final RubyArmorModel rubyArmorLeggings = new RubyArmorModel(0.5f);
		
	@Override
	public void setup(IEventBus modEventBus, IEventBus forgeEventBus) {
		
		//Mod Event Bus Listeners
		modEventBus.addListener(this::clientSetup);
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {}
	
	@SuppressWarnings("unchecked")
	public <A extends BipedModel<?>> A getRubyArmorModel(EquipmentSlotType armorSlot) {
		return (A) (armorSlot == EquipmentSlotType.LEGS ? rubyArmorLeggings : rubyArmorModel);
	}
}
