package com.alxnns1.mobhunter.entity.neopteran

import net.minecraft.entity.CreatureEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.MobEntity
import net.minecraft.entity.ai.attributes.AttributeModifierMap
import net.minecraft.entity.ai.attributes.Attributes
import net.minecraft.world.World

class HornetaurEntity(type: EntityType<HornetaurEntity>, world: World) : CreatureEntity(type, world) {
	companion object {
		fun createAttributes(): AttributeModifierMap = MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 3.0)
			.createMutableAttribute(Attributes.MOVEMENT_SPEED)
			.create()
	}
}
