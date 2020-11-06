package com.alxnns1.mobhunter.init;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.HashMap;

public class MHBlocks {

	public static final HashMap<String, Block> BLOCKS = new HashMap<>();

	public static Block[] register() {
		//ORES
		registerOreBlock("earth_crystal_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerOreBlock("machalite_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerOreBlock("ice_crystal_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerOreBlock("bealite_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerOreBlock("lightcrystal_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F).setLightLevel(s -> 7));
		registerOreBlock("dragonite_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerOreBlock("firestone_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerOreBlock("carbalite_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 2, 3F, 3F));
		registerOreBlock("eltalite_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerOreBlock("meldspar_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerOreBlock("novacrystal_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 2, 3F, 3F).setLightLevel(s -> 14));
		registerOreBlock("purecrystal_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerOreBlock("fucium_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 2, 3F, 3F));
		registerOreBlock("firecell_stone_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 2, 3F, 3F));
		registerOreBlock("allfire_stone_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerOreBlock("ultimas_crystal_ore", properties(Material.ROCK, true, ToolType.PICKAXE, 3, 3F, 3F));
		//COMPACT BLOCKS
		registerBlock("earth_crystal_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerBlock("machalite_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerBlock("ice_crystal_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerBlock("bealite_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerBlock("lightcrystal_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F).setLightLevel(s -> 7));
		registerBlock("dragonite_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerBlock("firestone_block", properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F));
		registerBlock("carbalite_block", properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F));
		registerBlock("eltalite_block", properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerBlock("meldspar_block", properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerBlock("novacrystal_block", properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F).setLightLevel(s -> 14));
		registerBlock("purecrystal_block", properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerBlock("fucium_block", properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F));
		registerBlock("firecell_stone_block", properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F));
		registerBlock("allfire_stone_block", properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F));
		registerBlock("ultimas_crystal_block", properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F));

		return BLOCKS.values().toArray(new Block[0]);
	}

	private static Block.Properties properties(Material material, boolean requiresTool, ToolType toolType, int harvestLevel, float hardness, float resistance) {
		Block.Properties properties = Block.Properties.create(material).harvestTool(toolType).harvestLevel(harvestLevel).hardnessAndResistance(hardness, resistance);
		if (requiresTool) {
			properties.setRequiresTool();
		}
		return properties;
	}

	private static void registerBlock(String name, Block.Properties properties) {
		Block block = new Block(properties).setRegistryName(name);
		BLOCKS.put(name, block);
	}

	private static void registerOreBlock(String name, Block.Properties properties) {
		Block block = new OreBlock(properties).setRegistryName(name);
		BLOCKS.put(name, block);
	}
}
