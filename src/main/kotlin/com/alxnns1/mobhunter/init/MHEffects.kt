package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.effect.AntidoteEffect
import com.alxnns1.mobhunter.effect.ParalysisEffect
import net.minecraft.potion.Effect
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.registries.ForgeRegistries

object MHEffects {

	fun register(event: RegistryEvent.Register<Effect>) {
		effect("antidote", AntidoteEffect())
		effect("paralysis", ParalysisEffect())
	}

	private fun effect(name: String, effect: Effect) = ForgeRegistries.POTIONS.register(effect.setRegistryName(name))
}