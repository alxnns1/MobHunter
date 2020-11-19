package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.block.MHPlant
import com.alxnns1.mobhunter.item.*
import net.minecraft.block.Block
import net.minecraft.entity.EntityType
import net.minecraft.item.*
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

	// Spawn Eggs
	val GOLDENFISH_EGG: Item by objectHolder("goldenfish_egg")

	fun register(event: RegistryEvent.Register<Item>) {
		val registry = event.registry
		registry.registerAll(
			// Icons
			icon("icon_items"),
			icon("icon_tools"),
			icon("icon_sns"),
			icon("icon_mobs"),
			// Consumables
			consumable("potion", MHColours.GREEN) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH)) },
			consumable("mega_potion", MHColours.GREEN) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 1)) },
			consumable("nutrients", MHColours.CYAN) { arrayOf(EffectInstance(Effects.ABSORPTION, 6000)) },
			consumable("mega_nutrients", MHColours.CYAN) { arrayOf(EffectInstance(Effects.ABSORPTION, 6000, 1)) },
			consumable("antidote", MHColours.BLUE) { arrayOf(EffectInstance(MHEffects.ANTIDOTE)) },
			consumable("immunizer", MHColours.YELLOW) { arrayOf(EffectInstance(Effects.REGENERATION, 1200, 0)) },
			consumable("dash_juice", MHColours.YELLOW) { arrayOf(EffectInstance(Effects.SATURATION, 0, 1)) },
			consumable("mega_dash_juice", MHColours.YELLOW) { arrayOf(EffectInstance(Effects.SATURATION, 0, 3)) },
			consumable("demondrug", MHColours.RED) { arrayOf(EffectInstance(Effects.STRENGTH, 6000, 1)) },
			consumable("mega_demondrug", MHColours.RED) { arrayOf(EffectInstance(Effects.STRENGTH, 6000, 3)) },
			consumable("might_pill", MHColours.RED) { arrayOf(EffectInstance(Effects.STRENGTH, 6000, 5)) },
			consumable("armorskin", MHColours.ORANGE) { arrayOf(EffectInstance(Effects.RESISTANCE, 6000, 1)) },
			consumable("mega_armorskin", MHColours.ORANGE) { arrayOf(EffectInstance(Effects.RESISTANCE, 6000, 3)) },
			consumable("adamant_pill", MHColours.ORANGE) { arrayOf(EffectInstance(Effects.RESISTANCE, 6000, 5)) },
			item("cool_drink", MHColours.WHITE), //some cooling effect
			item("hot_drink", MHColours.RED), //some warming effect
			item("cleanser", MHColours.CYAN), //same as milk
			item("psychoserum", MHColours.ORANGE), //somehow know where monsters are
			consumable("herbal_medicine", MHColours.WHITE) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH), EffectInstance(MHEffects.ANTIDOTE)) },
			consumable("max_potion", MHColours.YELLOW) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 4), EffectInstance(MHEffects.ANTIDOTE, 6000, 4)) },
			consumable("ancient_potion", MHColours.RED) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 4), EffectInstance(MHEffects.ANTIDOTE, 12000, 4), EffectInstance(Effects.SATURATION, 12000, 9)) },
			consumable("energy_drink", MHColours.YELLOW) { arrayOf(EffectInstance(Effects.SATURATION)) },
			item("lifepowder", MHColours.WHITE), //splash instant health 2
			consumable("dust_of_life", MHColours.GREEN) { arrayOf(EffectInstance(Effects.INSTANT_HEALTH, 0, 4)) },
			// Brewing Intermediates
			item("blue_mushroom_intermediary", MHColours.BLUE),
			item("bitterbug_intermediary", MHColours.BLUE),
			item("nitroshroom_intermediary", MHColours.RED),
			item("catalyst", MHColours.GREY),
			// Ores
			item("earth_crystal", MHColours.WHITE),
			item("machalite_ingot", MHColours.BLUE),
			item("ice_crystal", MHColours.CYAN),
			item("bealite_ingot", MHColours.CYAN),
			item("lightcrystal", MHColours.GREY),
			item("dragonite_ingot", MHColours.GREEN),
			item("firestone", MHColours.RED),
			item("allfire_stone", MHColours.RED),
			item("carbalite_ingot", MHColours.PURPLE),
			item("eltalite_ingot", MHColours.RED),
			item("meldspar_ingot", MHColours.WHITE),
			item("novacrystal", MHColours.WHITE),
			item("purecrystal", MHColours.WHITE),
			item("fucium_ingot", MHColours.PINK),
			item("firecell_stone", MHColours.RED),
			item("ultimas_crystal", MHColours.YELLOW),
			// Fish
			item("whetfish", MHColours.YELLOW),
			item("sushifish", MHColours.ORANGE),
			item("sleepyfish", MHColours.CYAN),
			item("pin_tuna", MHColours.GREY),
			item("speartuna", MHColours.BLUE),
			item("popfish", MHColours.GREY),
			item("scatterfish", MHColours.GREY),
			item("burst_arowana", MHColours.GREEN),
			item("bomb_arowana", MHColours.PURPLE),
			item("glutton_tuna", MHColours.ORANGE),
			item("gastronome_tuna", MHColours.ORANGE),
			item("ancient_fish", MHColours.WHITE),
			item("small_goldenfish", MHColours.YELLOW),
			item("wanchovy", MHColours.GREEN),
			item("guardfish", MHColours.DEEP_YELLOW),
			item("goldenfish", MHColours.YELLOW),
			item("silverfish", MHColours.WHITE),
			item("brocadefish", MHColours.BLUE),
			item("king_brocadefish", MHColours.BLUE),
			item("premium_sashimi", MHColours.WHITE),
			// Insects
			item("insect_husk", MHColours.GREY),
			item("godbug", MHColours.WHITE),
			item("bitterbug", MHColours.BLUE),
			item("flashbug", MHColours.YELLOW),
			item("thunderbug", MHColours.YELLOW),
			item("stinkhopper", MHColours.RED),
			item("snakebee_larva", MHColours.ORANGE),
			item("carpenterbug", MHColours.GREY),
			item("shiny_beetle", MHColours.GREEN),
			item("hercudrome", MHColours.RED),
			item("king_scarab", MHColours.PURPLE),
			item("rare_scarab", MHColours.YELLOW),
			item("emperor_hopper", MHColours.DEEP_YELLOW),
			item("flutterfly", MHColours.WHITE),
			item("stygian_worm", MHColours.GREY),
			// Bones
			item("small_monster_bone", MHColours.YELLOW),
			item("medium_monster_bone", MHColours.YELLOW),
			item("mystery_bone", MHColours.YELLOW),
			item("unknown_skull", MHColours.YELLOW),
			item("huge_unknown_skull", MHColours.YELLOW),
			// Neopteran
			item("monster_fluid", MHColours.CYAN),
			item("monster_broth", MHColours.BLUE),
			item("monster_essence", MHColours.BLUE),
			item("hornetaur_shell", MHColours.DARK_GREY),
			item("hornetaur_wing", MHColours.DARK_GREY),
			item("hornetaur_carapace", MHColours.DARK_GREY),
			item("hornetaur_head", MHColours.DARK_GREY),
			item("hornetaur_razorwing", MHColours.DARK_GREY),
			item("hornetaur_innerwing", MHColours.DARK_GREY),
			// Tools
			*tools("machalite", MHColours.BLUE, MHItemTier.MACHALITE),
			*tools("dragonite", MHColours.GREEN, MHItemTier.DRAGONITE),
			*tools("carbalite", MHColours.PURPLE, MHItemTier.CARBALITE),
			*tools("eltalite", MHColours.RED, MHItemTier.ELTALITE),
			// Spawn Eggs
			// Fish
			spawnEgg("sushifish_egg", 0xB07A4D, 0x734F32) { MHEntities.SUSHIFISH },
			spawnEgg("goldenfish_egg", 0xC8B235, 0x837422) { MHEntities.GOLDENFISH },
			// Neopterans
			spawnEgg("hornetaur_egg", 0xD7822C, 0x2D1D16) { MHEntities.HORNETAUR }
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

	private fun item(name: String, colour: Int): Item {
		val item = MHTintItem(props(MobHunter.GROUP_ITEMS), colour).setRegistryName(name)
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
