package com.alxnns1.mobhunter.entity.fish

import net.minecraft.entity.EntityType
import net.minecraft.entity.MobEntity
import net.minecraft.entity.ai.attributes.AttributeModifierMap
import net.minecraft.entity.ai.attributes.Attributes
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.DamageSource
import net.minecraft.util.SoundEvent
import net.minecraft.util.SoundEvents
import net.minecraft.world.World

class GoldenfishEntity(type: EntityType<GoldenfishEntity>, world: World) : AbstractGroupFishEntity(type, world) {
	companion object {
		fun createAttributes(): AttributeModifierMap = MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 3.0)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED)
			.create()
	}

	override fun getFishBucket(): ItemStack = ItemStack(Items.COD_BUCKET)

	override fun getFlopSound(): SoundEvent = SoundEvents.ENTITY_COD_FLOP

	override fun getAmbientSound(): SoundEvent? = SoundEvents.ENTITY_COD_AMBIENT

	override fun getDeathSound(): SoundEvent? = SoundEvents.ENTITY_COD_DEATH

	override fun getHurtSound(p_184601_1_: DamageSource): SoundEvent? = SoundEvents.ENTITY_COD_HURT
}
