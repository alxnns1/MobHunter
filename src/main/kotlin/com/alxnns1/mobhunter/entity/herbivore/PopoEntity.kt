package com.alxnns1.mobhunter.entity.herbivore

import com.alxnns1.mobhunter.entity.MHEntity
import com.alxnns1.mobhunter.init.MHSounds
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.*
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.crafting.Ingredient
import net.minecraft.network.datasync.DataParameter
import net.minecraft.util.DamageSource
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IWorld
import net.minecraft.world.IWorldReader
import net.minecraft.world.World
import net.minecraft.world.server.ServerWorld

private val MH_SCALE: DataParameter<Float> = MHEntity.createScaleKey<PopoEntity>()
private val TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT, Items.SUGAR, Blocks.HAY_BLOCK.asItem(), Items.APPLE, Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE)

class PopoEntity(type: EntityType<out AnimalEntity>, worldIn: World) : AnimalEntity(type, worldIn), MHEntity {

	override fun getScaleKey() = MH_SCALE

	override fun getStandingEyeHeight(poseIn: Pose, sizeIn: EntitySize) = sizeIn.height

	override fun registerGoals() {
		goalSelector.addGoal(0, SwimGoal(this))
		goalSelector.addGoal(1, PanicGoal(this, 1.25))
		goalSelector.addGoal(2, MeleeAttackGoal(this, 1.25, false))
		goalSelector.addGoal(3, BreedGoal(this, 1.0))
		goalSelector.addGoal(4, TemptGoal(this, 1.2, false, TEMPTATION_ITEMS))
		goalSelector.addGoal(5, FollowParentGoal(this, 1.1))
		goalSelector.addGoal(6, WaterAvoidingRandomWalkingGoal(this, 1.0))
		goalSelector.addGoal(7, LookAtGoal(this, PlayerEntity::class.java, 6.0f))
		goalSelector.addGoal(8, LookRandomlyGoal(this))
		targetSelector.addGoal(1, HurtByTargetGoal(this))
	}

	override fun getAmbientSound() = MHSounds.POPO_AMBIENT

	override fun getHurtSound(damageSourceIn: DamageSource?) = MHSounds.POPO_HURT

	override fun getDeathSound() = MHSounds.POPO_DEATH

	override fun playStepSound(pos: BlockPos?, blockIn: BlockState?) = playSound(MHSounds.POPO_STEP, 0.15f, 1.0f)

	override fun func_241840_a(serverWorld: ServerWorld, ageableEntity: AgeableEntity): PopoEntity {
		return type.create(serverWorld) as PopoEntity
	}

	override fun isBreedingItem(stack: ItemStack?) = TEMPTATION_ITEMS.test(stack)

	override fun getBlockPathWeight(pos: BlockPos, worldIn: IWorldReader): Float {
		return if (worldIn.getBlockState(pos.down()).isIn(Blocks.WATER)) -1f else 0f
	}

	override fun canSpawn(worldIn: IWorld, spawnReasonIn: SpawnReason): Boolean {
		return worldIn.getBlockState(position.down()).isIn(Blocks.GRASS_BLOCK) && worldIn.getLightSubtracted(position, 0) > 8
	}
}