package com.alxnns1.mobhunter.init

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.crafting.Ingredient
import net.minecraft.potion.PotionUtils
import net.minecraft.potion.Potions
import net.minecraftforge.common.brewing.BrewingRecipeRegistry
import net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent

object MHBrewingRecipes {

	fun register(event: ParallelDispatchEvent) {
		event.enqueueWork {
			recipe(MHItems.BLUE_MUSHROOM, MHItems.BLUE_MUSHROOM_INTERMEDIARY)
			recipe(MHItems.HERB, MHItems.BLUE_MUSHROOM_INTERMEDIARY, MHItems.POTION)
			recipe(Items.HONEY_BOTTLE, MHItems.POTION, MHItems.MEGA_POTION)
			recipe(MHItems.GODBUG, MHItems.BLUE_MUSHROOM_INTERMEDIARY, MHItems.NUTRIENTS)
			recipe(Items.HONEY_BOTTLE, MHItems.NUTRIENTS, MHItems.MEGA_NUTRIENTS)
			recipe(MHItems.ANTIDOTE_HERB, MHItems.BLUE_MUSHROOM_INTERMEDIARY, MHItems.ANTIDOTE)
			recipe(MHItems.BITTERBUG, MHItems.BITTERBUG_INTERMEDIARY)
			recipe(MHItems.GLOAMGRASS_ROOT, MHItems.BITTERBUG_INTERMEDIARY, MHItems.HERBAL_MEDICINE)
			recipe(MHItems.DRAGON_TOADSTOOL, MHItems.MEGA_NUTRIENTS, MHItems.MAX_POTION)
			recipe(Items.HONEY_BOTTLE, MHItems.BITTERBUG_INTERMEDIARY, MHItems.CATALYST)
			recipe(MHItems.DRAGON_TOADSTOOL, MHItems.CATALYST, MHItems.IMMUNIZER)
			recipe(MHItems.POPFISH, MHItems.CATALYST, MHItems.CLEANSER)
//			recipe(MHItems.RARE_STEAK, MHItems.CATALYST, MHItems.DASH_JUICE)
//			recipe(MHItems.WELL_DONE_STEAK, MHItems.DASH_EXTRACT, MHItems.MEGA_DASH_JUICE)
			recipe(MHItems.NITROSHROOM, MHItems.NITROSHROOM_INTERMEDIARY)
			recipe(Items.HONEY_BOTTLE, MHItems.NITROSHROOM_INTERMEDIARY, MHItems.ENERGY_DRINK)
			recipe(MHItems.MIGHT_SEED, MHItems.CATALYST, MHItems.DEMONDRUG)
//			recipe(MHItems.PALE_EXTRACT, MHItems.DEMONDRUG, MHItems.MEGA_DEMONDRUG)
			recipe(MHItems.MIGHT_SEED, MHItems.IMMUNIZER, MHItems.MIGHT_PILL)
			recipe(MHItems.ADAMANT_SEED, MHItems.CATALYST, MHItems.ARMORSKIN)
//			recipe(MHItems.PALE_EXTRACT, MHItems.ARMORSKIN, MHItems.MEGA_ARMORSKIN)
			recipe(MHItems.ADAMANT_SEED, MHItems.IMMUNIZER, MHItems.ADAMANT_PILL)
			recipe(MHItems.HOT_PEPPER, MHItems.BITTERBUG_INTERMEDIARY, MHItems.HOT_DRINK)
			recipe(MHItems.ICE_CRYSTAL, MHItems.BITTERBUG_INTERMEDIARY, MHItems.COOL_DRINK)
		}
	}

	private fun recipe(reagent: Item, base: Item, result: Item) {
		BrewingRecipeRegistry.addRecipe(
			Ingredient.fromStacks(ItemStack(base)),
			Ingredient.fromStacks(ItemStack(reagent)),
			ItemStack(result))
	}

	private fun recipe(reagent: Item, result: Item) {
		BrewingRecipeRegistry.addRecipe(
			Ingredient.fromStacks(PotionUtils.addPotionToItemStack(ItemStack(Items.POTION), Potions.WATER)),
			Ingredient.fromStacks(ItemStack(reagent)),
			ItemStack(result))
	}
}