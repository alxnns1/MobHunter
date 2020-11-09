package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.blocks.MHPlant;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.ToolType;

import java.util.HashMap;

public class MHBlocks {

	public static final HashMap<String, Block> BLOCKS = new HashMap<>();
	private static final HashMap<Block, Integer> PLANT_BLOCKS = new HashMap<>();

	public static Block[] register() {
		//HERBS
		registerPlantBlock("herb", MHColours.GREEN);
		registerPlantBlock("antidote_herb", MHColours.BLUE);
		registerPlantBlock("fire_herb", MHColours.RED);
		registerPlantBlock("ivy", MHColours.GREEN);
		registerPlantBlock("sleep_herb", MHColours.LIGHT_BLUE);
		registerPlantBlock("sap_plant", MHColours.WHITE);
		registerPlantBlock("felvine", MHColours.YELLOW);
		registerPlantBlock("gloamgrass_root", MHColours.PINK);
		registerPlantBlock("hot_pepper", MHColours.RED);
		registerPlantBlock("snow_herb", MHColours.LIGHT_BLUE);
		registerPlantBlock("dragonvine", MHColours.PURPLE);
		registerPlantBlock("tough_dragonvine", MHColours.PURPLE);
		//MUSHROOMS
		registerPlantBlock("blue_mushroom", MHColours.BLUE);
		registerPlantBlock("nitroshroom", MHColours.ORANGE);
		registerPlantBlock("parashroom", MHColours.YELLOW);
		registerPlantBlock("toadstool", MHColours.PURPLE);
		registerPlantBlock("mopeshroom", MHColours.LIGHT_BLUE);
		registerPlantBlock("exciteshroom", MHColours.GREEN);
		registerPlantBlock("dragon_toadstool", MHColours.RED);
		//BERRIES
		registerPlantBlock("paintberry", MHColours.PINK);
		registerPlantBlock("might_seed", MHColours.RED);
		registerPlantBlock("adamant_seed", MHColours.ORANGE);
		registerPlantBlock("nulberry", MHColours.BLUE);
		registerPlantBlock("dragonfell_berry", MHColours.RED);
		registerPlantBlock("scatternut", MHColours.GREY);
		registerPlantBlock("needleberry", MHColours.GREY);
		registerPlantBlock("latchberry", MHColours.WHITE);
		registerPlantBlock("bomberry", MHColours.GREY);
		//ORES
		registerOreBlock("earth_crystal_ore", properties(Material.ROCK, 1));
		registerOreBlock("machalite_ore", properties(Material.ROCK, 1));
		registerOreBlock("ice_crystal_ore", properties(Material.ROCK, 1));
		registerOreBlock("bealite_ore", properties(Material.ROCK, 1));
		registerOreBlock("lightcrystal_ore", properties(Material.ROCK, 1).setLightLevel(state -> 7));
		registerOreBlock("dragonite_ore", properties(Material.ROCK, 1));
		registerOreBlock("firestone_ore", properties(Material.ROCK, 1));
		registerOreBlock("carbalite_ore", properties(Material.ROCK, 2));
		registerOreBlock("eltalite_ore", properties(Material.ROCK, 3));
		registerOreBlock("meldspar_ore", properties(Material.ROCK, 3));
		registerOreBlock("novacrystal_ore", properties(Material.ROCK, 2).setLightLevel(state -> 14));
		registerOreBlock("purecrystal_ore", properties(Material.ROCK, 3));
		registerOreBlock("fucium_ore", properties(Material.ROCK, 2));
		registerOreBlock("firecell_stone_ore", properties(Material.ROCK, 2));
		registerOreBlock("allfire_stone_ore", properties(Material.ROCK, 3));
		registerOreBlock("ultimas_crystal_ore", properties(Material.ROCK, 3));
		//COMPACT BLOCKS
		registerBlock("earth_crystal_block", properties(Material.IRON, 1));
		registerBlock("machalite_block", properties(Material.IRON, 1));
		registerBlock("ice_crystal_block", properties(Material.IRON, 1));
		registerBlock("bealite_block", properties(Material.IRON, 1));
		registerBlock("lightcrystal_block", properties(Material.IRON, 1).setLightLevel(state -> 7));
		registerBlock("dragonite_block", properties(Material.IRON, 1));
		registerBlock("firestone_block", properties(Material.IRON, 1));
		registerBlock("carbalite_block", properties(Material.IRON, 2));
		registerBlock("eltalite_block", properties(Material.IRON, 3));
		registerBlock("meldspar_block", properties(Material.IRON, 3));
		registerBlock("novacrystal_block", properties(Material.IRON, 2).setLightLevel(state -> 14));
		registerBlock("purecrystal_block", properties(Material.IRON, 3));
		registerBlock("fucium_block", properties(Material.IRON, 2));
		registerBlock("firecell_stone_block", properties(Material.IRON, 2));
		registerBlock("allfire_stone_block", properties(Material.IRON, 3));
		registerBlock("ultimas_crystal_block", properties(Material.IRON, 3));

		return BLOCKS.values().toArray(new Block[0]);
	}

	public static void setRenderLayerForPlants() {
		PLANT_BLOCKS.keySet().forEach(block -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped()));
	}

	public static void setColourForPlants(ColorHandlerEvent.Block event) {
		PLANT_BLOCKS.forEach((block, colour) -> event.getBlockColors().register((blockStateIn, lightReaderIn, blockPosIn, tintIndexIn) -> colour, block));
	}

	private static AbstractBlock.Properties properties(Material material, int harvestLevel) {
		return Block.Properties.create(material).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(harvestLevel).hardnessAndResistance(3F, 3F);
	}

	private static void registerBlock(String name, Block.Properties properties) {
		Block block = new Block(properties).setRegistryName(name);
		BLOCKS.put(name, block);
	}

	private static void registerOreBlock(String name, Block.Properties properties) {
		Block block = new OreBlock(properties).setRegistryName(name);
		BLOCKS.put(name, block);
	}

	private static void registerPlantBlock(String name, int colour) {
		Block.Properties properties = Block.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT);
		Block block = new MHPlant(properties).setRegistryName(name);
		BLOCKS.put(name, block);
		PLANT_BLOCKS.put(block, colour);
	}
}
