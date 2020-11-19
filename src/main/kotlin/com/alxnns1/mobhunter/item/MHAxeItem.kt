package com.alxnns1.mobhunter.item

import net.minecraft.item.AxeItem
import net.minecraft.item.IItemTier
import net.minecraft.item.PickaxeItem

class MHAxeItem(tier: IItemTier, private val colour: Int, builder: Properties) : AxeItem(tier, 6F, -3.1F, builder), MHITintItem {
	override fun getColour() = colour
}