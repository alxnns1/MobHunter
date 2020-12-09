package com.alxnns1.mobhunter.gui

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.container.Container
import net.minecraft.item.ItemStack

class SingleSlotInventory(private val container: Container) : IInventory {
	private var invStack = ItemStack.EMPTY

	override fun clear() {
		invStack = ItemStack.EMPTY
		markDirty()
	}

	override fun getSizeInventory(): Int = 1

	override fun isEmpty(): Boolean = invStack.isEmpty

	override fun getStackInSlot(index: Int): ItemStack = if (index == 0) invStack else ItemStack.EMPTY

	override fun decrStackSize(index: Int, amount: Int): ItemStack = if (index == 0 && amount > 0 && !invStack.isEmpty) {
		val split = invStack.split(amount)
		if (!split.isEmpty)
			markDirty()
		split
	} else
		ItemStack.EMPTY

	override fun removeStackFromSlot(index: Int): ItemStack = if (index == 0) {
		val toReturn = invStack
		invStack = ItemStack.EMPTY
		markDirty()
		toReturn
	} else
		ItemStack.EMPTY

	override fun setInventorySlotContents(index: Int, stack: ItemStack) {
		if (index == 0) {
			invStack = stack
			markDirty()
		}
	}

	override fun markDirty() = container.onCraftMatrixChanged(this)

	override fun isUsableByPlayer(p0: PlayerEntity): Boolean = true
}
