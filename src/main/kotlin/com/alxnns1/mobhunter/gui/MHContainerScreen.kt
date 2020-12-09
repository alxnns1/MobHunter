package com.alxnns1.mobhunter.gui

import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.screen.inventory.ContainerScreen
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.container.Container
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.ITextComponent

open class MHContainerScreen<T : Container>(
	container: T,
	playerInv: PlayerInventory,
	title: ITextComponent,
	private val bgImage: ResourceLocation
) : ContainerScreen<T>(container, playerInv, title) {
	override fun drawGuiContainerBackgroundLayer(matrixStack: MatrixStack, partialTicks: Float, x: Int, y: Int) {
		@Suppress("DEPRECATION")
		RenderSystem.color4f(1F, 1F, 1F, 1F)
		minecraft!!.textureManager.bindTexture(bgImage)
		blit(matrixStack, guiLeft, guiTop, 0, 0, xSize, ySize)
	}

	override fun drawGuiContainerForegroundLayer(matrixStack: MatrixStack, x: Int, y: Int) {
		super.drawGuiContainerForegroundLayer(matrixStack, x, y)
	}
}
