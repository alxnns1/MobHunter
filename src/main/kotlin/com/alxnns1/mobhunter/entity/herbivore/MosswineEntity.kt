package com.alxnns1.mobhunter.entity.herbivore

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHEntity
import com.alxnns1.mobhunter.entity.neopteran.MHNeopteranEntity
import net.minecraft.block.BlockState
import net.minecraft.entity.AgeableEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient
import net.minecraft.network.datasync.DataParameter
import net.minecraft.tags.ItemTags
import net.minecraft.util.DamageSource
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundEvent
import net.minecraft.util.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.server.ServerWorld

private val MH_SCALE: DataParameter<Float> = MHEntity.createScaleKey<MosswineEntity>()

private val TEMPTATION_ITEMS = Ingredient.fromTag(ItemTags.getCollection()[ResourceLocation(MobHunter.MOD_ID, "mushroom")]
	?: throw RuntimeException("Could not find \"mushroom\" Item Tag"))

class MosswineEntity(type: EntityType<out AnimalEntity>, worldIn: World) : AnimalEntity(type, worldIn), MHEntity {

	override fun getScaleKey() = MH_SCALE

	override fun registerGoals() {
		goalSelector.addGoal(0, SwimGoal(this))
		goalSelector.addGoal(1, PanicGoal(this, 1.25))
		goalSelector.addGoal(3, BreedGoal(this, 1.0))
		goalSelector.addGoal(4, TemptGoal(this, 1.2, false, TEMPTATION_ITEMS))
		goalSelector.addGoal(5, FollowParentGoal(this, 1.1))
		goalSelector.addGoal(6, WaterAvoidingRandomWalkingGoal(this, 1.0))
		goalSelector.addGoal(7, LookAtGoal(this, PlayerEntity::class.java, 6.0f))
		goalSelector.addGoal(8, LookRandomlyGoal(this))
	}

	override fun getAmbientSound(): SoundEvent = SoundEvents.ENTITY_PIG_AMBIENT

	override fun getHurtSound(damageSourceIn: DamageSource?): SoundEvent = SoundEvents.ENTITY_PIG_HURT

	override fun getDeathSound(): SoundEvent = SoundEvents.ENTITY_PIG_DEATH

	override fun playStepSound(pos: BlockPos?, blockIn: BlockState?) = playSound(SoundEvents.ENTITY_PIG_STEP, 0.15f, 1.0f)

	override fun func_241840_a(serverWorld: ServerWorld, ageableEntity: AgeableEntity): MosswineEntity {
		return type.create(serverWorld) as MosswineEntity
	}

	override fun isBreedingItem(stack: ItemStack?) = TEMPTATION_ITEMS.test(stack)
}