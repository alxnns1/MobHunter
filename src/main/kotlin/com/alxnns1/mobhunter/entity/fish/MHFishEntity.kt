package com.alxnns1.mobhunter.entity.fish

import com.alxnns1.mobhunter.entity.MHEntity
import com.alxnns1.mobhunter.getMHScale
import net.minecraft.entity.EntityType
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity
import net.minecraft.network.datasync.DataParameter
import net.minecraft.world.World

abstract class MHFishEntity(type: EntityType<out MHFishEntity>, world: World) : AbstractGroupFishEntity(type, world), MHEntity {
	companion object {
		val MH_SCALE: DataParameter<Float> = MHEntity.createScaleKey<MHFishEntity>()
	}

	override fun getScaleKey(): DataParameter<Float> = MH_SCALE

	override fun getRenderScale(): Float =
		if (hasScale()) super.getRenderScale() * getMHScale() else super.getRenderScale()
}
