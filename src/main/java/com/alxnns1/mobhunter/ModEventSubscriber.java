package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.init.ModBlocks;
import com.alxnns1.mobhunter.init.ModEntities;
import com.alxnns1.mobhunter.init.ModItemGroups;
import com.alxnns1.mobhunter.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Arrays;
import java.util.Objects;

import static com.alxnns1.mobhunter.MobHunter.MOD_ID;

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