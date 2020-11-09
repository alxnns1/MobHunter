package com.alxnns1.mobhunter.entities.neopterans.renderer;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entities.neopterans.HornetaurEntity;
import com.alxnns1.mobhunter.entities.neopterans.model.HornetaurModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class HornetaurRenderer extends MobRenderer<HornetaurEntity, HornetaurModel<HornetaurEntity>> {
	public HornetaurRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HornetaurModel<>(), 0.5f);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull HornetaurEntity entity) {
		return new ResourceLocation(MobHunter.MOD_ID, "textures/entity/hornetaur.png");
	}
}
