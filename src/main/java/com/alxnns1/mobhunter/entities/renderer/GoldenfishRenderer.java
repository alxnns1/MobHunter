package com.alxnns1.mobhunter.entities.renderer;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entities.GoldenfishEntity;
import com.alxnns1.mobhunter.entities.model.GoldenfishModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class GoldenfishRenderer extends MobRenderer<GoldenfishEntity, GoldenfishModel<GoldenfishEntity>> {
	public GoldenfishRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoldenfishModel<>(), 0.5f);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull GoldenfishEntity entity) {
		return new ResourceLocation(MobHunter.MOD_ID, "textures/entity/goldenfish.png");
	}
}
