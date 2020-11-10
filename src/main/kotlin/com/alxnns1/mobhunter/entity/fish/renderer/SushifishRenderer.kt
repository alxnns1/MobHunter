package com.alxnns1.mobhunter.entity.fish.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.fish.SushifishEntity
import com.alxnns1.mobhunter.entity.fish.model.SushifishModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.client.renderer.entity.MobRenderer
import net.minecraft.util.ResourceLocation

class SushifishRenderer(rendererManager: EntityRendererManager) : MobRenderer<SushifishEntity, SushifishModel>(rendererManager, SushifishModel(), 0.5F) {
	companion object {
		private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/sushifish.png")
	}

	override fun getEntityTexture(entity: SushifishEntity): ResourceLocation = RL
}
