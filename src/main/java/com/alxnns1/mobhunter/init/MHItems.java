package com.alxnns1.mobhunter.init;

import net.minecraft.item.*;

import java.util.HashMap;

public class MHItems {

	public static final HashMap<String, Item> ITEMS = new HashMap<>();

	public static Item[] register() {
		//TOOLS
		registerPickaxe("machalite_pickaxe", ItemTier.IRON);
		registerPickaxe("dragonite_pickaxe", ItemTier.IRON);
		registerPickaxe("carbalite_pickaxe", ItemTier.DIAMOND);
		registerPickaxe("eltalite_pickaxe", ItemTier.NETHERITE);
		registerAxe("machalite_axe", ItemTier.IRON);
		registerAxe("dragonite_axe", ItemTier.IRON);
		registerAxe("carbalite_axe", ItemTier.DIAMOND);
		registerAxe("eltalite_axe", ItemTier.NETHERITE);
		registerShovel("machalite_shovel", ItemTier.IRON);
		registerShovel("dragonite_shovel", ItemTier.IRON);
		registerShovel("carbalite_shovel", ItemTier.DIAMOND);
		registerShovel("eltalite_shovel", ItemTier.NETHERITE);
		registerHoe("machalite_hoe", ItemTier.IRON);
		registerHoe("dragonite_hoe", ItemTier.IRON);
		registerHoe("carbalite_hoe", ItemTier.DIAMOND);
		registerHoe("eltalite_hoe", ItemTier.NETHERITE);
		//ORES
		registerItem("earth_crystal");
		registerItem("machalite_ingot");
		registerItem("ice_crystal");
		registerItem("bealite_ingot");
		registerItem("lightcrystal");
		registerItem("dragonite_ingot");
		registerItem("firestone");
		registerItem("carbalite_ingot");
		registerItem("eltalite_ingot");
		registerItem("meldspar_ingot");
		registerItem("novacrystal");
		registerItem("purecrystal");
		registerItem("fucium_ingot");
		registerItem("firecell_stone");
		registerItem("allfire_stone");
		registerItem("ultimas_crystal");
		//FISH
		registerItem("whetfish");
		registerItem("sushifish");
		registerItem("sleepyfish");
		registerItem("pin_tuna");
		registerItem("speartuna");
		registerItem("popfish");
		registerItem("scatterfish");
		registerItem("burst_arowana");
		registerItem("bomb_arowana");
		registerItem("glutton_tuna");
		registerItem("gastronome_tuna");
		registerItem("ancient_fish");
		registerItem("small_goldenfish");
		registerItem("wanchovy");
		registerItem("guardfish");
		registerItem("brocadefish");
		registerItem("goldenfish");
		registerItem("king_brocadefish");
		registerItem("premium_sashimi");
		registerItem("silverfish");

		return ITEMS.values().toArray(new Item[0]);
	}

	private static void registerItem(String name) {
		Item item = new Item(new Item.Properties().group(MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP)).setRegistryName(name);
		ITEMS.put(name, item);
	}

	private static void registerPickaxe(String name, IItemTier itemTier) {
		Item item = new PickaxeItem(itemTier, 1, -2.8F, new Item.Properties().group(MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP)).setRegistryName(name);
		ITEMS.put(name, item);
	}

	private static void registerAxe(String name, IItemTier itemTier) {
		Item item = new AxeItem(itemTier, 6F, -3.1F, new Item.Properties().group(MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP)).setRegistryName(name);
		ITEMS.put(name, item);
	}

	private static void registerShovel(String name, IItemTier itemTier) {
		Item item = new ShovelItem(itemTier, 1.5F, -3F, new Item.Properties().group(MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP)).setRegistryName(name);
		ITEMS.put(name, item);
	}

	private static void registerHoe(String name, IItemTier itemTier) {
		Item item = new HoeItem(itemTier, 3, 0F, new Item.Properties().group(MHItemGroups.MOB_HUNTER_ITEMS_ITEM_GROUP)).setRegistryName(name);
		ITEMS.put(name, item);
	}
}
