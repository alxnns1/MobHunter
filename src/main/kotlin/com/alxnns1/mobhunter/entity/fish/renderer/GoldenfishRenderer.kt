package com.alxnns1.mobhunter.entity.fish.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHRenderer
import com.alxnns1.mobhunter.entity.fish.GoldenfishEntity
import com.alxnns1.mobhunter.entity.fish.model.GoldenfishModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.util.ResourceLocation

private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/goldenfish.png")

class GoldenfishRenderer(rendererManager: EntityRendererManager) : MHRenderer<GoldenfishEntity, GoldenfishModel>(rendererManager, GoldenfishModel(), 0.5F) {

	override fun getEntityTexture(entity: GoldenfishEntity): ResourceLocation = RL
}
