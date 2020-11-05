package com.example.examplemod;

import com.example.examplemod.entities.GoldenfishEntity;
import com.example.examplemod.entities.SushifishEntity;
import com.example.examplemod.init.ModBlocks;
import com.example.examplemod.init.ModEntities;
import com.example.examplemod.init.ModItemGroups;
import com.example.examplemod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Arrays;
import java.util.Objects;

import static com.example.examplemod.MobHunter.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
		final IForgeRegistry<Item> registry = itemRegistryEvent.getRegistry();
		Arrays.stream(ModBlocks.BLOCKS).sequential()
				.forEach(block -> registry.register(new BlockItem(block, new Item.Properties()
						.group(ModItemGroups.MOB_HUNTER_BLOCKS_ITEM_GROUP))
						.setRegistryName(Objects.requireNonNull(block.getRegistryName()))));
		itemRegistryEvent.getRegistry().registerAll(ModItems.register());
	}

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		blockRegistryEvent.getRegistry().registerAll(ModBlocks.BLOCKS);
	}

	@SubscribeEvent
	public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		ModEntities.registerEntities(entityTypeRegistryEvent);
	}
}
