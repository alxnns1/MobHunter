package com.alxnns1.mobhunter.entity.fish.model

import com.alxnns1.mobhunter.entity.fish.SushifishEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.client.renderer.entity.model.EntityModel
import net.minecraft.client.renderer.model.ModelRenderer
import net.minecraft.util.math.MathHelper

class SushifishModel : EntityModel<SushifishEntity>() {
	private val head = ModelRenderer(this, 22, 0).apply {
		addBox(-1F, -2F, -3F, 2F, 4F, 3F)
		setRotationPoint(0F, 20F, -7F)
	}
	private val bodyFront = ModelRenderer(this, 0, 0).apply {
		addBox(-1.5F, -2.5F, 0F, 3F, 5F, 8F)
		setRotationPoint(0F, 20F, -7F)
		addChild(
			// Dorsal fin front
			ModelRenderer(this@SushifishModel, 2, 1).apply {
				addBox(0F, 0F, 0F, 0F, 2F, 3F)
				setRotationPoint(0F, -4.5F, 5F)
			}
		)
	}
	private val finRight = ModelRenderer(this, -4, 0).apply {
		addBox(-2F, 0F, 0F, 2F, 0F, 2F)
		setRotationPoint(-1.5F, 21.5F, -7F)
		rotateAngleZ = (-Math.PI).toFloat() / 4f
	}
	private val finLeft = ModelRenderer(this, 0, 0).apply {
		addBox(0F, 0F, 0F, 2F, 0F, 2F)
		setRotationPoint(1.5F, 21.5F, -7F)
		rotateAngleZ = Math.PI.toFloat() / 4f
	}
	private val bodyRear = ModelRenderer(this, 0, 13).apply {
		addBox(-1.5F, -2.5F, 0F, 3F, 5F, 8F)
		setRotationPoint(0F, 20F, 1F)
		addChild(
			// Dorsal fin rear
			ModelRenderer(this@SushifishModel, 0, 2).apply {
				addBox(0F, 0F, 0F, 0F, 2F, 4F)
				setRotationPoint(0F, -4.5F, -1F)
			}
		)
		addChild(
			// Tail
			ModelRenderer(this@SushifishModel, 20, 10).apply {
				addBox(0F, -2.5F, 0F, 0F, 5F, 6F);
				setRotationPoint(0F, 0F, 8F);
			}
		)
	}

	init {
		textureWidth = 32
		textureHeight = 32
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
		bodyFront.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		bodyRear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		finRight.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
		finLeft.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)
	}

	override fun setRotationAngles(
		entity: SushifishEntity,
		limbSwing: Float,
		limbSwingAmount: Float,
		ageTicks: Float,
		headYaw: Float,
		headPitch: Float
	) {
		var f1 = 1F
		var f2 = 1F
		if (!entity.isInWater) {
			f1 = 1.3F
			f2 = 1.7F
		}
		bodyRear.rotateAngleY = -f1 * 0.25F * MathHelper.sin(f2 * 0.6F * ageTicks)
	}
}
