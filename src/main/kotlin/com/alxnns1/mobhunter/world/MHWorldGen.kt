package com.alxnns1.mobhunter.world

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.init.MHBlocks
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.WorldGenRegistries
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest
import net.minecraft.world.gen.feature.template.RuleTest
import net.minecraftforge.common.BiomeDictionary.Type.*
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
			ore(MHBlocks.EARTH_CRYSTAL_ORE, 128, 21),
			ore(MHBlocks.DRAGONITE_ORE, 32, 16),
			ore(MHBlocks.LIGHTCRYSTAL_ORE, 64, 13),
			ore(MHBlocks.MACHALITE_ORE, 64, 12),
			ore(MHBlocks.CARBALITE_ORE, 16, 7),
			ore(MHBlocks.NOVACRYSTAL_ORE, 32, 5),
			ore(MHBlocks.FUCIUM_ORE, 16, 4)
		)
		coldOres = listOf(
			ore(MHBlocks.ICE_CRYSTAL_ORE, 128, 28)
		)
		wetOres = listOf(
			ore(MHBlocks.BEALITE_ORE, 64, 15)
		)
		netherOres = listOf(
			ore(MHBlocks.FIRESTONE_ORE, 255, 20, OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER),
			ore(MHBlocks.FIRECELL_STONE_ORE, 255, 13, OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER),
			ore(MHBlocks.ALLFIRE_STONE_ORE, 255, 1, OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER),
			ore(MHBlocks.ULTIMAS_CRYSTAL_ORE, 255, 1, OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER)
		)
		endOres = listOf(
			ore(MHBlocks.ELTALITE_ORE, 128, 1, BlockMatchRuleTest(Blocks.END_STONE)),
			ore(MHBlocks.MELDSPAR_ORE, 128, 1, BlockMatchRuleTest(Blocks.END_STONE)),
			ore(MHBlocks.PURECRYSTAL_ORE, 128, 1, BlockMatchRuleTest(Blocks.END_STONE))
		)

		overworldPlants = listOf(
			plant("overworld_herbs",
				MHBlocks.ANTIDOTE_HERB to 21,
				MHBlocks.HERB to 18,
				MHBlocks.IVY to 16,
				MHBlocks.SAP_PLANT to 15,
				MHBlocks.SLEEP_HERB to 14,
				MHBlocks.FELVINE to 9,
				MHBlocks.GLOAMGRASS_ROOT to 8
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
		val type = fromVanilla(category)

		when (type) {
			NETHER -> {
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, netherOres)
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION, netherPlants)
			}
			END, VOID -> {
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, endOres)
				gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, endPlants)
			}
			else -> {
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, overworldOres)
				gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, overworldPlants)
			}
		}
		when {
			type == WET || type == OCEAN || type == RIVER -> {
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, wetOres)
			}
			type == COLD || type == SNOWY -> {
				gen.withFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, coldOres)
				gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, coldPlants)
			}
			type == HOT || category == Biome.Category.DESERT -> {
				gen.withFeatures(GenerationStage.Decoration.VEGETAL_DECORATION, hotPlants)
			}
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
		range: Int,
		spread: Int,
		replaces: RuleTest = OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
	): ConfiguredFeature<*, *> = register(
		block.registryName!!.path,
		Feature.ORE.withConfiguration(OreFeatureConfig(replaces, block.defaultState, 8))
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
			).tries(32).build())
			.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
			.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
			.func_242731_b(2) // spread
	)
}
