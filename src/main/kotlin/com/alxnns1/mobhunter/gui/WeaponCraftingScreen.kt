package com.alxnns1.mobhunter.gui

import com.alxnns1.mobhunter.MobHunter
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.ITextComponent

class WeaponCraftingScreen(container: WeaponCraftingContainer, playerInv: PlayerInventory, title: ITextComponent)
	: MHContainerScreen<WeaponCraftingContainer>(container, playerInv, title, IMAGE) {
	companion object {
		private val IMAGE = ResourceLocation(MobHunter.MOD_ID, "textures/gui/crafting.png")
	}

	init {
		xSize = 256
		ySize = 203
	}

	// TODO: Rendering
}
