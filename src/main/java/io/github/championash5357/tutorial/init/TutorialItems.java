package io.github.championash5357.tutorial.init;

import io.github.championash5357.tutorial.Tutorial;
import io.github.championash5357.tutorial.item.RubyArmorItem;
import io.github.championash5357.tutorial.item.TutorialArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tutorial.ID);

	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
	public static final RegistryObject<RubyArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new RubyArmorItem(TutorialArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final RegistryObject<RubyArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new RubyArmorItem(TutorialArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final RegistryObject<RubyArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new RubyArmorItem(TutorialArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	public static final RegistryObject<RubyArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new RubyArmorItem(TutorialArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
}