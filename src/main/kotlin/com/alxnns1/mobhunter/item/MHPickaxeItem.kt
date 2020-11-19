package com.alxnns1.mobhunter.item

import net.minecraft.item.IItemTier
import net.minecraft.item.PickaxeItem

class MHPickaxeItem(tier: IItemTier, private val colour: Int, builder: Properties) : PickaxeItem(tier, 1, -2.8F, builder), MHITintItem {
	override fun getColour() = colour
}