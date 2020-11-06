package com.alxnns1.mobhunter.init;

import net.minecraft.item.*;

import java.util.ArrayList;

public class ModItems {

	private static ArrayList<Item> ITEMS = new ArrayList<>();

	public static Item ITEM_GROUP_ICON;

	public static Item[] register() {
		//TOOLS
		registerTool("machalite_pickaxe", ItemTier.IRON, 1, -2.8F, ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerTool("dragonite_pickaxe", ItemTier.IRON, 1, -2.8F, ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerTool("carbalite_pickaxe", ItemTier.DIAMOND, 1, -2.8F, ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerTool("eltalite_pickaxe", ItemTier.NETHERITE, 1, -2.8F, ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		//ORES
		ITEM_GROUP_ICON = registerItem("earth_crystal", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("machalite_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("ice_crystal", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("bealite_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("lightcrystal", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("dragonite_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("firestone", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("carbalite_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("eltalite_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("meldspar_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("novacrystal", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("purecrystal", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("fucium_ingot", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("firecell_stone", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		//FISH
		registerItem("whetfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("sushifish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("sleepyfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("pin_tuna", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("speartuna", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("popfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("scatterfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("burst_arowana", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("bomb_arowana", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("glutton_tuna", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("gastronome_tuna", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("ancient_fish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("small_goldenfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("wanchovy", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("guardfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("brocadefish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("goldenfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("king_brocadefish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("premium_sashimi", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("silverfish", ModItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);

		return ITEMS.toArray(new Item[0]);
	}

	private static Item registerItem(String name, ItemGroup itemGroup) {
		Item item = new Item(new Item.Properties().group(itemGroup)).setRegistryName(name);
		ITEMS.add(item);
		return item;
	}

	private static void registerTool(String name, IItemTier itemTier, int attackDamage, float attackSpeed, ItemGroup itemGroup) {
		ITEMS.add(new PickaxeItem(itemTier, attackDamage, attackSpeed, new Item.Properties().group(itemGroup)).setRegistryName(name));
	}
}
