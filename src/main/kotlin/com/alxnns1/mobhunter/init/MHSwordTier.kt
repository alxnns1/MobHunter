package com.alxnns1.mobhunter.init

import net.minecraft.item.IItemTier
import net.minecraft.item.Item
import net.minecraft.item.crafting.Ingredient

class MHSwordTier(
	private val maxUses: Int,
	private val enchantability: Int,
	private val repairMaterialSupplier: () -> Item
) : IItemTier {
	override fun getMaxUses(): Int = maxUses
	override fun getEfficiency(): Float = 0F
	override fun getAttackDamage(): Float = 0F
	override fun getHarvestLevel(): Int = 0
	override fun getEnchantability(): Int = enchantability
	override fun getRepairMaterial(): Ingredient = Ingredient.fromItems(repairMaterialSupplier)
}