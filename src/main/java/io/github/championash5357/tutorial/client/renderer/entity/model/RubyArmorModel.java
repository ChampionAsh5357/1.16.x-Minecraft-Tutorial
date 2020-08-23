package io.github.championash5357.tutorial.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class RubyArmorModel extends BipedModel<LivingEntity> {

	public RubyArmorModel(float modelSize) {
		super(modelSize, 0.0F, 64, 64);

		float xScale = (float)(1.0/4.0) * modelSize,
				yScale = (float)(1.0/6.0) * modelSize,
				zScale = modelSize;
		
		ModelRenderer rightBodySpike1 = new ModelRenderer(this);
		rightBodySpike1.setRotationPoint(-2.0F - xScale, 22.0F + yScale, 1.0F + zScale);
		bipedBody.addChild(rightBodySpike1);
		setRotationAngle(rightBodySpike1, 0.0F, -0.2618F, 0.0F);
		rightBodySpike1.setTextureOffset(0, 32).addBox(0.0F, -16.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);

		ModelRenderer leftBodySpike1 = new ModelRenderer(this);
		leftBodySpike1.setRotationPoint(2.0F + xScale, 22.0F + yScale, 1.0F + zScale);
		bipedBody.addChild(leftBodySpike1);
		setRotationAngle(leftBodySpike1, 0.0F, 0.2618F, 0.0F);
		leftBodySpike1.setTextureOffset(0, 32).addBox(-1.0F, -16.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);

		ModelRenderer rightBodySpike2 = new ModelRenderer(this);
		rightBodySpike2.setRotationPoint(-2.0F - xScale, 22.0F + yScale, 1.0F + zScale);
		bipedBody.addChild(rightBodySpike2);
		setRotationAngle(rightBodySpike2, 0.0873F, -0.1745F, 0.0F);
		rightBodySpike2.setTextureOffset(0, 32).addBox(0.0F, -20.0F, 1.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);

		ModelRenderer leftBodySpike2 = new ModelRenderer(this);
		leftBodySpike2.setRotationPoint(2.0F + xScale, 22.0F + yScale, 1.0F + zScale);
		bipedBody.addChild(leftBodySpike2);
		setRotationAngle(leftBodySpike2, 0.0873F, 0.1745F, 0.0F);
		leftBodySpike2.setTextureOffset(0, 32).addBox(-1.0F, -20.0F, 1.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);
		
		ModelRenderer rightLegSpike1 = new ModelRenderer(this);
		rightLegSpike1.setRotationPoint(-0.1F - xScale, 10.0F + yScale, 1.0F + zScale);
		bipedRightLeg.addChild(rightLegSpike1);
		setRotationAngle(rightLegSpike1, -0.1745F, -0.1745F, 0.0F);
		rightLegSpike1.setTextureOffset(10, 32).addBox(0.0F, -6.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);

		ModelRenderer rightLegSpike2 = new ModelRenderer(this);
		rightLegSpike2.setRotationPoint(-0.1F - xScale, 10.0F + yScale, 1.0F + zScale);
		bipedRightLeg.addChild(rightLegSpike2);
		setRotationAngle(rightLegSpike2, -0.0873F, -0.0873F, 0.0F);
		rightLegSpike2.setTextureOffset(10, 32).addBox(0.0F, -10.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);

		ModelRenderer leftLegSpike1 = new ModelRenderer(this);
		leftLegSpike1.setRotationPoint(0.1F + xScale, 10.0F + yScale, 1.0F + zScale);
		bipedLeftLeg.addChild(leftLegSpike1);
		setRotationAngle(leftLegSpike1, -0.1745F, 0.1745F, 0.0F);
		leftLegSpike1.setTextureOffset(10, 32).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);

		ModelRenderer leftLegSpike2 = new ModelRenderer(this);
		leftLegSpike2.setRotationPoint(0.1F + xScale, 10.0F + yScale, 1.0F + zScale);
		bipedLeftLeg.addChild(leftLegSpike2);
		setRotationAngle(leftLegSpike2, -0.0873F, 0.0873F, 0.0F);
		leftLegSpike2.setTextureOffset(10, 32).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);
		
		ModelRenderer rightBootSpike = new ModelRenderer(this);
		rightBootSpike.setRotationPoint(-0.1F - xScale, 10.0F + yScale, 1.0F + zScale);
		bipedRightLeg.addChild(rightBootSpike);
		setRotationAngle(rightBootSpike, -0.3491F, -0.2618F, 0.0F);
		rightBootSpike.setTextureOffset(0, 32).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);
		
		ModelRenderer leftBootSpike = new ModelRenderer(this);
		leftBootSpike.setRotationPoint(0.1F + xScale, 10.0F + yScale, 1.0F + zScale);
		bipedLeftLeg.addChild(leftBootSpike);
		setRotationAngle(leftBootSpike, -0.3491F, 0.2618F, 0.0F);
		leftBootSpike.setTextureOffset(0, 32).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 4.0F, xScale, yScale, zScale);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}