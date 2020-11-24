package com.alxnns1.mobhunter.entity.neopteran

import com.alxnns1.mobhunter.init.MHSounds
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.EntitySize
import net.minecraft.entity.EntityType
import net.minecraft.entity.Pose
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.DamageSource
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IWorldReader
import net.minecraft.world.World

class HornetaurEntity(type: EntityType<HornetaurEntity>, world: World) : MHNeopteranEntity(type, world) {

	override fun getStandingEyeHeight(poseIn: Pose, sizeIn: EntitySize) = sizeIn.height / 2

	override fun registerGoals() {
		goalSelector.addGoal(1, SwimGoal(this))
		goalSelector.addGoal(3, LeapAtTargetGoal(this, 0.4f))
		goalSelector.addGoal(4, MeleeAttackGoal(this, 1.0, true))
		goalSelector.addGoal(5, WaterAvoidingRandomWalkingGoal(this, 0.8))
		goalSelector.addGoal(6, LookAtGoal(this, PlayerEntity::class.java, 8.0f))
		goalSelector.addGoal(6, LookRandomlyGoal(this))
		targetSelector.addGoal(1, HurtByTargetGoal(this))
		targetSelector.addGoal(2, NearestAttackableTargetGoal(this, PlayerEntity::class.java, true))
		targetSelector.addGoal(3, NearestAttackableTargetGoal(this, AbstractVillagerEntity::class.java, true))
	}

	override fun getAmbientSound() = MHSounds.HORNETAUR_AMBIENT

	override fun getHurtSound(damageSourceIn: DamageSource) = MHSounds.HORNETAUR_HURT

	override fun getDeathSound() = MHSounds.HORNETAUR_DEATH

	override fun playStepSound(pos: BlockPos, blockIn: BlockState) = playSound(MHSounds.HORNETAUR_STEP, 0.15f, 1.0f)

	override fun getBlockPathWeight(pos: BlockPos, worldIn: IWorldReader): Float {
		return when {
			worldIn.getBlockState(pos.down()).isIn(Blocks.GRASS_BLOCK) -> 1f
			worldIn.getBlockState(pos.down()).isIn(Blocks.DIRT) -> 1f
			worldIn.getBlockState(pos.down()).isIn(Blocks.SAND) -> 1f
			worldIn.getBlockState(pos.down()).isIn(Blocks.GRAVEL) -> 1f
			else -> -1f
		}
	}

	override fun canDespawn(distanceToClosestPlayer: Double) = false
}
