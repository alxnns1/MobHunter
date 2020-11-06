package com.alxnns1.mobhunter.init;

import net.minecraft.item.*;

import java.util.HashMap;

public class MHItems {

	public static final HashMap<String, Item> ITEMS = new HashMap<>();

	public static Item[] register() {
		//TOOLS
		registerTool("machalite_pickaxe", ItemTier.IRON, 1, -2.8F, MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerTool("dragonite_pickaxe", ItemTier.IRON, 1, -2.8F, MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerTool("carbalite_pickaxe", ItemTier.DIAMOND, 1, -2.8F, MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerTool("eltalite_pickaxe", ItemTier.NETHERITE, 1, -2.8F, MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		//ORES
		registerItem("earth_crystal", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("machalite_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("ice_crystal", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("bealite_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("lightcrystal", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("dragonite_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("firestone", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("carbalite_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("eltalite_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("meldspar_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("novacrystal", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("purecrystal", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("fucium_ingot", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("firecell_stone", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("allfire_stone", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("ultimas_crystal", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		//FISH
		registerItem("whetfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("sushifish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("sleepyfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("pin_tuna", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("speartuna", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("popfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("scatterfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("burst_arowana", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("bomb_arowana", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("glutton_tuna", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("gastronome_tuna", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("ancient_fish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("small_goldenfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("wanchovy", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("guardfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("brocadefish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("goldenfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("king_brocadefish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("premium_sashimi", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);
		registerItem("silverfish", MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP);

		return ITEMS.values().toArray(new Item[0]);
	}

	private static void registerItem(String name, ItemGroup itemGroup) {
		Item item = new Item(new Item.Properties().group(itemGroup)).setRegistryName(name);
		ITEMS.put(name, item);
	}

	private static void registerTool(String name, IItemTier itemTier, int attackDamage, float attackSpeed, ItemGroup itemGroup) {
		Item item = new PickaxeItem(itemTier, attackDamage, attackSpeed, new Item.Properties().group(itemGroup)).setRegistryName(name);
		ITEMS.put(name, item);
	}
}
