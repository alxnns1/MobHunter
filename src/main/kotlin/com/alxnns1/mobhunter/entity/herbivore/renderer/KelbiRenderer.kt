package com.alxnns1.mobhunter.entity.herbivore.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHRenderer
import com.alxnns1.mobhunter.entity.herbivore.KelbiEntity
import com.alxnns1.mobhunter.entity.herbivore.model.KelbiModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.util.ResourceLocation

private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/kelbi.png")

class KelbiRenderer(rendererManager: EntityRendererManager) : MHRenderer<KelbiEntity, KelbiModel>(rendererManager, KelbiModel(), 1.0F) {

	override fun getEntityTexture(entity: KelbiEntity): ResourceLocation = RL
}
