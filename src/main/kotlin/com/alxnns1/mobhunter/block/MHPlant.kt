package com.alxnns1.mobhunter.block

import net.minecraft.block.BlockState
import net.minecraft.block.BushBlock
import net.minecraft.util.Direction
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockReader
import net.minecraft.world.IWorldReader

class MHPlant(val colour: Int, properties: Properties) : BushBlock(properties) {
	override fun isValidPosition(state: BlockState, world: IWorldReader, pos: BlockPos): Boolean {
		val posDown = pos.down()
		return isValidGround(world.getBlockState(posDown), world, posDown)
	}

	override fun isValidGround(state: BlockState, world: IBlockReader, pos: BlockPos): Boolean =
		state.isSolidSide(world, pos, Direction.UP)
}
