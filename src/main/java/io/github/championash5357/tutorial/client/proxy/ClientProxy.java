package io.github.championash5357.tutorial.client.proxy;

import io.github.championash5357.tutorial.client.gui.screen.inventory.WasherScreen;
import io.github.championash5357.tutorial.client.renderer.entity.model.RubyArmorModel;
import io.github.championash5357.tutorial.common.init.TutorialContainerTypes;
import io.github.championash5357.tutorial.common.inventory.container.WasherContainer;
import io.github.championash5357.tutorial.common.proxy.IProxy;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy implements IProxy {

	private final RubyArmorModel rubyArmorModel = new RubyArmorModel(1.0f);
	private final RubyArmorModel rubyArmorLeggings = new RubyArmorModel(0.5f);
		
	@Override
	public void setup(IEventBus modEventBus, IEventBus forgeEventBus) {
		
		//Mod Event Bus Listeners
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(this::registerIcons);
	}
	
	private void clientSetup(final FMLClientSetupEvent event) {
		registerGuis();
	}
	
	private void registerGuis() {
		ScreenManager.registerFactory(TutorialContainerTypes.WASHER.get(), WasherScreen::new);
	}
	
	private void registerIcons(final TextureStitchEvent.Pre event) {
		event.addSprite(WasherContainer.EMPTY_WASHER_WATER_CONTAINER);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <A> A getRubyArmorModel(EquipmentSlotType armorSlot) {
		return (A) (armorSlot == EquipmentSlotType.LEGS ? rubyArmorLeggings : rubyArmorModel);
	}
}
