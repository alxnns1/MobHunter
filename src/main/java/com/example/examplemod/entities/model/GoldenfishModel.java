package com.example.examplemod.entities.model;

import com.example.examplemod.entities.GoldenfishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GoldenfishModel<E extends GoldenfishEntity> extends EntityModel<E> {
	private final ModelRenderer head;
	private final ModelRenderer bodyFront;
	private final ModelRenderer finRight;
	private final ModelRenderer finLeft;
	private final ModelRenderer bodyRear;

	public GoldenfishModel() {
		this.textureWidth = 32;
		this.textureHeight = 32;

		this.head = new ModelRenderer(this, 22, 0);
		this.head.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F);
		this.head.setRotationPoint(0.0F, 20.0F, -7.0F);

		this.bodyFront = new ModelRenderer(this, 0, 0);
		this.bodyFront.addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 8.0F);
		this.bodyFront.setRotationPoint(0.0F, 20.0F, -7.0F);

		ModelRenderer dorsalFinFront = new ModelRenderer(this, 2, 1);
		dorsalFinFront.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F);
		dorsalFinFront.setRotationPoint(0.0F, -4.5F, 5.0F);
		this.bodyFront.addChild(dorsalFinFront);

		this.finRight = new ModelRenderer(this, -4, 0);
		this.finRight.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F);
		this.finRight.setRotationPoint(-1.5F, 21.5F, -7.0F);
		this.finRight.rotateAngleZ = (-(float) Math.PI / 4F);

		this.finLeft = new ModelRenderer(this, 0, 0);
		this.finLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F);
		this.finLeft.setRotationPoint(1.5F, 21.5F, -7.0F);
		this.finLeft.rotateAngleZ = ((float) Math.PI / 4F);

		this.bodyRear = new ModelRenderer(this, 0, 13);
		this.bodyRear.addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 8.0F);
		this.bodyRear.setRotationPoint(0.0F, 20.0F, 1.0F);

		ModelRenderer dorsalFinRear = new ModelRenderer(this, 0, 2);
		dorsalFinRear.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F);
		dorsalFinRear.setRotationPoint(0.0F, -4.5F, -1.0F);
		this.bodyRear.addChild(dorsalFinRear);

		ModelRenderer tail = new ModelRenderer(this, 20, 10);
		tail.addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 6.0F);
		tail.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.bodyRear.addChild(tail);
	}

	@Override
	public void setRotationAngles(E entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		float f1 = 1.0F;
		if (!entityIn.isInWater()) {
			f = 1.3F;
			f1 = 1.7F;
		}

		this.bodyRear.rotateAngleY = -f * 0.25F * MathHelper.sin(f1 * 0.6F * ageInTicks);
	}

	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.bodyFront.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		this.bodyRear.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		this.head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		this.finRight.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		this.finLeft.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
