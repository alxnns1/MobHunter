package com.alxnns1.mobhunter.world

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.init.MHBlocks
import net.minecraft.block.Block
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.WorldGenRegistries
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.template.RuleTest
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder
import net.minecraftforge.event.world.BiomeLoadingEvent

object MHWorldGen {
	lateinit var overworldOres: List<ConfiguredFeature<*, *>>
	lateinit var wetOres: List<ConfiguredFeature<*, *>>
	lateinit var coldOres: List<ConfiguredFeature<*, *>>
	lateinit var netherOres: List<ConfiguredFeature<*, *>>
	lateinit var endOres: List<ConfiguredFeature<*, *>>

	lateinit var overworldPlants: List<ConfiguredFeature<*, *>>
	lateinit var hotPlants: List<ConfiguredFeature<*, *>>
	lateinit var coldPlants: List<ConfiguredFeature<*, *>>
	lateinit var netherPlants: List<ConfiguredFeature<*, *>>
	lateinit var endPlants: List<ConfiguredFeature<*, *>>

	fun register() {
		overworldOres = listOf(
			ore(MHBlocks.EARTH_CRYSTAL_ORE, 16, 128, 12),
			ore(MHBlocks.MACHALITE_ORE, 8, 64, 15),
			ore(MHBlocks.LIGHTCRYSTAL_ORE, 12, 64, 9),
			ore(MHBlocks.DRAGONITE_ORE, 8, 64, 11),
			ore(MHBlocks.CARBALITE_ORE, 8, 32, 10),
			ore(MHBlocks.NOVACRYSTAL_ORE, 12, 32, 8),
			ore(MHBlocks.FUCIUM_ORE, 8, 32, 7)
		)
		coldOres = listOf(
			ore(MHBlocks.ICE_CRYSTAL_ORE, 16, 128, 15)
		)
		wetOres = listOf(
			ore(MHBlocks.BEALITE_ORE, 8, 64, 9)
		)
		netherOres = listOf(
			ore(MHBlocks.FIRESTONE_ORE, 8, 255, 12),
			ore(MHBlocks.FIRECELL_STONE_ORE, 8, 255, 19),
			ore(MHBlocks.ALLFIRE_STONE_ORE, 8, 255, 3),
			ore(MHBlocks.ULTIMAS_CRYSTAL_ORE, 8, 255, 3)
		)
		endOres = listOf(
			ore(MHBlocks.ELTALITE_ORE, 8, 128, 6),
			ore(MHBlocks.MELDSPAR_ORE, 8, 128, 4),
			ore(MHBlocks.PURECRYSTAL_ORE, 8, 128, 6)
		)

		overworldPlants = listOf(
			plant("overworld_herbs",
				MHBlocks.HERB to 18,
				MHBlocks.ANTIDOTE_HERB to 21,
				MHBlocks.FIRE_HERB to 16,
				MHBlocks.IVY to 14,
				MHBlocks.SLEEP_HERB to 15,
				MHBlocks.SAP_PLANT to 9,
				MHBlocks.FELVINE to 8
			),
			plant("overworld_mushrooms",
				MHBlocks.BLUE_MUSHROOM to 20,
				MHBlocks.NITROSHROOM to 15,
				MHBlocks.PARASHROOM to 11,
				MHBlocks.TOADSTOOL to 18,
				MHBlocks.MOPESHROOM to 19,
				MHBlocks.EXCITESHROOM to 9,
				MHBlocks.DRAGON_TOADSTOOL to 8
			),
			plant("overworld_berries",
				MHBlocks.PAINTBERRY to 19,
				MHBlocks.MIGHT_SEED to 10,
				MHBlocks.NULBERRY to 10,
				MHBlocks.SCATTERNUT to 9,
				MHBlocks.NEEDLEBERRY to 18,
				MHBlocks.LATCHBERRY to 24,
				MHBlocks.BOMBERRY to 11
			)
		)
		hotPlants = listOf(
			plant("hot_herbs",
				MHBlocks.HOT_PEPPER to 45,
				MHBlocks.FIRE_HERB to 55
			)
		)
		coldPlants = listOf(
			plant("cold_herbs",
				MHBlocks.SNOW_HERB to 1
			),
			plant("cold_berries",
				MHBlocks.ADAMANT_SEED to 1
			)
		)
		netherPlants = listOf(
			plant("nether_herbs",
				MHBlocks.HOT_PEPPER to 45,
				MHBlocks.FIRE_HERB to 55
			),
			plant("nether_berries",
				MHBlocks.MIGHT_SEED to 41,
				MHBlocks.ADAMANT_SEED to 34,
				MHBlocks.DRAGONFELL_BERRY to 25
			)
		)
		endPlants = listOf(
			plant("end_herbs",
				MHBlocks.DRAGONVINE to 72,
				MHBlocks.TOUGH_DRAGONVINE to 28
			)
		)
	}

	fun generate(event: BiomeLoadingEvent) {
		val gen = event.generation
		val category = event.category
		val type = BiomeDictionary.Type.fromVanilla(category)

		// Ores
		gen.withFeatures(
			GenerationStage.Decoration.UNDERGROUND_ORES,
			when (type) {
				BiomeDictionary.Type.NETHER -> netherOres
				BiomeDictionary.Type.END, BiomeDictionary.Type.VOID -> endOres
				BiomeDictionary.Type.WET, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.RIVER -> wetOres
				BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY -> coldOres
				else -> overworldOres
			}
		)

		// Plants
		when {
			type == BiomeDictionary.Type.NETHER ->
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION, netherPlants)
			type == BiomeDictionary.Type.END || type == BiomeDictionary.Type.VOID ->
				gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, endPlants)
			type == BiomeDictionary.Type.HOT || category == Biome.Category.DESERT ->
				gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, hotPlants)
			else -> gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, overworldPlants)
		}
	}

	private fun BiomeGenerationSettingsBuilder.withFeatures(
		stage: GenerationStage.Decoration,
		features: List<ConfiguredFeature<*, *>>
	): Unit = features.forEach { withFeature(stage, it) }

	private fun <T : IFeatureConfig> register(name: String, feature: ConfiguredFeature<T, *>): ConfiguredFeature<T, *> =
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ResourceLocation(MobHunter.MOD_ID, name), feature)

	private fun ore(
		block: Block,
		veinSize: Int,
		range: Int,
		spread: Int,
		replaces: RuleTest = OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
	): ConfiguredFeature<*, *> = register(
		block.registryName!!.path,
		Feature.ORE.withConfiguration(OreFeatureConfig(replaces, block.defaultState, veinSize))
			.range(range).square().func_242731_b(spread)
	)

	private fun plant(
		name: String,
		vararg weightedBlocks: Pair<Block, Int>
	): ConfiguredFeature<*, *> = register(
		name,
		Feature.FLOWER
			.withConfiguration(BlockClusterFeatureConfig.Builder(
				WeightedBlockStateProvider().apply {
					weightedBlocks.forEach { addWeightedBlockstate(it.first.defaultState, it.second) }
				},
				SimpleBlockPlacer.PLACER
			).tries(64).build())
			.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
			.func_242731_b(2) // spread
	)
}
