package com.alxnns1.mobhunter.effect

import com.alxnns1.mobhunter.init.BLUE
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.EffectType
import net.minecraft.potion.Effects
import net.minecraft.potion.InstantEffect
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.living.PotionEvent.PotionRemoveEvent

class AntidoteEffect : InstantEffect(EffectType.BENEFICIAL, BLUE) {

	override fun affectEntity(source: Entity?, indirectSource: Entity?, entityLivingBaseIn: LivingEntity, amplifier: Int, health: Double) {
		val itr: MutableIterator<EffectInstance> = entityLivingBaseIn.activePotionEffects.iterator()
		while (itr.hasNext()) {
			val effect = itr.next()
			if (effect.potion == Effects.POISON && !MinecraftForge.EVENT_BUS.post(PotionRemoveEvent(entityLivingBaseIn, effect))) {
				effect.potion.removeAttributesModifiersFromEntity(entityLivingBaseIn, entityLivingBaseIn.attributeManager, effect.amplifier)
				itr.remove()
			}
		}
		entityLivingBaseIn.addPotionEffect(EffectInstance(Effects.POISON, 0, 0))
		super.affectEntity(source, indirectSource, entityLivingBaseIn, amplifier, health)
	}
}