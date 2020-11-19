package com.alxnns1.mobhunter.item

import net.minecraft.block.Block
import net.minecraft.item.BlockItem

class MHTintBlockItem(blockIn: Block, builder: Properties, private val colour: Int) : BlockItem(blockIn, builder), MHITintItem {
	override fun getColour() = colour
}