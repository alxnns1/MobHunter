package com.alxnns1.mobhunter.entity.herbivore.model

import com.alxnns1.mobhunter.entity.herbivore.PopoEntity
import com.google.common.collect.ImmutableList
import net.minecraft.client.renderer.entity.model.AgeableModel
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.util.math.MathHelper
import kotlin.math.PI
import kotlin.math.abs

class PopoModel : AgeableModel<PopoEntity>() {

	init {
		textureHeight = 128
		textureWidth = 256
	}

	private var head = ModelRenderer(this, 180, 78).apply {
		addBox(-11f, -11f, -14f, 22f, 22f, 16f)
		setRotationPoint(0f, -7f, -26f)
	}

	private var tuskRight1 = ModelRenderer(this, 144, 100).apply {
		addBox(-3f, 0f, -14f, 6f, 3f, 16f)
		setRotationPoint(-7f, 7f, -12f)
		head.addChild(this)
	}

	private var tuskRight2 = ModelRenderer(this, 124, 94).apply {
		addBox(-4f, -3f, -10f, 8f, 3f, 10f)
		setRotationPoint(0f, 3f, -14f)
		tuskRight1.addChild(this)
	}

	private var tuskRight3 = ModelRenderer(this, 84, 94).apply {
		addBox(-5f, -3f, -10f, 10f, 3f, 10f)
		setRotationPoint(0f, 0f, -10f)
		tuskRight2.addChild(this)
	}

	private var tuskLeft1 = ModelRenderer(this, 144, 100).apply {
		addBox(-3f, 0f, -14f, 6f, 3f, 16f)
		setRotationPoint(7f, 7f, -12f)
		head.addChild(this)
	}

	private var tuskLeft2 = ModelRenderer(this, 124, 94).apply {
		addBox(-4f, -3f, -10f, 8f, 3f, 10f)
		setRotationPoint(0f, 3f, -14f)
		tuskLeft1.addChild(this)
	}

	private var tuskLeft3 = ModelRenderer(this, 84, 94).apply {
		addBox(-5f, -3f, -10f, 10f, 3f, 10f)
		setRotationPoint(0f, 0f, -10f)
		tuskLeft2.addChild(this)
	}

	private var body = ModelRenderer(this, 0, 0).apply {
		addBox(-21f, -38f, -40f, 42f, 38f, 32f)
		setRotationPoint(0f, 4f, 14f)
		setTextureOffset(116, 0).addBox(-16f, -44f, -34f, 32f, 6f, 22f)
		setTextureOffset(148, 28).addBox(-19f, -32f, -8f, 38f, 32f, 10f)
		setTextureOffset(0, 70).addBox(-16f, -26f, 2f, 32f, 26f, 10f)
	}

	private var tail = ModelRenderer(this, 202, 0).apply {
		addBox(-5f, 0f, 0f, 10f, 3f, 10f)
		setRotationPoint(0f, -26f, 12f)
		body.addChild(this)
	}

	private var legFrontRight = ModelRenderer(this, 84, 70).apply {
		addBox(-5f, -2f, -5f, 10f, 14f, 10f)
		setRotationPoint(-15f, 0f, -34f)
		setTextureOffset(124, 70).addBox(-8f, 12f, -8f, 16f, 8f, 16f)
		body.addChild(this)
	}

	private var legFrontLeft = ModelRenderer(this, 84, 70).apply {
		addBox(-5f, -2f, -5f, 10f, 14f, 10f)
		setRotationPoint(15f, 0f, -34f)
		setTextureOffset(124, 70).addBox(-8f, 12f, -8f, 16f, 8f, 16f)
		body.addChild(this)
	}

	private var legBackRight = ModelRenderer(this, 84, 70).apply {
		addBox(-5f, -2f, -5f, 10f, 14f, 10f)
		setRotationPoint(-10f, 0f, 6f)
		setTextureOffset(124, 70).addBox(-8f, 12f, -8f, 16f, 8f, 16f)
		body.addChild(this)
	}

	private var legBackLeft = ModelRenderer(this, 84, 70).apply {
		addBox(-5f, -2f, -5f, 10f, 14f, 10f)
		setRotationPoint(10f, 0f, 6f)
		setTextureOffset(124, 70).addBox(-8f, 12f, -8f, 16f, 8f, 16f)
		body.addChild(this)
	}

	override fun getHeadParts(): ImmutableList<ModelRenderer> = ImmutableList.of()

	override fun getBodyParts(): ImmutableList<ModelRenderer> = ImmutableList.of(head, body)

	override fun setRotationAngles(entityIn: PopoEntity, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {
		head.rotateAngleX = headPitch * PI.toFloat() / 180f
		head.rotateAngleY = netHeadYaw * PI.toFloat() / 180f
		tuskRight1.rotateAngleY = PI.toFloat() / 12f
		tuskRight2.rotateAngleX = -PI.toFloat() / 4f
		tuskRight3.rotateAngleX = -PI.toFloat() / 4f
		tuskLeft1.rotateAngleY = -PI.toFloat() / 12f
		tuskLeft2.rotateAngleX = -PI.toFloat() / 4f
		tuskLeft3.rotateAngleX = -PI.toFloat() / 4f
		legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
		legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + PI.toFloat()) * 1.4f * limbSwingAmount
		legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + PI.toFloat()) * 1.4f * limbSwingAmount
		legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
		tail.rotateAngleX = abs(MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount) / 2f - PI.toFloat() / 3f
	}
}