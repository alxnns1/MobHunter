package com.alxnns1.mobhunter.item

import net.minecraft.item.HoeItem
import net.minecraft.item.IItemTier

class MHHoeItem(tier: IItemTier, private val colour: Int, builder: Properties) : HoeItem(tier, 3, 0F, builder), MHITintItem {
	override fun getColour() = colour
}