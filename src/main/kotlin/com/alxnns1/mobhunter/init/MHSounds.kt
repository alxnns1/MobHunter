package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundEvent
import net.minecraftforge.event.RegistryEvent
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHSounds {
	val MOSSWINE_AMBIENT: SoundEvent by objectHolder("mosswine_ambient")
	val MOSSWINE_STEP: SoundEvent by objectHolder("mosswine_step")
	val MOSSWINE_HURT: SoundEvent by objectHolder("mosswine_hurt")
	val MOSSWINE_DEATH: SoundEvent by objectHolder("mosswine_death")
	val HORNETAUR_AMBIENT: SoundEvent by objectHolder("hornetaur_ambient")
	val HORNETAUR_STEP: SoundEvent by objectHolder("hornetaur_step")
	val HORNETAUR_HURT: SoundEvent by objectHolder("hornetaur_hurt")
	val HORNETAUR_DEATH: SoundEvent by objectHolder("hornetaur_death")

	fun register(event: RegistryEvent.Register<SoundEvent>) = event.registry.registerAll(
		*entitySounds("mosswine"),
		*entitySounds("hornetaur")
	)

	private fun entitySounds(entityName: String): Array<SoundEvent> {
		return arrayOf(
			SoundEvent(ResourceLocation(MobHunter.MOD_ID, "${entityName}_ambient")).setRegistryName("${entityName}_ambient"),
			SoundEvent(ResourceLocation(MobHunter.MOD_ID, "${entityName}_step")).setRegistryName("${entityName}_step"),
			SoundEvent(ResourceLocation(MobHunter.MOD_ID, "${entityName}_hurt")).setRegistryName("${entityName}_hurt"),
			SoundEvent(ResourceLocation(MobHunter.MOD_ID, "${entityName}_death")).setRegistryName("${entityName}_death")
		)
	}
}