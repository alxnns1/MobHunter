package com.alxnns1.mobhunter.entity

import net.minecraft.entity.Entity
import net.minecraft.network.datasync.DataParameter
import net.minecraft.network.datasync.DataSerializers
import net.minecraft.network.datasync.EntityDataManager

interface MHEntity {
	companion object {
		inline fun <reified T : Entity> createScaleKey(): DataParameter<Float> =
			EntityDataManager.createKey(T::class.java, DataSerializers.FLOAT)
	}

	fun getScaleKey(): DataParameter<Float>
	fun getMinScale(): Float = 1F
	fun getMaxScale(): Float = 1F
	fun hasScale(): Boolean = getMinScale() != 1F || getMaxScale() != 1F
}
