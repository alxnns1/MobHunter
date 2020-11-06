package com.alxnns1.mobhunter;

import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.List;

import static com.alxnns1.mobhunter.MobHunter.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

	@SubscribeEvent
	public static void onLootTableLoad(LootTableLoadEvent event) {
		if (event.getName().equals(LootTables.GAMEPLAY_FISHING)) {
			LootPool fishingLootPool = event.getTable().getPool("main");
			LootEntry mobHunterFishingLootEntry = TableLootEntry.builder(new ResourceLocation(MOD_ID, "gameplay/fishing/fish")).weight(85).quality(-1).build();
			try {
				List<LootEntry> lootEntries = (List<LootEntry>) ObfuscationReflectionHelper.findField(LootPool.class, "field_186453_a").get(fishingLootPool);
				lootEntries.add(mobHunterFishingLootEntry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
