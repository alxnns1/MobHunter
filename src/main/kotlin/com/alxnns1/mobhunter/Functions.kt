package com.alxnns1.mobhunter

import net.minecraft.item.crafting.Ingredient
import net.minecraft.tags.ItemTags
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.ObfuscationReflectionHelper

inline fun <T, reified E> withPrivateValue(instance: E?, fieldName: String, block: (T) -> Unit) {
	getPrivateValue<T, E>(instance, fieldName)?.let(block)
}

inline fun <T, reified E> getPrivateValue(instance: E?, fieldName: String): T? = try {
	ObfuscationReflectionHelper.getPrivateValue<T, E>(E::class.java, instance, fieldName) ?: run {
		MobHunter.LOGGER.error("Got null for value of private field '$fieldName' in ${E::class.qualifiedName}")
		null
	}
} catch (e: Exception) {
	MobHunter.LOGGER.error("Error trying to get value of private field '$fieldName' from ${E::class.qualifiedName}", e)
	null
}

fun ingredientFromItemTag(itemTag: ResourceLocation): Ingredient =
	Ingredient.fromTag(ItemTags.getCollection()[itemTag] ?: error("Could not find item tag '$itemTag'"))
