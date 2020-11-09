package com.alxnns1.mobhunter.entities.neopterans.model;

import com.alxnns1.mobhunter.entities.neopterans.HornetaurEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HornetaurModel<E extends HornetaurEntity> extends EntityModel<E> {
	public ModelRenderer thorax;
	public ModelRenderer abdomen1;
	public ModelRenderer abdomen2;
	public ModelRenderer abdomen3;
	public ModelRenderer abdomen4;
	public ModelRenderer head;
	public ModelRenderer horn_upper1;
	public ModelRenderer horn_upper2;
	public ModelRenderer horn_lower1;
	public ModelRenderer horn_lower2;
	public ModelRenderer leg_left1_femur;
	public ModelRenderer leg_left2_femur;
	public ModelRenderer leg_left3_femur;
	public ModelRenderer leg_right1_femur;
	public ModelRenderer leg_right2_femur;
	public ModelRenderer leg_right3_femur;
	public ModelRenderer leg_left1_tibia;
	public ModelRenderer leg_left2_tibia;
	public ModelRenderer leg_left3_tibia;
	public ModelRenderer leg_right1_tibia;
	public ModelRenderer leg_right2_tibia;
	public ModelRenderer leg_right3_tibia;

	public HornetaurModel() {
		this.textureHeight = 64;
		this.textureWidth = 64;

		this.thorax = new ModelRenderer(this, 0, 0);
		this.thorax.addBox(-2.5f, 0f, 0f, 5, 4, 4);
//		this.thorax.addBox(-2.5f, 3f, -5.5f, 5, 4, 4);
		this.thorax.setRotationPoint(0f, 0f, 0f);

//		this.abdomen1 = new ModelRenderer(this, 0, 0);
//		this.abdomen1.addBox(-0.5f, 0f, 4f, 6, 4, 8);
//		this.abdomen1.setRotationPoint(0f, 0f, 2f);
//		this.thorax.addChild(abdomen1);
	}
	
	@Override
	public void setRotationAngles(E entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		this.abdomen1.rotateAngleX = ageInTicks;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.thorax.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
