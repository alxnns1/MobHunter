package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.recipe.MHIngredient
import com.alxnns1.mobhunter.recipe.MHRecipeType
import com.alxnns1.mobhunter.recipe.WeaponCraftingRecipe
import net.minecraft.item.crafting.IRecipe
import net.minecraft.item.crafting.IRecipeSerializer
import net.minecraft.item.crafting.IRecipeType
import net.minecraft.item.crafting.RecipeManager
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import net.minecraftforge.client.event.RecipesUpdatedEvent
import net.minecraftforge.common.crafting.CraftingHelper
import net.minecraftforge.common.crafting.IIngredientSerializer
import net.minecraftforge.event.RegistryEvent

object MHRecipes {
	val WEAPON_CRAFTING_TYPE = MHRecipeType<WeaponCraftingRecipe>("weapon_crafting")

	fun registerSerializers(event: RegistryEvent.Register<IRecipeSerializer<*>>) {
		type(WEAPON_CRAFTING_TYPE)

		ingredientSerializer("items", MHIngredient.Serializer)

		event.registry.registerAll(
			WeaponCraftingRecipe.Serializer
		)
	}

	private fun type(type: IRecipeType<*>) {
		Registry.register(Registry.RECIPE_TYPE, ResourceLocation(MobHunter.MOD_ID, type.toString()), type)
	}

	private fun ingredientSerializer(name: String, serializer: IIngredientSerializer<*>) {
		CraftingHelper.register(ResourceLocation(MobHunter.MOD_ID, name), serializer)
	}
}
