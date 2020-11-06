package com.alxnns1.mobhunter.world;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class MHOreGen {

	private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> wetOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> coldOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<>();
	private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<>();

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

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void generate(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.NETHER) {
			for (ConfiguredFeature<?, ?> ore: netherOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.END) {
			for (ConfiguredFeature<?, ?> ore: endOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.OCEAN ||
				BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.RIVER) {
			for (ConfiguredFeature<?, ?> ore: wetOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		} else if (BiomeDictionary.Type.fromVanilla(event.getCategory()) == BiomeDictionary.Type.SNOWY) {
			for (ConfiguredFeature<?, ?> ore: coldOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		} else {
			for (ConfiguredFeature<?, ?> ore: overworldOres) {
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		}
	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MobHunter.MOD_ID + ":" + name, configuredFeature);
	}
}
