package com.example.examplemod.entities.renderer;

import com.example.examplemod.MobHunter;
import com.example.examplemod.entities.SushifishEntity;
import com.example.examplemod.entities.model.SushifishModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class SushifishRenderer extends MobRenderer<SushifishEntity, SushifishModel<SushifishEntity>> {
	public SushifishRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SushifishModel<>(), 0.5f);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull SushifishEntity entity) {
		return new ResourceLocation(MobHunter.MOD_ID, "textures/entity/sushifish.png");
	}
}
