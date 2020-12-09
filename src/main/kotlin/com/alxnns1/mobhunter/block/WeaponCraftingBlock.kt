package com.alxnns1.mobhunter.block

import com.alxnns1.mobhunter.gui.MHNamedContainerProvider
import com.alxnns1.mobhunter.gui.WeaponCraftingContainer
import com.alxnns1.mobhunter.init.MHBlocks
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.material.Material
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.inventory.container.Container
import net.minecraft.inventory.container.INamedContainerProvider
import net.minecraft.util.ActionResultType
import net.minecraft.util.Hand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.BlockRayTraceResult
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.World
import net.minecraftforge.fml.network.NetworkHooks

class WeaponCraftingBlock : Block(Properties.create(Material.ROCK)) {
	override fun onBlockActivated(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockRayTraceResult): ActionResultType {
		if (!world.isRemote && player is ServerPlayerEntity) {
			NetworkHooks.openGui(player, getContainer(state, world, pos), pos)
			return ActionResultType.CONSUME
		}
		return ActionResultType.SUCCESS
	}

	override fun getContainer(state: BlockState, world: World, pos: BlockPos): INamedContainerProvider? =
		MHNamedContainerProvider(MHBlocks.WEAPON_CRAFTING.translationKey, pos, ::WeaponCraftingContainer)
}
