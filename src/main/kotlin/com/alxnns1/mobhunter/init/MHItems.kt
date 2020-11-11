package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.item.MHSpawnEggItem
import net.minecraft.block.Block
import net.minecraft.entity.EntityType
import net.minecraft.item.*
import net.minecraftforge.event.RegistryEvent
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHItems {
	// Icons
	val ICON_ITEMS: Item by objectHolder("icon_items")
	val ICON_TOOLS: Item by objectHolder("icon_tools")

	// Ores
	val MACHALITE_INGOT: Item by objectHolder("machalite_ingot")
	val DRAGONITE_INGOT: Item by objectHolder("dragonite_ingot")
	val CARBALITE_INGOT: Item by objectHolder("carbalite_ingot")
	val ELTALITE_INGOT: Item by objectHolder("eltalite_ingot")

	// Spawn Eggs
	val GOLDENFISH_EGG: Item by objectHolder("goldenfish_egg")

	fun register(event: RegistryEvent.Register<Item>) {
		val registry = event.registry
		registry.registerAll(
			// Icons
			icon("icon_items"),
			icon("icon_tools"),
			// Ores
			item("earth_crystal"),
			item("machalite_ingot"),
			item("ice_crystal"),
			item("bealite_ingot"),
			item("lightcrystal"),
			item("dragonite_ingot"),
			item("firestone"),
			item("carbalite_ingot"),
			item("eltalite_ingot"),
			item("meldspar_ingot"),
			item("novacrystal"),
			item("purecrystal"),
			item("fucium_ingot"),
			item("firecell_stone"),
			item("allfire_stone"),
			item("ultimas_crystal"),
			// Fish
			item("whetfish"),
			item("sushifish"),
			item("sleepyfish"),
			item("pin_tuna"),
			item("speartuna"),
			item("popfish"),
			item("scatterfish"),
			item("burst_arowana"),
			item("bomb_arowana"),
			item("glutton_tuna"),
			item("gastronome_tuna"),
			item("ancient_fish"),
			item("small_goldenfish"),
			item("wanchovy"),
			item("guardfish"),
			item("brocadefish"),
			item("goldenfish"),
			item("king_brocadefish"),
			item("premium_sashimi"),
			item("silverfish"),
			//Neopteran
			item("hornetaur_shell"),
			item("hornetaur_wing"),
			item("hornetaur_carapace"),
			item("hornetaur_head"),
			item("monster_fluid"),
			item("hornetaur_razorwing"),
			item("monster_broth"),
			item("hornetaur_innerwing"),
			item("monster_essence"),
			// Tools
			*tools("machalite", MHItemTier.MACHALITE),
			*tools("dragonite", MHItemTier.DRAGONITE),
			*tools("carbalite", MHItemTier.CARBALITE),
			*tools("eltalite", MHItemTier.ELTALITE),

			// Spawn Eggs

			// Fish
			spawnegg("sushifish_egg", 0xB07A4D, 0x734F32) { MHEntities.SUSHIFISH },
			spawnegg("goldenfish_egg", 0xC8B235, 0x837422) { MHEntities.GOLDENFISH },
			// Neopterans
			spawnegg("hornetaur_egg", 0x40807B, 0xE65B00) { MHEntities.HORNETAUR }
		)

		// Item Blocks
		MHBlocks.BLOCKS.forEach { registry.register(block(it)) }
	}

	private fun props(group: ItemGroup? = null): Item.Properties =
		Item.Properties().apply { group?.let { group(it) } }

	private fun icon(name: String): Item = Item(props()).setRegistryName(name)

	private fun item(name: String): Item = Item(props(MobHunter.GROUP_ITEMS)).setRegistryName(name)

	private fun pickaxe(name: String, tier: IItemTier): Item =
		PickaxeItem(tier, 1, -2.8F, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)

	private fun axe(name: String, tier: IItemTier): Item =
		AxeItem(tier, 6F, -3.1F, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)

	private fun shovel(name: String, tier: IItemTier): Item =
		ShovelItem(tier, 1.5F, -3F, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)

	private fun hoe(name: String, tier: IItemTier): Item =
		HoeItem(tier, 3, 0F, props(MobHunter.GROUP_TOOLS)).setRegistryName(name)

	private fun tools(materialName: String, tier: IItemTier): Array<Item> = arrayOf(
		pickaxe("${materialName}_pickaxe", tier),
		axe("${materialName}_axe", tier),
		shovel("${materialName}_shovel", tier),
		hoe("${materialName}_hoe", tier)
	)

	private fun block(block: Block): Item =
		BlockItem(block, props(MobHunter.GROUP_BLOCKS)).setRegistryName(block.registryName)

	private fun spawnegg(
		name: String,
		primaryColour: Int,
		secondaryColour: Int,
		entityTypeSupplier: () -> EntityType<*>
	): Item = MHSpawnEggItem(entityTypeSupplier, primaryColour, secondaryColour, props(MobHunter.GROUP_ENTITIES)).setRegistryName(name)
}
