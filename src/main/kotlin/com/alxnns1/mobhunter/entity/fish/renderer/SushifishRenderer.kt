package com.alxnns1.mobhunter.entity.fish.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHRenderer
import com.alxnns1.mobhunter.entity.fish.SushifishEntity
import com.alxnns1.mobhunter.entity.fish.model.SushifishModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.util.ResourceLocation

private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/sushifish.png")

class SushifishRenderer(rendererManager: EntityRendererManager) : MHRenderer<SushifishEntity, SushifishModel>(rendererManager, SushifishModel(), 0.5F) {

	override fun getEntityTexture(entity: SushifishEntity): ResourceLocation = RL
}
