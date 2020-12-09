package com.alxnns1.mobhunter.gui

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.container.Container
import net.minecraft.inventory.container.INamedContainerProvider
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TranslationTextComponent

class MHNamedContainerProvider(
	private val name: String,
	private val pos: BlockPos,
	private val containerFactory: (Int, PlayerInventory, BlockPos) -> Container
) : INamedContainerProvider {
	override fun createMenu(windowId: Int, playerInv: PlayerInventory, playerEntity: PlayerEntity): Container? =
		containerFactory(windowId, playerInv, pos)

	override fun getDisplayName(): ITextComponent = TranslationTextComponent(name)
}
