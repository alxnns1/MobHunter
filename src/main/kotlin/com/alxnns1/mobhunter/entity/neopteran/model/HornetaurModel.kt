package com.alxnns1.mobhunter.entity.neopteran.model

import com.alxnns1.mobhunter.entity.neopteran.HornetaurEntity
import com.mojang.blaze3d.matrix.MatrixStack
import com.mojang.blaze3d.vertex.IVertexBuilder
import net.minecraft.client.renderer.entity.model.EntityModel
import net.minecraft.client.renderer.model.ModelRenderer

class HornetaurModel : EntityModel<HornetaurEntity>() {
	val thorax = ModelRenderer(this, 0, 0).apply {
		addBox(-2.5F, 0F, 0F, 5F, 4F, 4F)
//		addBox(-2.5F, 3F, -5.5F, 5F, 4F, 4F)
		setRotationPoint(0F, 0F, 0F)
	}
//	val abdomen1 = ModelRenderer(this@HornetaurModel, 0, 0).apply {
//		addBox(-0.5F, 0F, 4F, 6F, 4F, 8F)
//		setRotationPoint(0F, 0F, 2F)
//		thorax.addChild(this)
//	}

//	val abdomen2
//	val abdomen3
//	val abdomen4
//	val head
//	val horn_upper1
//	val horn_upper2
//	val horn_lower1
//	val horn_lower2
//	val leg_left1_femur
//	val leg_left2_femur
//	val leg_left3_femur
//	val leg_right1_femur
//	val leg_right2_femur
//	val leg_right3_femur
//	val leg_left1_tibia
//	val leg_left2_tibia
//	val leg_left3_tibia
//	val leg_right1_tibia
//	val leg_right2_tibia
//	val leg_right3_tibia

	init {
		textureHeight = 64
		textureWidth = 64
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
	): Unit = thorax.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha)

	override fun setRotationAngles(
		entity: HornetaurEntity,
		limbSwing: Float,
		limbSwingAmount: Float,
		ageTicks: Float,
		headYaw: Float,
		headPitch: Float
	) {
//		abdomen1.rotateAngleX = ageTicks
	}
}
