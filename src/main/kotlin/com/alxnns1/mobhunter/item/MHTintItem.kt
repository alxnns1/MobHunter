package com.alxnns1.mobhunter.item

import net.minecraft.item.Item

class MHTintItem(properties: Properties, private val colour: Int) : Item(properties), MHITintItem {
	override fun getColour() = colour
}