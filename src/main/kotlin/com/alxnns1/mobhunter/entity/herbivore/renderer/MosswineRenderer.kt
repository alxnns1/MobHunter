package com.alxnns1.mobhunter.entity.herbivore.renderer

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.MHRenderer
import com.alxnns1.mobhunter.entity.herbivore.MosswineEntity
import com.alxnns1.mobhunter.entity.herbivore.model.MosswineModel
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.util.ResourceLocation

private val RL = ResourceLocation(MobHunter.MOD_ID, "textures/entity/mosswine.png")

class MosswineRenderer(rendererManager: EntityRendererManager) : MHRenderer<MosswineEntity, MosswineModel>(rendererManager, MosswineModel(), 1.0F) {

	override fun getEntityTexture(entity: MosswineEntity): ResourceLocation = RL
}
