package com.alxnns1.mobhunter.entity.herbivore.model

import com.alxnns1.mobhunter.entity.herbivore.MosswineEntity
import com.google.common.collect.ImmutableList
import net.minecraft.client.renderer.entity.model.AgeableModel
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.util.math.MathHelper

class MosswineModel : AgeableModel<MosswineEntity>(false, 4f, 4f, 2f, 2f, 24f) {

	init {
		textureWidth = 128
		textureHeight = 64
	}

	private val headModel = ModelRenderer(this, 0, 0).apply {
		addBox(-6.0f, -3.5f, -12.0f, 12.0f, 10.0f, 12.0f)
		setRotationPoint(0.0f, 24 - 18.0F, -9.0f)
		setTextureOffset(78, 15).addBox(-3.0f, 0.0f, -15.0f, 6.0f, 4.0f, 3.0f)
		setTextureOffset(0, 26).addBox(-5.0f, -5.5f, -11.0f, 10.0f, 2.0f, 10.0f)
	}

	private var body = ModelRenderer(this, 24, 0).apply {
		addBox(-7.5f, -1.0f, -10.0f, 15.0f, 12.0f, 24.0f)
		setRotationPoint(0.0f, 24 - 20.0f, -1.0f)
	}

	private var legBackRight = ModelRenderer(this, 78, 0).apply {
		addBox(-3.0f, 0.0f, -3.0f, 6.0f, 9.0f, 6.0f)
		setRotationPoint(-4.5f, 24 - 9.0f, 10.0f)
	}

	private var legBackLeft = ModelRenderer(this, 78, 0).apply {
		addBox(-3.0f, 0.0f, -3.0f, 6.0f, 9.0f, 6.0f)
		setRotationPoint(4.5f, 24 - 9.0f, 10.0f)
	}

	private var legFrontRight = ModelRenderer(this, 78, 0).apply {
		addBox(-3.0f, 0.0f, -3.0f, 6.0f, 9.0f, 6.0f)
		setRotationPoint(-4.5f, 24 - 9.0f, -8.0f)
	}

	private var legFrontLeft = ModelRenderer(this, 78, 0).apply {
		addBox(-3.0f, 0.0f, -3.0f, 6.0f, 9.0f, 6.0f)
		setRotationPoint(4.5f, 24 - 9.0f, -8.0f)
	}

	override fun getHeadParts(): ImmutableList<ModelRenderer> =
		ImmutableList.of(headModel)

	override fun getBodyParts(): Iterable<ModelRenderer> =
		ImmutableList.of(body, legBackRight, legBackLeft, legFrontRight, legFrontLeft)

	override fun setRotationAngles(entityIn: MosswineEntity, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {
		headModel.rotateAngleX = (headPitch + 30) * (Math.PI.toFloat() / 180f)
		headModel.rotateAngleY = netHeadYaw * (Math.PI.toFloat() / 180f)
		legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
		legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount
		legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount
		legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
	}
}