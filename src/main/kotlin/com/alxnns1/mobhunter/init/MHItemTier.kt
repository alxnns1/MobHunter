package com.alxnns1.mobhunter.init

import net.minecraft.item.IItemTier
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient

enum class MHItemTier : IItemTier {
	MACHALITE {
		override fun getMaxUses(): Int = 687
		override fun getEfficiency(): Float = 6.667F
		override fun getAttackDamage(): Float = 2.333F
		override fun getHarvestLevel(): Int = 2
		override fun getEnchantability(): Int = 15
		override fun getRepairMaterial(): Ingredient = Ingredient.fromStacks(ItemStack(MHItems.MACHALITE_INGOT))
	},
	DRAGONITE {
		override fun getMaxUses(): Int = 1124
		override fun getEfficiency(): Float = 7.333F
		override fun getAttackDamage(): Float = 2.667F
		override fun getHarvestLevel(): Int = 2
		override fun getEnchantability(): Int = 16
		override fun getRepairMaterial(): Ingredient = Ingredient.fromStacks(ItemStack(MHItems.DRAGONITE_INGOT))
	},
	CARBALITE {
		override fun getMaxUses(): Int = 1561
		override fun getEfficiency(): Float = 8F
		override fun getAttackDamage(): Float = 3F
		override fun getHarvestLevel(): Int = 3
		override fun getEnchantability(): Int = 17
		override fun getRepairMaterial(): Ingredient = Ingredient.fromStacks(ItemStack(MHItems.CARBALITE_INGOT))
	},
	ELTALITE {
		override fun getMaxUses(): Int = 1998
		override fun getEfficiency(): Float = 9F
		override fun getAttackDamage(): Float = 4F
		override fun getHarvestLevel(): Int = 4
		override fun getEnchantability(): Int = 18
		override fun getRepairMaterial(): Ingredient = Ingredient.fromStacks(ItemStack(MHItems.ELTALITE_INGOT))
	}
}