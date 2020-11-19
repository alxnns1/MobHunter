package com.alxnns1.mobhunter.item

import net.minecraft.item.IItemTier
import net.minecraft.item.ShovelItem

class MHShovelItem(tier: IItemTier, private val colour: Int, builder: Properties) : ShovelItem(tier, 1.5F, -3F, builder), MHITintItem {
	override fun getColour() = colour
}