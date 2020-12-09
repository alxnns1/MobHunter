package com.alxnns1.mobhunter.gui

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.container.Container
import net.minecraft.inventory.container.ContainerType
import net.minecraft.inventory.container.Slot
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos

@Suppress("LeakingThis")
open class MHContainer(
	id: Int,
	type: ContainerType<*>,
	protected val playerInv: PlayerInventory,
	protected val pos: BlockPos,
	vararg slots: (IInventory) -> Slot
) : Container(type, id) {
	protected val player = playerInv.player
	protected val world = player.world
	protected var slotI = 0
	protected var invStartX = 8
	protected var invStartY = 84
	protected lateinit var inventory: IInventory

	init {
		slots.forEach { addSlot(it(inventory)) }

		(0..2).forEach { i ->
			(0..8).forEach { j ->
				addSlot(Slot(playerInv, j + i * 9 + 9, invStartX + j * 18, invStartY + i * 18))
			}
		}
		(0..8).forEach {
			addSlot(Slot(playerInv, it, invStartX + it * 18, invStartY + 18 * 3 + 4))
		}
	}

	override fun canInteractWith(player: PlayerEntity): Boolean = inventory.isUsableByPlayer(player)

	override fun transferStackInSlot(player: PlayerEntity, index: Int): ItemStack {
		return inventorySlots[index]?.takeIf { it.hasStack }?.let { slot ->
			val stackInSlot = slot.stack
			val stack = stackInSlot.copy()

			if (index < slotI) {
				// If GUI slot
				if (!mergeItemStack(stackInSlot, slotI, slotI + 36, true))
					return@let ItemStack.EMPTY
				slot.onSlotChange(stackInSlot, stack)
			} else if (index >= slotI && index <= slotI + 36) {
				// If player inv slot
				var success = false
				for (it in 0 until slotI) {
					if (inventorySlots[it].isItemValid(stackInSlot) && mergeItemStack(stackInSlot, it, it + 1, false)) {
						success = true
						break
					}
				}
				if (!success)
					return@let ItemStack.EMPTY
			}

			if (stackInSlot.isEmpty)
				slot.putStack(ItemStack.EMPTY)
			else
				slot.onSlotChanged()

			if (stackInSlot.count == stack.count)
				return@let ItemStack.EMPTY

			slot.onTake(player, stackInSlot)
		} ?: ItemStack.EMPTY
	}

	override fun onContainerClosed(player: PlayerEntity) {
		super.onContainerClosed(player)
		inventory.closeInventory(player)
	}
}
