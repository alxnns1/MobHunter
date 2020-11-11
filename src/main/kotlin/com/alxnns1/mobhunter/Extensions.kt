package com.alxnns1.mobhunter

import com.alxnns1.mobhunter.entity.MHEntity
import net.minecraft.entity.MobEntity
import net.minecraftforge.fml.common.ObfuscationReflectionHelper

inline fun <T, reified E> withPrivateValue(instance: E?, fieldName: String, block: (T) -> Unit): Unit = try {
	ObfuscationReflectionHelper.getPrivateValue<T, E>(E::class.java, instance, fieldName)
		?.let(block)
		?: MobHunter.LOGGER.error("Got null for value of private field '$fieldName' in ${E::class.qualifiedName}")
} catch (e: Exception) {
	MobHunter.LOGGER.error("Error trying to get value of private field '$fieldName' from ${E::class.qualifiedName}", e)
}

fun <T> T.getMHScale(): Float where T : MHEntity, T : MobEntity = this.dataManager[this.getScaleKey()]
