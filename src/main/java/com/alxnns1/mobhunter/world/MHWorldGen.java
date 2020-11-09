package com.alxnns1.mobhunter.world;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class MHWorldGen {

	private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> wetOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> coldOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<>();

	private static final ArrayList<ConfiguredFeature<?, ?>> overworldPlants = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> hotPlants = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> coldPlants = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> netherPlants = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> endPlants = new ArrayList<>();

	public static void registerOres() {
		overworldOres.add(register("earth_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("earth_crystal_ore").getDefaultState(), 16))
				.range(128).square().func_242731_b(12)));
		overworldOres.add(register("machalite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("machalite_ore").getDefaultState(), 8))
				.range(64).square().func_242731_b(15)));
		overworldOres.add(register("lightcrystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("lightcrystal_ore").getDefaultState(), 12))
				.range(64).square().func_242731_b(9)));
		overworldOres.add(register("dragonite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("dragonite_ore").getDefaultState(), 8))
				.range(64).square().func_242731_b(11)));
		overworldOres.add(register("carbalite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("carbalite_ore").getDefaultState(), 8))
				.range(32).square().func_242731_b(10)));
		overworldOres.add(register("novacrystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("novacrystal_ore").getDefaultState(), 12))
				.range(32).square().func_242731_b(8)));
		overworldOres.add(register("fucium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("fucium_ore").getDefaultState(), 8))
				.range(32).square().func_242731_b(7)));

		coldOres.add(register("ice_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("ice_crystal_ore").getDefaultState(), 16))
				.range(128).square().func_242731_b(15)));

		wetOres.add(register("bealite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MHBlocks.BLOCKS.get("bealite_ore").getDefaultState(), 8))
				.range(64).square().func_242731_b(9)));

		netherOres.add(register("firestone_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.NETHERRACK, MHBlocks.BLOCKS.get("firestone_ore").getDefaultState(), 8))
				.range(255).square().func_242731_b(12)));
		netherOres.add(register("firecell_stone_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.NETHERRACK, MHBlocks.BLOCKS.get("firecell_stone_ore").getDefaultState(), 8))
				.range(255).square().func_242731_b(19)));
		netherOres.add(register("allfire_stone_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.NETHERRACK, MHBlocks.BLOCKS.get("allfire_stone_ore").getDefaultState(), 8))
				.range(255).square().func_242731_b(3)));
		netherOres.add(register("ultimas_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.NETHERRACK, MHBlocks.BLOCKS.get("ultimas_crystal_ore").getDefaultState(), 8))
				.range(255).square().func_242731_b(3)));

		endOres.add(register("eltalite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				new BlockMatchRuleTest(Blocks.END_STONE), MHBlocks.BLOCKS.get("eltalite_ore").getDefaultState(), 8))
				.range(128).square().func_242731_b(6)));
		endOres.add(register("purecrystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				new BlockMatchRuleTest(Blocks.END_STONE), MHBlocks.BLOCKS.get("purecrystal_ore").getDefaultState(), 8))
				.range(128).square().func_242731_b(6)));
		endOres.add(register("meldspar_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				new BlockMatchRuleTest(Blocks.END_STONE), MHBlocks.BLOCKS.get("meldspar_ore").getDefaultState(), 8))
				.range(128).square().func_242731_b(4)));
	}

	public static void registerPlants() {
		int tries = 64;
		int spread = 2;
		overworldPlants.add(register("overworld_herbs", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("herb").getDefaultState(), 18)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("antidote_herb").getDefaultState(), 21)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("fire_herb").getDefaultState(), 16)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("ivy").getDefaultState(), 14)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("sleep_herb").getDefaultState(), 15)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("sap_plant").getDefaultState(), 9)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("felvine").getDefaultState(), 8),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));
		overworldPlants.add(register("overworld_mushrooms", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("blue_mushroom").getDefaultState(), 20)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("nitroshroom").getDefaultState(), 15)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("parashroom").getDefaultState(), 11)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("toadstool").getDefaultState(), 18)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("mopeshroom").getDefaultState(), 19)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("exciteshroom").getDefaultState(), 9)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("dragon_toadstool").getDefaultState(), 8),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));
		overworldPlants.add(register("overworld_berries", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("paintberry").getDefaultState(), 19)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("might_seed").getDefaultState(), 10)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("nulberry").getDefaultState(), 10)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("scatternut").getDefaultState(), 9)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("needleberry").getDefaultState(), 18)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("latchberry").getDefaultState(), 24)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("bomberry").getDefaultState(), 11),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));

		hotPlants.add(register("hot_herbs", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("hot_pepper").getDefaultState(), 45)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("fire_herb").getDefaultState(), 55),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));

		coldPlants.add(register("cold_herbs", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("snow_herb").getDefaultState(), 1),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));
		coldPlants.add(register("cold_berries", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("adamant_seed").getDefaultState(), 1),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));

		netherPlants.add(register("nether_herbs", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("fire_herb").getDefaultState(), 55)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("hot_pepper").getDefaultState(), 45),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));
		netherPlants.add(register("nether_berries", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("might_seed").getDefaultState(), 41)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("adamant_seed").getDefaultState(), 34)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("dragonfell_berry").getDefaultState(), 25),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));

		endPlants.add(register("end_herbs", Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider())
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("dragonvine").getDefaultState(), 72)
				.addWeightedBlockstate(MHBlocks.BLOCKS.get("tough_dragonvine").getDefaultState(), 28),
				SimpleBlockPlacer.PLACER).tries(tries).build())
				.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
				.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
				.func_242731_b(spread)));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void generate(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.NETHER) {
			for (ConfiguredFeature<?, ?> ore : netherOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
			for (ConfiguredFeature<?, ?> plant : netherPlants) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, plant);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.END ||
				BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.VOID) {
			for (ConfiguredFeature<?, ?> ore : endOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
			for (ConfiguredFeature<?, ?> plant : endPlants) {
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, plant);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.WET ||
				BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.OCEAN ||
				BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.RIVER) {
			for (ConfiguredFeature<?, ?> ore : wetOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.COLD ||
				BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.SNOWY) {
			for (ConfiguredFeature<?, ?> ore : coldOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
			for (ConfiguredFeature<?, ?> plant : coldPlants) {
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, plant);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.HOT ||
				event.getCategory() == Biome.Category.DESERT) {
			for (ConfiguredFeature<?, ?> plant : hotPlants) {
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, plant);
			}
		} else {
			for (ConfiguredFeature<?, ?> ore : overworldOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
			for (ConfiguredFeature<?, ?> plant : overworldPlants) {
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, plant);
			}
		}
	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MobHunter.MOD_ID + ":" + name, configuredFeature);
	}
}
