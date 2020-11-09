package com.alxnns1.mobhunter.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;

public class MHPlant extends BushBlock {
	public MHPlant(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isValidPosition(BlockState state, @Nonnull IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
	}

	@Override
	protected boolean isValidGround(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
		return state.isSolidSide(worldIn, pos, Direction.UP);
	}
}
