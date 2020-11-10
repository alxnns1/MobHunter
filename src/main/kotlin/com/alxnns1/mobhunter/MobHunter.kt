package com.alxnns1.mobhunter

import com.alxnns1.mobhunter.init.MHBlocks
import com.alxnns1.mobhunter.init.MHEntities
import com.alxnns1.mobhunter.init.MHItems
import com.alxnns1.mobhunter.world.MHWorldGen
import net.minecraft.item.ItemStack
import net.minecraft.loot.LootEntry
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTables
import net.minecraft.loot.TableLootEntry
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.LootTableLoadEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.ObfuscationReflectionHelper
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(MobHunter.MOD_ID)
object MobHunter {
	const val MOD_ID = "mobhunter"
	val LOGGER = LogManager.getLogger()

	val GROUP_BLOCKS = MHItemGroup("blocks") { ItemStack(MHBlocks.MACHALITE_BLOCK) }
	val GROUP_ITEMS = MHItemGroup("items") { ItemStack(MHItems.ICON_ITEMS) }
	val GROUP_TOOLS = MHItemGroup("tools") { ItemStack(MHItems.ICON_TOOLS) }

	init {
		MOD_BUS.apply {
			addListener(::setupCommon)
			addListener(::setupClient)
			addGenericListener(MHItems::register)
			addGenericListener(MHBlocks::register)
			addGenericListener(MHEntities::register)
			addListener(MHBlocks::registerBlockColours)
		}
		FORGE_BUS.apply {
			addListener(::lootTableLoad)
			addListener(MHWorldGen::generate)
		}
	}

	private fun setupCommon(event: FMLCommonSetupEvent) {
		MHWorldGen.register()
	}

	private fun setupClient(event: FMLClientSetupEvent) {
		MHEntities.registerRenderers()
		MHBlocks.setRenderLayers()
	}

	private fun lootTableLoad(event: LootTableLoadEvent) {
		if (event.name != LootTables.GAMEPLAY_FISHING)
			return
		val pool = event.table.getPool("main")
		try {
			val lootEntries = ObfuscationReflectionHelper.getPrivateValue<MutableList<LootEntry>, LootPool>(LootPool::class.java, pool, "field_186453_a")
			lootEntries!!.add(TableLootEntry.builder(ResourceLocation(MOD_ID, "gameplay/fishing/fish")).weight(85).quality(-1).build())
		} catch (e: Exception) {
			LOGGER.error("Error trying to insert into loot table", e)
		}
	}
}
