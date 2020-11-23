package com.alxnns1.mobhunter.entity.neopteran

import com.alxnns1.mobhunter.entity.MHEntity
import com.alxnns1.mobhunter.getMHScale
import net.minecraft.entity.CreatureEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.monster.MonsterEntity
import net.minecraft.network.datasync.DataParameter
import net.minecraft.world.World

private val MH_SCALE: DataParameter<Float> = MHEntity.createScaleKey<MHNeopteranEntity>()

abstract class MHNeopteranEntity(type: EntityType<out MHNeopteranEntity>, world: World) : CreatureEntity(type, world), MHEntity {

	override fun getScaleKey(): DataParameter<Float> = MH_SCALE

	override fun getRenderScale(): Float =
		if (hasScale()) super.getRenderScale() * getMHScale() else super.getRenderScale()
}
