package com.alxnns1.mobhunter.entity.neopteran.model

import com.alxnns1.mobhunter.entity.neopteran.HornetaurEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.client.renderer.entity.model.EntityModel
import net.minecraft.client.renderer.model.ModelRenderer
import kotlin.math.PI

class HornetaurModel : EntityModel<HornetaurEntity>() {

	init {
		textureHeight = 64
		textureWidth = 64
	}

	private val thorax = ModelRenderer(this, 0, 29).apply {
		addBox(-2.5F, 0F, 0F, 5F, 4F, 4F)
		setRotationPoint(0F, 19F, -5.5F)
	}
	private val abdomen1 = ModelRenderer(this@HornetaurModel, 0, 18).apply {
		addBox(-3F, 0F, 0F, 6F, 4F, 7F)
		setRotationPoint(0F, 19F, -1.5F)
	}
	private val abdomen2 = ModelRenderer(this@HornetaurModel, 25, 0).apply {
		addBox(-2.5F, 0F, 0F, 5F, 4F, 4F)
		setRotationPoint(0F, 19F, 5.5F)
	}
	private val abdomen3 = ModelRenderer(this@HornetaurModel, 0, 0).apply {
		addBox(-2F, -3F, 0F, 4F, 3F, 3F)
		setRotationPoint(0F, 22.5F, 9.5F)
		rotateAngleX = 5 * PI.toFloat() / 180
		addChild( //abdomen4
			ModelRenderer(this@HornetaurModel, 30, 33).apply {
				addBox(-1F, -2F, 0F, 2F, 2F, 2F)
				setRotationPoint(0F, -0.5F, 3F)
				rotateAngleX = 5 * PI.toFloat() / 180
			})
		addChild( //feelers
			ModelRenderer(this@HornetaurModel, 32, 34).apply {
				addBox(-4F, 0F, 0F, 8F, 0F, 6F)
				setRotationPoint(0F, -1.5F, 3F)
				rotateAngleX = 5 * PI.toFloat() / 180
			})
	}
	private val wingLeft = ModelRenderer(this@HornetaurModel, 26, 0).apply {
		addBox(0F, 0F, 0F, 4F, 0F, 17F)
		setRotationPoint(0F, 18.9F, -3.5F)
	}
	private val wingRight = ModelRenderer(this@HornetaurModel, 26, 17).apply {
		addBox(-4F, 0F, 0F, 4F, 0F, 17F)
		setRotationPoint(0F, 18.9F, -3.5F)
	}
	private val elytraLeft = ModelRenderer(this@HornetaurModel, 0, 0).apply {
		addBox(0F, 0F, 0F, 4F, 0F, 17F)
		setRotationPoint(0F, 18.8F, -3.5F)
	}
	private val elytraRight = ModelRenderer(this@HornetaurModel, 8, 8).apply {
		addBox(-4F, 0F, 0F, 4F, 0F, 17F)
		setRotationPoint(0F, 18.8F, -3.5F)
	}
	private val head = ModelRenderer(this@HornetaurModel, 21, 25).apply {
		addBox(-2F, -2F, -5F, 4F, 3F, 5F)
		setRotationPoint(0F, 20F, -3.5F)
		rotateAngleX = 15 * PI.toFloat() / 180
		addChild( //hornUpper1
			ModelRenderer(this@HornetaurModel, 6, 6).apply {
				addBox(-1F, -6F, -2F, 2F, 6F, 2F)
				setRotationPoint(0F, -2F, 0F)
				rotateAngleX = 45 * PI.toFloat() / 180
				addChild( //hornUpper2
					ModelRenderer(this@HornetaurModel, 0, 6).apply {
						addBox(-0.5F, -8F, -2F, 1F, 8F, 2F)
						setRotationPoint(0F, -6F, 0F)
						rotateAngleX = 37.5F * PI.toFloat() / 180
					})
			})
		addChild( //hornLower1
			ModelRenderer(this@HornetaurModel, 4, 14).apply {
				addBox(-0.5F, -1F, -3F, 1F, 1F, 3F)
				setRotationPoint(0F, 0F, -5F)
				rotateAngleX = -7.5F * PI.toFloat() / 180
				addChild( //hornLower2
					ModelRenderer(this@HornetaurModel, 11, 0).apply {
						addBox(-0.5F, -1F, -2F, 1F, 1F, 2F)
						setRotationPoint(0F, 0F, -3F)
						rotateAngleX = -22.5F * PI.toFloat() / 180
					})
			})
	}
	private val legLeft1Femur = ModelRenderer(this@HornetaurModel, 12, 37).apply {
		addBox(-0.5F, 0F, -0.5F, 1F, 4F, 1F)
		setRotationPoint(2.5F, 22F, -4.5F)
		rotateAngleX = -15F * PI.toFloat() / 180
		rotateAngleY = -30F * PI.toFloat() / 180
		rotateAngleZ = -135F * PI.toFloat() / 180
		addChild( //legLeft1Tibia
			ModelRenderer(this@HornetaurModel, 34, 24).apply {
				addBox(-0.5F, 0F, -0.5F, 1F, 5F, 1F)
				setRotationPoint(0F, 4F, 0F)
				rotateAngleZ = 120F * PI.toFloat() / 180
				addChild( //legLeft1Tarsus
					ModelRenderer(this@HornetaurModel, 9, 14).apply {
						addBox(-0.5F, -0.5F, -0.5F, 3F, 1F, 1F)
						setRotationPoint(0F, 5F, 0F)
						rotateAngleZ = 30F * PI.toFloat() / 180
					})
			})
	}
	private val legLeft2Femur = ModelRenderer(this@HornetaurModel, 12, 37).apply {
		addBox(-0.5F, 0F, -0.5F, 1F, 4F, 1F)
		setRotationPoint(2.5F, 22F, -3.5F)
		rotateAngleX = 15F * PI.toFloat() / 180
		rotateAngleY = 30F * PI.toFloat() / 180
		rotateAngleZ = -135F * PI.toFloat() / 180
		addChild( //legLeft2Tibia
			ModelRenderer(this@HornetaurModel, 34, 24).apply {
				addBox(-0.5F, 0F, -0.5F, 1F, 5F, 1F)
				setRotationPoint(0F, 4F, 0F)
				rotateAngleZ = 120F * PI.toFloat() / 180
				addChild( //legLeft2Tarsus
					ModelRenderer(this@HornetaurModel, 9, 14).apply {
						addBox(-0.5F, -0.5F, -0.5F, 3F, 1F, 1F)
						setRotationPoint(0F, 5F, 0F)
						rotateAngleZ = 30F * PI.toFloat() / 180
					})
			})
	}
	private val legLeft3Femur = ModelRenderer(this@HornetaurModel, 26, 33).apply {
		addBox(-0.5F, 0F, -0.5F, 1F, 8F, 1F)
		setRotationPoint(3F, 22F, -0.5F)
		rotateAngleX = 30F * PI.toFloat() / 180
		rotateAngleY = 45F * PI.toFloat() / 180
		rotateAngleZ = -135F * PI.toFloat() / 180
		addChild( //legLeft3Tibia
			ModelRenderer(this@HornetaurModel, 22, 33).apply {
				addBox(-0.5F, 0F, -0.5F, 1F, 9F, 1F)
				setRotationPoint(0F, 8F, 0F)
				rotateAngleZ = 135F * PI.toFloat() / 180
				addChild( //legLeft3Tarsus
					ModelRenderer(this@HornetaurModel, 33, 14).apply {
						addBox(-0.5F, -0.5F, -0.5F, 3F, 1F, 1F)
						setRotationPoint(0F, 9F, 0F)
						rotateAngleZ = 15F * PI.toFloat() / 180
					})
			})
	}
	private val legRight1Femur = ModelRenderer(this@HornetaurModel, 8, 37).apply {
		addBox(-0.5F, 0F, -0.5F, 1F, 4F, 1F)
		setRotationPoint(-2.5F, 22F, -4.5F)
		rotateAngleX = -15F * PI.toFloat() / 180
		rotateAngleY = 30F * PI.toFloat() / 180
		rotateAngleZ = 135F * PI.toFloat() / 180
		addChild( //legRight1Tibia
			ModelRenderer(this@HornetaurModel, 19, 19).apply {
				addBox(-0.5F, 0F, -0.5F, 1F, 5F, 1F)
				setRotationPoint(0F, 4F, 0F)
				rotateAngleZ = -120F * PI.toFloat() / 180
				addChild( //legLeft1Tarsus
					ModelRenderer(this@HornetaurModel, 33, 10).apply {
						addBox(-2.5F, -0.5F, -0.5F, 3F, 1F, 1F)
						setRotationPoint(0F, 5F, 0F)
						rotateAngleZ = -30F * PI.toFloat() / 180
					})
			})
	}
	private val legRight2Femur = ModelRenderer(this@HornetaurModel, 4, 37).apply {
		addBox(-0.5F, 0F, -0.5F, 1F, 4F, 1F)
		setRotationPoint(-2.5F, 22F, -3.5F)
		rotateAngleX = 15F * PI.toFloat() / 180
		rotateAngleY = -30F * PI.toFloat() / 180
		rotateAngleZ = 135F * PI.toFloat() / 180
		addChild( //legRight2Tibia
			ModelRenderer(this@HornetaurModel, 33, 18).apply {
				addBox(-0.5F, 0F, -0.5F, 1F, 5F, 1F)
				setRotationPoint(0F, 4F, 0F)
				rotateAngleZ = -120F * PI.toFloat() / 180
				addChild( //legRight2Tarsus
					ModelRenderer(this@HornetaurModel, 33, 12).apply {
						addBox(-2.5F, -0.5F, -0.5F, 3F, 1F, 1F)
						setRotationPoint(0F, 5F, 0F)
						rotateAngleZ = -30F * PI.toFloat() / 180
					})
			})
	}
	private val legRight3Femur = ModelRenderer(this@HornetaurModel, 0, 16).apply {
		addBox(-0.5F, 0F, -0.5F, 1F, 8F, 1F)
		setRotationPoint(-3F, 22F, -0.5F)
		rotateAngleX = 30F * PI.toFloat() / 180
		rotateAngleY = -45F * PI.toFloat() / 180
		rotateAngleZ = 135F * PI.toFloat() / 180
		addChild( //legRight3Tibia
			ModelRenderer(this@HornetaurModel, 18, 32).apply {
				addBox(-0.5F, 0F, -0.5F, 1F, 9F, 1F)
				setRotationPoint(0F, 8F, 0F)
				rotateAngleZ = -135F * PI.toFloat() / 180
				addChild( //legRight3Tarsus
					ModelRenderer(this@HornetaurModel, 33, 16).apply {
						addBox(-2.5F, -0.5F, -0.5F, 3F, 1F, 1F)
						setRotationPoint(0F, 9F, 0F)
						rotateAngleZ = -30F * PI.toFloat() / 180
					})
			})
	}

	override fun render(
		matrixStack: MatrixStack,
		buffer: IVertexBuilder,
		packedLight: Int,
		packedOverlay: Int,
		red: Float,
		green: Float,
		blue: Float,
		alpha: Float
	) {
		thorax.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		abdomen1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		abdomen2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		abdomen3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		wingLeft.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		wingRight.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		elytraLeft.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		elytraRight.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		legLeft1Femur.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		legLeft2Femur.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		legLeft3Femur.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		legRight1Femur.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		legRight2Femur.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		legRight3Femur.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
	}

	override fun setRotationAngles(
		entity: HornetaurEntity,
		limbSwing: Float,
		limbSwingAmount: Float,
		ageTicks: Float,
		headYaw: Float,
		headPitch: Float
	) {
		this.head.rotateAngleY = headYaw * (PI.toFloat() / 180f)
//		this.head.rotateAngleX = headPitch * (PI.toFloat() / 180f)
	}
}
