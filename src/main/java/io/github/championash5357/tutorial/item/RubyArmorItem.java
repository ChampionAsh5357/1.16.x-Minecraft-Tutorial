package io.github.championash5357.tutorial.item;

import io.github.championash5357.tutorial.Tutorial;
import io.github.championash5357.tutorial.client.proxy.ClientProxy;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class RubyArmorItem extends ArmorItem {
	
	public RubyArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties properties) {
		super(materialIn, slot, properties);
	}
	
	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
		return Tutorial.PROXY instanceof ClientProxy ? ((ClientProxy) Tutorial.PROXY).getRubyArmorModel(armorSlot) : null;
	}
}
