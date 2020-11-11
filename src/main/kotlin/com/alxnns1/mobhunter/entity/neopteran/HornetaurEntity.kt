package com.alxnns1.mobhunter.entity.neopteran

import net.minecraft.block.BlockState
import net.minecraft.entity.EntitySize
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.Pose
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.DamageSource
import net.minecraft.util.SoundEvent
import net.minecraft.util.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class HornetaurEntity(type: EntityType<HornetaurEntity>, world: World) : MHNeopteranEntity(type, world) {
	// TODO: Remove - this is just here atm to demo scaling
	override fun getMinScale(): Float = 0.5F

	// TODO: Remove - this is just here atm to demo scaling
	override fun getMaxScale(): Float = 2F

	override fun getStandingEyeHeight(poseIn: Pose, sizeIn: EntitySize) = sizeIn.height/2

	override fun registerGoals() {
		goalSelector.addGoal(1, SwimGoal(this))
		goalSelector.addGoal(3, LeapAtTargetGoal(this, 0.4f))
		goalSelector.addGoal(4, AttackGoal(this))
		goalSelector.addGoal(5, WaterAvoidingRandomWalkingGoal(this, 0.8))
		goalSelector.addGoal(6, LookAtGoal(this, PlayerEntity::class.java, 8.0f))
		goalSelector.addGoal(6, LookRandomlyGoal(this))
		targetSelector.addGoal(1, HurtByTargetGoal(this))
		targetSelector.addGoal(2, NearestAttackableTargetGoal(this, PlayerEntity::class.java, true))
		targetSelector.addGoal(3, NearestAttackableTargetGoal(this, AbstractVillagerEntity::class.java, true))
	}

	override fun getAmbientSound(): SoundEvent = SoundEvents.ENTITY_SPIDER_AMBIENT

	override fun getHurtSound(damageSourceIn: DamageSource): SoundEvent = SoundEvents.ENTITY_SPIDER_HURT

	override fun getDeathSound(): SoundEvent = SoundEvents.ENTITY_SPIDER_DEATH

	override fun playStepSound(pos: BlockPos, blockIn: BlockState) = playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15f, 1.0f)

	internal class AttackGoal(hornetaur: HornetaurEntity) : MeleeAttackGoal(hornetaur, 1.0, true) {
		override fun shouldExecute() = super.shouldExecute() && !attacker.isBeingRidden
		override fun getAttackReachSqr(attackTarget: LivingEntity) = 4.0 + attackTarget.width
	}
}
