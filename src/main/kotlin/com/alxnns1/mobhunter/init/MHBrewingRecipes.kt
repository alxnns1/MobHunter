package com.alxnns1.mobhunter.init

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.crafting.Ingredient
import net.minecraftforge.common.brewing.BrewingRecipeRegistry
import net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent

object MHBrewingRecipes {

	fun register(event: ParallelDispatchEvent) {
		event.enqueueWork {
			recipe(MHItems.BLUE_MUSHROOM, Items.POTION, MHItems.BLUE_MUSHROOM_INTERMEDIARY)
			recipe(MHItems.HERB, MHItems.BLUE_MUSHROOM_INTERMEDIARY, MHItems.POTION)
			recipe(Items.HONEY_BOTTLE, MHItems.POTION, MHItems.MEGA_POTION)
			recipe(MHItems.ANTIDOTE_HERB, MHItems.BLUE_MUSHROOM_INTERMEDIARY, MHItems.ANTIDOTE)
			recipe(MHItems.NITROSHROOM, Items.POTION, MHItems.NITROSHROOM_INTERMEDIARY)
			recipe(Items.HONEY_BOTTLE, MHItems.NITROSHROOM_INTERMEDIARY, MHItems.ENERGY_DRINK)
		}
	}

	private fun recipe(reagent: Item, base: Item, result: Item) {
		BrewingRecipeRegistry.addRecipe(
			Ingredient.fromStacks(ItemStack(base)),
			Ingredient.fromStacks(ItemStack(reagent)),
			ItemStack(result))
	}
}