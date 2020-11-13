package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.effect.AntidoteEffect
import com.alxnns1.mobhunter.effect.ParalysisEffect
import net.minecraft.potion.Effect
import net.minecraftforge.event.RegistryEvent
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHEffects {
	val ANTIDOTE: Effect by objectHolder("antidote")
	val PARALYSIS: Effect by objectHolder("paralysis")

	fun register(event: RegistryEvent.Register<Effect>) = event.registry.registerAll(
		effect("antidote", AntidoteEffect()),
		effect("paralysis", ParalysisEffect())
	)

	private fun effect(name: String, effect: Effect): Effect = effect.setRegistryName(name)
}
