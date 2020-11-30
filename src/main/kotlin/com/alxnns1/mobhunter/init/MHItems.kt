package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.block.MHPlant
import com.alxnns1.mobhunter.item.*
import net.minecraft.block.Block
import net.minecraft.entity.EntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.IItemTier
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.Effects
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.event.RegistryEvent
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHItems {
	private val TINT_ITEMS = mutableListOf<MHITintItem>()

	// Icons
	val ICON_ITEMS: Item by objectHolder("icon_items")
	val ICON_TOOLS: Item by objectHolder("icon_tools")
	val ICON_SNS: Item by objectHolder("icon_sns")
	val ICON_MOBS: Item by objectHolder("icon_mobs")

	// Consumables
	val POTION: Item by objectHolder("potion")
	val MEGA_POTION: Item by objectHolder("mega_potion")
	val NUTRIENTS: Item by objectHolder("nutrients")
	val MEGA_NUTRIENTS: Item by objectHolder("mega_nutrients")
	val ANTIDOTE: Item by objectHolder("antidote")
	val IMMUNIZER: Item by objectHolder("immunizer")
	val DEMONDRUG: Item by objectHolder("demondrug")
	val MIGHT_PILL: Item by objectHolder("might_pill")
	val ARMORSKIN: Item by objectHolder("armorskin")
	val ADAMANT_PILL: Item by objectHolder("adamant_pill")
	val COOL_DRINK: Item by objectHolder("cool_drink")
	val HOT_DRINK: Item by objectHolder("hot_drink")
	val CLEANSER: Item by objectHolder("cleanser")
	val HERBAL_MEDICINE: Item by objectHolder("herbal_medicine")
	val MAX_POTION: Item by objectHolder("max_potion")
	val ENERGY_DRINK: Item by objectHolder("energy_drink")

	// Brewing Intermediaries
	val BLUE_MUSHROOM_INTERMEDIARY: Item by objectHolder("blue_mushroom_intermediary")
	val BITTERBUG_INTERMEDIARY: Item by objectHolder("bitterbug_intermediary")
	val NITROSHROOM_INTERMEDIARY: Item by objectHolder("nitroshroom_intermediary")
	val CATALYST: Item by objectHolder("catalyst")

	// Tools
	val WHETSTONE: Item by objectHolder("whetstone")

	// Ores
	val MACHALITE_INGOT: Item by objectHolder("machalite_ingot")
	val ICE_CRYSTAL: Item by objectHolder("machalite_ingot")
	val DRAGONITE_INGOT: Item by objectHolder("dragonite_ingot")
	val CARBALITE_INGOT: Item by objectHolder("carbalite_ingot")
	val ELTALITE_INGOT: Item by objectHolder("eltalite_ingot")

	// Herbs
	val HERB: Item by objectHolder("herb")
	val ANTIDOTE_HERB: Item by objectHolder("antidote_herb")
	val GLOAMGRASS_ROOT: Item by objectHolder("gloamgrass_root")
	val HOT_PEPPER: Item by objectHolder("hot_pepper")

	// Mushrooms
	val BLUE_MUSHROOM: Item by objectHolder("blue_mushroom")
	val NITROSHROOM: Item by objectHolder("nitroshroom")
	val DRAGON_TOADSTOOL: Item by objectHolder("dragon_toadstool")

	// Berries
	val MIGHT_SEED: Item by objectHolder("might_seed")
	val ADAMANT_SEED: Item by objectHolder("adamant_seed")

	// Fish
	val POPFISH: Item by objectHolder("popfish")

	// Insects
	val BITTERBUG: Item by objectHolder("bitterbug")
	val GODBUG: Item by objectHolder("godbug")

	fun register(event: RegistryEvent.Register<Item>) {
		val registry = event.registry
		registry.registerAll(
			// Icons
			icon("icon_items"),
			icon("icon_tools"),
			icon("icon_sns"),
			icon("icon_mobs"),
			// Consumables
			consumable("potion", GREEN) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH)) },
			consumable("mega_potion", GREEN) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 1)) },
			consumable("nutrients", CYAN) { arrayOf(EffectInstance(Effects.ABSORPTION, 6000)) },
			consumable("mega_nutrients", CYAN) { arrayOf(EffectInstance(Effects.ABSORPTION, 6000, 1)) },
			consumable("antidote", BLUE) { arrayOf(EffectInstance(MHEffects.ANTIDOTE)) },
			consumable("immunizer", YELLOW) { arrayOf(EffectInstance(Effects.REGENERATION, 1200, 0)) },
			consumable("dash_juice", YELLOW) { arrayOf(EffectInstance(Effects.SATURATION, 0, 1)) },
			consumable("mega_dash_juice", YELLOW) { arrayOf(EffectInstance(Effects.SATURATION, 0, 3)) },
			consumable("demondrug", RED) { arrayOf(EffectInstance(Effects.STRENGTH, 6000, 1)) },
			consumable("mega_demondrug", RED) { arrayOf(EffectInstance(Effects.STRENGTH, 6000, 3)) },
			consumable("might_pill", RED) { arrayOf(EffectInstance(Effects.STRENGTH, 6000, 5)) },
			consumable("armorskin", ORANGE) { arrayOf(EffectInstance(Effects.RESISTANCE, 6000, 1)) },
			consumable("mega_armorskin", ORANGE) { arrayOf(EffectInstance(Effects.RESISTANCE, 6000, 3)) },
			consumable("adamant_pill", ORANGE) { arrayOf(EffectInstance(Effects.RESISTANCE, 6000, 5)) },
			item("cool_drink", WHITE), //TODO: some cooling effect
			item("hot_drink", RED), //TODO: some warming effect
			item("cleanser", CYAN), //TODO: same as milk
			item("psychoserum", ORANGE), //TODO: somehow know where monsters are
			consumable("herbal_medicine", WHITE) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH), EffectInstance(MHEffects.ANTIDOTE)) },
			consumable("max_potion", YELLOW) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 4), EffectInstance(MHEffects.ANTIDOTE, 6000, 4)) },
			consumable("ancient_potion", RED) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 4), EffectInstance(MHEffects.ANTIDOTE, 12000, 4), EffectInstance(Effects.SATURATION, 12000, 9)) },
			consumable("energy_drink", YELLOW) { arrayOf(EffectInstance(Effects.SATURATION)) },
			item("lifepowder", WHITE), //TODO: splash instant health 2
			consumable("dust_of_life", GREEN) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 4)) },
			// Brewing Intermediates
			item("blue_mushroom_intermediary", BLUE),
			item("bitterbug_intermediary", BLUE),
			item("nitroshroom_intermediary", RED),
			item("catalyst", GREY),
			// Tools
			item("whetstone", YELLOW, MobHunter.GROUP_TOOLS),
			*tools("machalite", BLUE, MHItemTier.MACHALITE),
			*tools("dragonite", GREEN, MHItemTier.DRAGONITE),
			*tools("carbalite", PURPLE, MHItemTier.CARBALITE),
			*tools("eltalite", RED, MHItemTier.ELTALITE),
			// Ores
			item("earth_crystal", WHITE),
			item("machalite_ingot", BLUE),
			item("ice_crystal", CYAN),
			item("bealite_ingot", CYAN),
			item("lightcrystal", GREY),
			item("dragonite_ingot", GREEN),
			item("firestone", RED),
			item("allfire_stone", RED),
			item("carbalite_ingot", PURPLE),
			item("eltalite_ingot", RED),
			item("meldspar_ingot", WHITE),
			item("novacrystal", WHITE),
			item("purecrystal", WHITE),
			item("fucium_ingot", PINK),
			item("firecell_stone", RED),
			item("ultimas_crystal", YELLOW),
			// Fish
			item("whetfish", YELLOW),
			item("sushifish", ORANGE),
			item("sleepyfish", CYAN),
			item("pin_tuna", GREY),
			item("speartuna", BLUE),
			item("popfish", GREY),
			item("scatterfish", GREY),
			item("burst_arowana", GREEN),
			item("bomb_arowana", PURPLE),
			item("glutton_tuna", ORANGE),
			item("gastronome_tuna", ORANGE),
			item("ancient_fish", WHITE),
			item("small_goldenfish", YELLOW),
			item("wanchovy", GREEN),
			item("guardfish", DEEP_YELLOW),
			item("goldenfish", YELLOW),
			item("silverfish", WHITE),
			item("brocadefish", BLUE),
			item("king_brocadefish", BLUE),
			item("premium_sashimi", WHITE),
			// Insects
			item("insect_husk", GREY),
			item("godbug", WHITE),
			item("bitterbug", BLUE),
			item("flashbug", YELLOW),
			item("thunderbug", YELLOW),
			item("stinkhopper", RED),
			item("snakebee_larva", ORANGE),
			item("carpenterbug", GREY),
			item("shiny_beetle", GREEN),
			item("hercudrome", RED),
			item("king_scarab", PURPLE),
			item("rare_scarab", YELLOW),
			item("emperor_hopper", DEEP_YELLOW),
			item("flutterfly", WHITE),
			item("stygian_worm", GREY),
			// Bones
			item("small_monster_bone", YELLOW),
			item("medium_monster_bone", YELLOW),
			item("mystery_bone", YELLOW),
			item("unknown_skull", YELLOW),
			item("huge_unknown_skull", YELLOW),
			// Herbivore
			item("raw_meat", RED),
			item("mosswine_hide", PINK),
			item("mosswine_thick_hide", PINK),
			item("kelbi_horn", BLUE),
			item("warm_pelt", GREEN),
			item("high_quality_pelt", ORANGE),
			item("prized_pelt", GREEN),
			item("white_liver", WHITE),
			// Neopteran
			item("monster_fluid", CYAN),
			item("monster_broth", BLUE),
			item("monster_essence", BLUE),
			item("hornetaur_shell", DARK_GREY),
			item("hornetaur_wing", DARK_GREY),
			item("hornetaur_carapace", DARK_GREY),
			item("hornetaur_head", DARK_GREY),
			item("hornetaur_razorwing", DARK_GREY),
			item("hornetaur_innerwing", DARK_GREY),
			// Spawn Eggs
			// Fish
			spawnEgg("sushifish_egg", 0xB07A4D, 0x734F32) { MHEntities.SUSHIFISH },
			spawnEgg("goldenfish_egg", 0xC8B235, 0x837422) { MHEntities.GOLDENFISH },
			// Herbivores
			spawnEgg("kelbi_egg", 0x607675, 0xD7CCAC) { MHEntities.KELBI },
			spawnEgg("mosswine_egg", 0xF6CFA5, 0x5C6E3E) { MHEntities.MOSSWINE },
			// Neopterans
			spawnEgg("hornetaur_egg", 0x2D1D16, 0xD7822C) { MHEntities.HORNETAUR }
		)

		// Item Blocks
		MHBlocks.BLOCKS.forEach { registry.register(block(it)) }
	}

	@OnlyIn(Dist.CLIENT)
	fun registerItemColours(event: ColorHandlerEvent.Item) {
		event.itemColors.register({ stack, tintIndex ->
			if (tintIndex == 0) (stack.item as MHITintItem).getColour() else -1
		}, *TINT_ITEMS.toTypedArray())
		// Need to register our spawn egg colours manually, as our eggs are inserted into SpawnEggItem.EGGS after the
		// list is used to register egg colours in vanilla
		event.itemColors.register({ stack, tintIndex ->
			(stack.item as MHSpawnEggItem).getColor(tintIndex)
		}, *MHSpawnEggItem.getNewEggsArray())
	}

	private fun props(group: ItemGroup? = null): Item.Properties =
		Item.Properties().apply { group?.let { group(it) } }

	private fun icon(name: String): Item = Item(props()).setRegistryName(name)

	private fun item(name: String, colour: Int, itemGroup: ItemGroup = MobHunter.GROUP_ITEMS): Item {
		val item = MHTintItem(props(itemGroup), colour).setRegistryName(name)
		TINT_ITEMS.add(item as MHITintItem)
		return item
	}

	private fun pickaxe(name: String, colour: Int, tier: IItemTier): Item {
		val item = MHPickaxeItem(tier, colour, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)
		TINT_ITEMS.add(item as MHITintItem)
		return item
	}

	private fun axe(name: String, colour: Int, tier: IItemTier): Item {
		val item = MHAxeItem(tier, colour, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)
		TINT_ITEMS.add(item as MHITintItem)
		return item
	}

	private fun shovel(name: String, colour: Int, tier: IItemTier): Item {
		val item = MHShovelItem(tier, colour, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)
		TINT_ITEMS.add(item as MHITintItem)
		return item
	}

	private fun hoe(name: String, colour: Int, tier: IItemTier): Item {
		val item = MHHoeItem(tier, colour, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)
		TINT_ITEMS.add(item as MHITintItem)
		return item
	}

	private fun tools(materialName: String, colour: Int, tier: IItemTier): Array<Item> = arrayOf(
		pickaxe("${materialName}_pickaxe", colour, tier),
		axe("${materialName}_axe", colour, tier),
		shovel("${materialName}_shovel", colour, tier),
		hoe("${materialName}_hoe", colour, tier)
	)

	private fun block(block: Block): Item {
		return if (block is MHPlant) {
			val item = MHTintBlockItem(block, props(MobHunter.GROUP_BLOCKS), block.colour).setRegistryName(block.registryName)
			TINT_ITEMS.add(item as MHTintBlockItem)
			item
		} else {
			BlockItem(block, props(MobHunter.GROUP_BLOCKS)).setRegistryName(block.registryName)
		}
	}

	private fun spawnEgg(
		name: String,
		primaryColour: Int,
		secondaryColour: Int,
		entityTypeSupplier: () -> EntityType<*>
	): Item = MHSpawnEggItem(entityTypeSupplier, primaryColour, secondaryColour, props(MobHunter.GROUP_ENTITIES)).setRegistryName(name)

	private fun consumable(name: String, colour: Int, potionEffects: () -> Array<EffectInstance>): Item {
		val item = MHConsumable(props(MobHunter.GROUP_ITEMS), colour, potionEffects).setRegistryName(name)
		TINT_ITEMS.add(item as MHITintItem)
		return item
	}
}
