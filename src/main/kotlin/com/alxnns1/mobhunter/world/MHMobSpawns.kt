package com.alxnns1.mobhunter.world

import com.alxnns1.mobhunter.init.MHEntities
import net.minecraft.entity.EntityClassification
import net.minecraft.world.biome.MobSpawnInfo
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.event.world.BiomeLoadingEvent

object MHMobSpawns {
	fun register(event: BiomeLoadingEvent) {
		val type = BiomeDictionary.Type.fromVanilla(event.category)
		if (type == BiomeDictionary.Type.MESA || type == BiomeDictionary.Type.FOREST || type == BiomeDictionary.Type.PLAINS || type == BiomeDictionary.Type.MOUNTAIN || type == BiomeDictionary.Type.HILLS || type == BiomeDictionary.Type.SWAMP) {
			event.spawns.getSpawner(EntityClassification.CREATURE).add(MobSpawnInfo.Spawners(MHEntities.HORNETAUR, 100, 1, 5))
		}
	}
}