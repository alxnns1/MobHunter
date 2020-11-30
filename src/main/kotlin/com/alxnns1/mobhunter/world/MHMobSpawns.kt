package com.alxnns1.mobhunter.world

import com.alxnns1.mobhunter.init.MHEntities
import net.minecraft.entity.EntityClassification
import net.minecraft.entity.EntityClassification.CREATURE
import net.minecraft.entity.EntityType
import net.minecraft.world.biome.MobSpawnInfo
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeDictionary.Type.*
import net.minecraftforge.event.world.BiomeLoadingEvent

object MHMobSpawns {
	private val SPAWNS = mutableMapOf<BiomeDictionary.Type, MutableSet<Pair<EntityClassification, MobSpawnInfo.Spawners>>>()

	fun init() {
		spawn(CREATURE, MHEntities.KELBI, 10, 4, 4, MESA, FOREST, PLAINS, MOUNTAIN, HILLS, SWAMP, SANDY, WASTELAND, BEACH)
		spawn(CREATURE, MHEntities.MOSSWINE, 10, 4, 4, MESA, FOREST, PLAINS, HILLS, SWAMP, WASTELAND)
		spawn(CREATURE, MHEntities.HORNETAUR, 10, 4, 4, MESA, FOREST, PLAINS, MOUNTAIN, HILLS, SWAMP)
	}

	fun register(event: BiomeLoadingEvent) {
		val type = fromVanilla(event.category)
		SPAWNS[type]?.forEach {
			event.spawns.getSpawner(it.first).add(it.second)
		}
	}

	private fun spawn(
		classification: EntityClassification,
		entityType: EntityType<*>,
		weight: Int,
		minCount: Int,
		maxCount: Int,
		vararg biomeTypes: BiomeDictionary.Type
	) {
		val entry = classification to MobSpawnInfo.Spawners(entityType, weight, minCount, maxCount)
		biomeTypes.forEach { SPAWNS.getOrPut(it, { mutableSetOf() }).add(entry) }
	}
}
