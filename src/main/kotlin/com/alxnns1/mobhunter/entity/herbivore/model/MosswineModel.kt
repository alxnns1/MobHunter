package com.alxnns1.mobhunter.entity.herbivore.model

import com.alxnns1.mobhunter.entity.herbivore.MosswineEntity
import net.minecraft.client.renderer.entity.model.QuadrupedModel
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.util.math.MathHelper

class MosswineModel(scale: Float = 0F) : QuadrupedModel<MosswineEntity>(6, scale, false, 4.0f, 4.0f, 2.0f, 2.0f, 24) {

	init {
		headModel = ModelRenderer(this, 0, 0).apply {
			addBox(-4.0f, -3.5f, -8.0f, 8.0f, 7.0f, 8.0f, scale)
			setRotationPoint(0.0f, 13.0F, -6.0f)
			setTextureOffset(16, 16).addBox(-2.0f, 0.0f, -10.0f, 4.0f, 3.0f, 2.0f, scale)
			setTextureOffset(24, 0).addBox(-3.0f, -4.5f, -7.0f, 6.0f, 1.0f, 6.0f, scale)
		}
	}

	override fun setRotationAngles(entityIn: MosswineEntity, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {
		headModel.rotateAngleX = (headPitch + 30) * (Math.PI.toFloat() / 180f)
		headModel.rotateAngleY = netHeadYaw * (Math.PI.toFloat() / 180f)
		body.rotateAngleX = Math.PI.toFloat() / 2f
		legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
		legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount
		legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount
		legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
	}
}