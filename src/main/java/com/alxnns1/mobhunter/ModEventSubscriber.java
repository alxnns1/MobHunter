package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.init.MHEntities;
import com.alxnns1.mobhunter.init.MHItemGroups;
import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;

import static com.alxnns1.mobhunter.MobHunter.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
		final IForgeRegistry<Item> registry = itemRegistryEvent.getRegistry();
		MHBlocks.BLOCKS.values()
				.forEach(block -> registry.register(new BlockItem(block, new Item.Properties()
						.group(MHItemGroups.MOB_HUNTER_BLOCKS_ITEM_GROUP))
						.setRegistryName(Objects.requireNonNull(block.getRegistryName()))));
		itemRegistryEvent.getRegistry().registerAll(MHItems.register());
	}

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		blockRegistryEvent.getRegistry().registerAll(MHBlocks.register());
	}

	@SubscribeEvent
	public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		MHEntities.registerEntities(entityTypeRegistryEvent);
	}

	@SubscribeEvent
	public static void onBlockColorHandlerEvent(ColorHandlerEvent.Block event) {
		MHBlocks.setColourForPlants(event);
	}
}
