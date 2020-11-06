package com.alxnns1.mobhunter.init;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.HashMap;

public class MHBlocks {

	public static final HashMap<String, Block> BLOCKS = new HashMap<String, Block>() {{
		//ORES
		put("earth_crystal_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("earth_crystal_ore"));
		put("machalite_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("machalite_ore"));
		put("ice_crystal_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("ice_crystal_ore"));
		put("bealite_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("bealite_ore"));
		put("lightcrystal_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F).setLightLevel(s -> 7)).setRegistryName("lightcrystal_ore"));
		put("dragonite_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("dragonite_ore"));
		put("firestone_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("firestone_ore"));
		put("carbalite_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("carbalite_ore"));
		put("eltalite_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("eltalite_ore"));
		put("meldspar_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("meldspar_ore"));
		put("novacrystal_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F).setLightLevel(s -> 14)).setRegistryName("novacrystal_ore"));
		put("purecrystal_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("purecrystal_ore"));
		put("fucium_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("fucium_ore"));
		put("firecell_stone_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("firecell_stone_ore"));
		put("allfire_stone_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("allfire_stone_ore"));
		put("ultimas_crystal_ore", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("ultimas_crystal_ore"));
		//ORE BLOCKS
		put("earth_crystal_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("earth_crystal_block"));
		put("machalite_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("machalite_block"));
		put("ice_crystal_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("ice_crystal_block"));
		put("bealite_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("bealite_block"));
		put("lightcrystal_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F).setLightLevel(s -> 7)).setRegistryName("lightcrystal_block"));
		put("dragonite_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("dragonite_block"));
		put("firestone_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("firestone_block"));
		put("carbalite_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("carbalite_block"));
		put("eltalite_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("eltalite_block"));
		put("meldspar_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("meldspar_block"));
		put("novacrystal_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F).setLightLevel(s -> 14)).setRegistryName("novacrystal_block"));
		put("purecrystal_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("purecrystal_block"));
		put("fucium_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("fucium_block"));
		put("firecell_stone_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("firecell_stone_block"));
		put("allfire_stone_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("allfire_stone_block"));
		put("ultimas_crystal_block", new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("ultimas_crystal_block"));
	}};

	private static Block.Properties properties(Material material, boolean requiresTool, ToolType toolType, int harvestLevel, float hardness, float resistance) {
		Block.Properties properties = Block.Properties.create(material).harvestTool(toolType).harvestLevel(harvestLevel).hardnessAndResistance(hardness, resistance);
		if (requiresTool) {
			properties.setRequiresTool();
		}
		return properties;
	}
}
