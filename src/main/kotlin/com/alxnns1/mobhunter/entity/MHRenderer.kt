package com.alxnns1.mobhunter.entity

import com.alxnns1.mobhunter.getMHScale
import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.renderer.entity.EntityRendererManager
import net.minecraft.client.renderer.entity.MobRenderer
import net.minecraft.client.renderer.entity.model.EntityModel
import net.minecraft.entity.MobEntity

abstract class MHRenderer<T, M : EntityModel<T>>(
	rendererManager: EntityRendererManager,
	model: M,
	shadowSize: Float
) : MobRenderer<T, M>(rendererManager, model, shadowSize) where T : MobEntity, T : MHEntity {
	override fun preRenderCallback(entity: T, matrixStack: MatrixStack, partialTickTime: Float) {
		if (!entity.hasScale())
			return
		val scale = entity.getMHScale()
		matrixStack.scale(scale, scale, scale)
	}
}
