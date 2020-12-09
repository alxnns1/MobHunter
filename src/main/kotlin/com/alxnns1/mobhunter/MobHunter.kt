package com.alxnns1.mobhunter

import com.alxnns1.mobhunter.entity.MHEntity
import com.alxnns1.mobhunter.init.*
import com.alxnns1.mobhunter.item.MHSpawnEggItem
import com.alxnns1.mobhunter.world.MHMobSpawns
import com.alxnns1.mobhunter.world.MHWorldGen
import net.minecraft.item.ItemStack
import net.minecraft.loot.LootEntry
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTables
import net.minecraft.loot.TableLootEntry
import net.minecraft.util.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.LootTableLoadEvent
import net.minecraftforge.event.entity.EntityEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.LogManager
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runWhenOn

@Mod(MobHunter.MOD_ID)
object MobHunter {
	const val MOD_ID = "mobhunter"
	val LOGGER = LogManager.getLogger()

	val GROUP_BLOCKS = MHItemGroup("blocks") { ItemStack(MHBlocks.MACHALITE_BLOCK) }
	val GROUP_ITEMS = MHItemGroup("items") { ItemStack(MHItems.ICON_ITEMS) }
	val GROUP_TOOLS = MHItemGroup("tools") { ItemStack(MHItems.ICON_TOOLS) }
	val GROUP_SWORDS = MHItemGroup("swords") { ItemStack(MHItems.ICON_SNS) }
	val GROUP_ENTITIES = MHItemGroup("entities") { ItemStack(MHItems.ICON_MOBS) }

	init {
		MOD_BUS.apply {
			addListener(::setupCommon)
			addListener(::setupClient)
			addListener(MHBrewingRecipes::register)
			addGenericListener(MHItems::register)
			addGenericListener(MHSwords::register)
			addGenericListener(MHBlocks::register)
			addGenericListener(MHSounds::register)
			addGenericListener(MHEntities::register)
			addGenericListener(MHEffects::register)
			addGenericListener(MHScreens::registerContainers)
			addGenericListener(MHRecipes::registerSerializers)
			runWhenOn(Dist.CLIENT) {
				addListener(MHBlocks::registerBlockColours)
				addListener(MHItems::registerItemColours)
			}
		}
		FORGE_BUS.apply {
			addListener(::lootTableLoad)
			addListener(::entityConstructing)
			addListener(MHWorldGen::generate)
			addListener(EventPriority.HIGH, MHMobSpawns::register)
		}
	}

	private fun setupCommon(event: FMLCommonSetupEvent) {
		MHSpawnEggItem.initEggs()
		MHMobSpawns.init()
		MHWorldGen.register()
	}

	private fun setupClient(event: FMLClientSetupEvent) {
		MHEntities.registerRenderers()
		MHBlocks.setRenderLayers()
		MHScreens.registerScreens(event)
	}

	private fun lootTableLoad(event: LootTableLoadEvent) {
		if (event.name != LootTables.GAMEPLAY_FISHING)
			return
		val pool = event.table.getPool("main")
		withPrivateValue<MutableList<LootEntry>, LootPool>(pool, "field_186453_a") {
			it.add(TableLootEntry.builder(ResourceLocation(MOD_ID, "gameplay/fishing/fish")).weight(85).quality(-1).build())
		}
	}

	private fun entityConstructing(event: EntityEvent.EntityConstructing) {
		val entity = event.entity
		if (entity !is MHEntity || !entity.hasScale())
			return

		if (entity.world.isRemote) {
			entity.dataManager.register(entity.getScaleKey(), 1F)
		} else {
			// Set scale server side only so that the value is synced to clients
			val min = entity.getMinScale()
			val max = entity.getMaxScale()
			val scale = entity.world.rand.nextFloat() * (max - min) + min
//			LOGGER.info("SCALE: ${entity::class.simpleName} -> $scale")
			entity.dataManager.register(entity.getScaleKey(), scale)
		}
	}
}
