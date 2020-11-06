package com.alxnns1.mobhunter.init;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModBlocks {

	public static final Block[] BLOCKS = new Block[]{
			//ORES
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("earth_crystal_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("machalite_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("ice_crystal_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("bealite_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F).setLightLevel(s -> 7)).setRegistryName("lightcrystal_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("dragonite_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("firestone_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("carbalite_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("eltalite_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("meldspar_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F).setLightLevel(s -> 14)).setRegistryName("novacrystal_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("purecrystal_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("fucium_ore"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("firecell_stone_ore"),
			//ORE BLOCKS
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("earth_crystal_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("machalite_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("ice_crystal_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("bealite_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F).setLightLevel(s -> 7)).setRegistryName("lightcrystal_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("dragonite_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 1, 3F, 3F)).setRegistryName("firestone_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("carbalite_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("eltalite_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("meldspar_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F).setLightLevel(s -> 14)).setRegistryName("novacrystal_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 3, 3F, 3F)).setRegistryName("purecrystal_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("fucium_block"),
			new OreBlock(properties(Material.IRON, true, ToolType.PICKAXE, 2, 3F, 3F)).setRegistryName("firecell_stone_block")
	};

	private static Block.Properties properties(Material material, boolean requiresTool, ToolType toolType, int harvestLevel, float hardness, float resistance) {
		Block.Properties properties = Block.Properties.create(material).harvestTool(toolType).harvestLevel(harvestLevel).hardnessAndResistance(hardness, resistance);
		if (requiresTool) {
			properties.setRequiresTool();
		}
		return properties;
	}
}
