package com.alxnns1.mobhunter.entity.herbivore.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHRenderer
import com.alxnns1.mobhunter.entity.herbivore.PopoEntity
import com.alxnns1.mobhunter.entity.herbivore.model.PopoModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.util.ResourceLocation

private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/popo.png")

class PopoRenderer(rendererManager: EntityRendererManager) : MHRenderer<PopoEntity, PopoModel>(rendererManager, PopoModel(), 1.0F) {

	override fun getEntityTexture(entity: PopoEntity): ResourceLocation = RL
}
