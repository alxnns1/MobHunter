package com.alxnns1.mobhunter.entity.neopteran.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHRenderer
import com.alxnns1.mobhunter.entity.neopteran.HornetaurEntity
import com.alxnns1.mobhunter.entity.neopteran.model.HornetaurModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.util.ResourceLocation

private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/hornetaur.png")

class HornetaurRenderer(rendererManager: EntityRendererManager) : MHRenderer<HornetaurEntity, HornetaurModel>(rendererManager, HornetaurModel(), 0.5F) {

	override fun getEntityTexture(entity: HornetaurEntity): ResourceLocation = RL
}
