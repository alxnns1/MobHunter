package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.block.MHPlant
import net.minecraft.block.AbstractBlock.Properties
import net.minecraft.block.Block
import net.minecraft.block.OreBlock
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.RenderTypeLookup
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.client.event.ColorHandlerEvent
import net.minecraftforge.common.ToolType
import net.minecraftforge.event.RegistryEvent
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHBlocks {
	val BLOCKS = mutableListOf<Block>()
	private val PLANTS = mutableListOf<MHPlant>()

	// Herbs
	val HERB: Block by objectHolder("herb")
	val ANTIDOTE_HERB: Block by objectHolder("antidote_herb")
	val FIRE_HERB: Block by objectHolder("fire_herb")
	val IVY: Block by objectHolder("ivy")
	val SLEEP_HERB: Block by objectHolder("sleep_herb")
	val SAP_PLANT: Block by objectHolder("sap_plant")
	val FELVINE: Block by objectHolder("felvine")
	val GLOAMGRASS_ROOT: Block by objectHolder("gloamgrass_root")
	val HOT_PEPPER: Block by objectHolder("hot_pepper")
	val SNOW_HERB: Block by objectHolder("snow_herb")
	val DRAGONVINE: Block by objectHolder("dragonvine")
	val TOUGH_DRAGONVINE: Block by objectHolder("tough_dragonvine")

	// Mushrooms
	val BLUE_MUSHROOM: Block by objectHolder("blue_mushroom")
	val NITROSHROOM: Block by objectHolder("nitroshroom")
	val PARASHROOM: Block by objectHolder("parashroom")
	val TOADSTOOL: Block by objectHolder("toadstool")
	val MOPESHROOM: Block by objectHolder("mopeshroom")
	val EXCITESHROOM: Block by objectHolder("exciteshroom")
	val DRAGON_TOADSTOOL: Block by objectHolder("dragon_toadstool")

	// Berries
	val PAINTBERRY: Block by objectHolder("paintberry")
	val MIGHT_SEED: Block by objectHolder("might_seed")
	val ADAMANT_SEED: Block by objectHolder("adamant_seed")
	val NULBERRY: Block by objectHolder("nulberry")
	val DRAGONFELL_BERRY: Block by objectHolder("dragonfell_berry")
	val SCATTERNUT: Block by objectHolder("scatternut")
	val NEEDLEBERRY: Block by objectHolder("needleberry")
	val LATCHBERRY: Block by objectHolder("latchberry")
	val BOMBERRY: Block by objectHolder("bomberry")

	// Ores
	val EARTH_CRYSTAL_ORE: Block by objectHolder("earth_crystal_ore")
	val MACHALITE_ORE: Block by objectHolder("machalite_ore")
	val ICE_CRYSTAL_ORE: Block by objectHolder("ice_crystal_ore")
	val BEALITE_ORE: Block by objectHolder("bealite_ore")
	val LIGHTCRYSTAL_ORE: Block by objectHolder("lightcrystal_ore")
	val DRAGONITE_ORE: Block by objectHolder("dragonite_ore")
	val FIRESTONE_ORE: Block by objectHolder("firestone_ore")
	val ALLFIRE_STONE_ORE: Block by objectHolder("allfire_stone_ore")
	val CARBALITE_ORE: Block by objectHolder("carbalite_ore")
	val ELTALITE_ORE: Block by objectHolder("eltalite_ore")
	val MELDSPAR_ORE: Block by objectHolder("meldspar_ore")
	val NOVACRYSTAL_ORE: Block by objectHolder("novacrystal_ore")
	val PURECRYSTAL_ORE: Block by objectHolder("purecrystal_ore")
	val FUCIUM_ORE: Block by objectHolder("fucium_ore")
	val FIRECELL_STONE_ORE: Block by objectHolder("firecell_stone_ore")
	val ULTIMAS_CRYSTAL_ORE: Block by objectHolder("ultimas_crystal_ore")

	// Compact Blocks
	val MACHALITE_BLOCK: Block by objectHolder("machalite_block")

	fun register(event: RegistryEvent.Register<Block>) {
		event.registry.registerAll(
			// Herbs
			plant("herb", GREEN),
			plant("antidote_herb", BLUE),
			plant("fire_herb", RED),
			plant("ivy", GREEN),
			plant("sleep_herb", CYAN),
			plant("sap_plant", WHITE),
			plant("felvine", YELLOW),
			plant("gloamgrass_root", PINK),
			plant("hot_pepper", RED),
			plant("snow_herb", BLUE),
			plant("dragonvine", PURPLE),
			plant("tough_dragonvine", PURPLE),
			// Mushrooms
			plant("blue_mushroom", BLUE),
			plant("nitroshroom", RED),
			plant("parashroom", YELLOW),
			plant("toadstool", PURPLE),
			plant("mopeshroom", CYAN),
			plant("exciteshroom", PURPLE),
			plant("dragon_toadstool", RED),
			plant("unique_mushroom", WHITE),
			plant("choice_mushroom", WHITE),
			// Berries
			plant("paintberry", PINK),
			plant("might_seed", RED),
			plant("adamant_seed", ORANGE),
			plant("nulberry", BLUE),
			plant("dragonfell_berry", RED),
			plant("scatternut", GREY),
			plant("needleberry", GREY),
			plant("latchberry", CYAN),
			plant("bomberry", GREY),
			// Ores
			oreBlock("earth_crystal_ore"),
			oreBlock("machalite_ore"),
			oreBlock("ice_crystal_ore"),
			oreBlock("bealite_ore"),
			oreBlock("lightcrystal_ore", rockProps().setLightLevel { 7 }),
			oreBlock("dragonite_ore"),
			oreBlock("firestone_ore"),
			oreBlock("allfire_stone_ore", rockProps(harvestLevel = 3)),
			oreBlock("carbalite_ore", rockProps(harvestLevel = 2)),
			oreBlock("eltalite_ore", rockProps(harvestLevel = 3)),
			oreBlock("meldspar_ore", rockProps(harvestLevel = 3)),
			oreBlock("novacrystal_ore", rockProps(harvestLevel = 2).setLightLevel { 14 }),
			oreBlock("purecrystal_ore", rockProps(harvestLevel = 3)),
			oreBlock("fucium_ore", rockProps(harvestLevel = 2)),
			oreBlock("firecell_stone_ore", rockProps(harvestLevel = 2)),
			oreBlock("ultimas_crystal_ore", rockProps(harvestLevel = 3)),
			// Compact Blocks
			block("earth_crystal_block", rockProps(material = Material.IRON)),
			block("machalite_block", rockProps(material = Material.IRON)),
			block("ice_crystal_block", rockProps(material = Material.IRON)),
			block("bealite_block", rockProps(material = Material.IRON)),
			block("lightcrystal_block", rockProps(material = Material.IRON).setLightLevel { 7 }),
			block("dragonite_block", rockProps(material = Material.IRON)),
			block("firestone_block", rockProps(material = Material.IRON)),
			block("allfire_stone_block", rockProps(material = Material.IRON, harvestLevel = 3)),
			block("carbalite_block", rockProps(material = Material.IRON, harvestLevel = 2)),
			block("eltalite_block", rockProps(material = Material.IRON, harvestLevel = 3)),
			block("meldspar_block", rockProps(material = Material.IRON, harvestLevel = 3)),
			block("novacrystal_block", rockProps(material = Material.IRON, harvestLevel = 2).setLightLevel { 14 }),
			block("purecrystal_block", rockProps(material = Material.IRON, harvestLevel = 3)),
			block("fucium_block", rockProps(material = Material.IRON, harvestLevel = 2)),
			block("firecell_stone_block", rockProps(material = Material.IRON, harvestLevel = 2)),
			block("ultimas_crystal_block", rockProps(material = Material.IRON, harvestLevel = 3))
		)
	}

	@OnlyIn(Dist.CLIENT)
	fun setRenderLayers(): Unit = PLANTS.forEach { RenderTypeLookup.setRenderLayer(it, RenderType.getCutoutMipped()) }

	@OnlyIn(Dist.CLIENT)
	fun registerBlockColours(event: ColorHandlerEvent.Block) {
		event.blockColors.register(
			{ state, _, _, _ -> state.block.let { if (it is MHPlant) it.colour else -1 } },
			*PLANTS.toTypedArray()
		)
	}

	private fun plantProps(): Properties = Properties.create(Material.PLANTS)
		.doesNotBlockMovement()
		.zeroHardnessAndResistance()
		.sound(SoundType.PLANT)

	private fun rockProps(
		material: Material = Material.ROCK,
		harvestLevel: Int = 1,
		hardness: Float = 3F,
		resistance: Float = 3F
	): Properties = Properties.create(material)
		.setRequiresTool()
		.harvestTool(ToolType.PICKAXE)
		.harvestLevel(harvestLevel)
		.hardnessAndResistance(hardness, resistance)

	private fun plant(name: String, colour: Int, props: Properties = plantProps()): Block =
		MHPlant(colour, props).also {
			it.setRegistryName(name)
			BLOCKS += it
			PLANTS += it
		}

	private fun block(name: String, props: Properties = rockProps()): Block = Block(props).also {
		it.setRegistryName(name)
		BLOCKS += it
	}

	private fun oreBlock(name: String, props: Properties = rockProps()): Block = OreBlock(props).also {
		it.setRegistryName(name)
		BLOCKS += it
	}
}
