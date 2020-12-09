package com.alxnns1.mobhunter.recipe

import com.alxnns1.mobhunter.MobHunter
import net.minecraft.item.crafting.IRecipe
import net.minecraft.item.crafting.IRecipeType

class MHRecipeType<T : IRecipe<*>>(name: String) : IRecipeType<T> {
	private val id = "${MobHunter.MOD_ID}:$name"

	override fun toString(): String = id
}