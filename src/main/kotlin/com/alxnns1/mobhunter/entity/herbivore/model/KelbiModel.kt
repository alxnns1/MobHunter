package com.alxnns1.mobhunter.entity.herbivore.model

import com.alxnns1.mobhunter.entity.herbivore.KelbiEntity
import com.google.common.collect.ImmutableList
import net.minecraft.client.renderer.entity.model.AgeableModel
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.util.math.MathHelper
import kotlin.math.PI
import kotlin.math.abs

//isChildHeadScaled, childHeadOffsetY, childHeadOffsetZ, childHeadScale, childBodyScale, childBodyOffsetY
class KelbiModel : AgeableModel<KelbiEntity>(true, 4f, 4f, 2f, 2f, 24f) {

	init {
		textureHeight = 64
		textureWidth = 64
	}

	private var neck = ModelRenderer(this, 0, 23).apply {
		addBox(-2f, -2f, -4f, 4f, 4f, 6f)
		setRotationPoint(0f, -8f, -15f)
		rotateAngleX = -PI.toFloat() / 4
		body.addChild(this)
	}

	private var head = ModelRenderer(this, 31, 0).apply {
		addBox(-2f, -2f, -4f, 4f, 8f, 4f)
		setRotationPoint(0f, 0f, -4f)
		neck.addChild(this)
	}

	private var ear1 = ModelRenderer(this, 31, 12).apply {
		addBox(-3f, 0f, -1f, 3f, 1f, 2f)
		setRotationPoint(-2f, -1f, -3f)
		rotateAngleX = PI.toFloat() / 4
		head.addChild(this)
	}

	private var ear2 = ModelRenderer(this, 31, 12).apply {
		mirror = true
		addBox(0f, 0f, -1f, 3f, 1f, 2f)
		setRotationPoint(2f, -1f, -3f)
		rotateAngleX = PI.toFloat() / 4
		head.addChild(this)
	}

	private var h1 = ModelRenderer(this, 0, 23).apply {
		addBox(0f, 0f, 0f, 1f, 2f, 2f)
		setRotationPoint(-2f, 0f, -6f)
		head.addChild(this)
	}

	private var h2 = ModelRenderer(this, 0, 23).apply {
		mirror = true
		addBox(0f, 0f, 0f, 1f, 2f, 2f)
		setRotationPoint(1f, 0f, -6f)
		head.addChild(this)
	}

	private var h3 = ModelRenderer(this, 9, 0).apply {
		addBox(0f, 0f, 0f, 1f, 1f, 2f)
		setRotationPoint(0f, 0f, -2f)
		h1.addChild(this)
	}

	private var h4 = ModelRenderer(this, 9, 0).apply {
		addBox(0f, 0f, 0f, 1f, 1f, 2f)
		setRotationPoint(0f, 0f, -2f)
		h2.addChild(this)
	}

	private var body = ModelRenderer(this, 0, 0).apply {
		addBox(-4f, -8f, -15f, 8f, 8f, 15f)
		setRotationPoint(0f, 14f, 7.5f)
	}

	private var leg1 = ModelRenderer(this, 0, 0).apply {
		addBox(-1.5f, 0f, -1.5f, 3f, 10f, 3f)
		setRotationPoint(-2.5f, 0f, -13.5f)
		body.addChild(this)
	}

	private var leg2 = ModelRenderer(this, 0, 0).apply {
		mirror = true
		addBox(-1.5f, 0f, -1.5f, 3f, 10f, 3f)
		setRotationPoint(2.5f, 0f, -13.5f)
		body.addChild(this)
	}

	private var leg3 = ModelRenderer(this, 0, 0).apply {
		addBox(-1.5f, 0f, -1.5f, 3f, 10f, 3f)
		setRotationPoint(-2.5f, 0f, -1.5f)
		body.addChild(this)
	}

	private var leg4 = ModelRenderer(this, 0, 0).apply {
		mirror = true
		addBox(-1.5f, 0f, -1.5f, 3f, 10f, 3f)
		setRotationPoint(2.5f, 0f, -1.5f)
		body.addChild(this)
	}

	private var tail = ModelRenderer(this, 20, 23).apply {
		addBox(-1.5f, 0f, -1f, 3f, 7f, 1f)
		setRotationPoint(0f, -8f, 0f)
		rotateAngleX = PI.toFloat() / 6
		body.addChild(this)
	}

	override fun setRotationAngles(entityIn: KelbiEntity, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {
		head.rotateAngleX = headPitch / (180f / PI.toFloat())
		neck.rotateAngleY = netHeadYaw / (180f / PI.toFloat())
		leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
		leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + PI.toFloat()) * 1.4f * limbSwingAmount
		leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + PI.toFloat()) * 1.4f * limbSwingAmount
		leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
		tail.rotateAngleX = abs(MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount) / 2 + PI.toFloat() / 6
	}

	override fun getHeadParts(): MutableIterable<ModelRenderer> =
		ImmutableList.of(head, h1, h2, h3, h4, ear1, ear2)

	override fun getBodyParts(): MutableIterable<ModelRenderer> =
		ImmutableList.of(body, leg1, leg2, leg3, leg4, tail, neck)

}