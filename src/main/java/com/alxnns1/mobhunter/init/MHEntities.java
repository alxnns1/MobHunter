package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entities.GoldenfishEntity;
import com.alxnns1.mobhunter.entities.SushifishEntity;
import com.alxnns1.mobhunter.entities.renderer.GoldenfishRenderer;
import com.alxnns1.mobhunter.entities.renderer.SushifishRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class MHEntities {

	public static final EntityType<?>[] ENTITY_TYPES = new EntityType<?>[]{
			entity("sushifish", SushifishEntity::new, SushifishEntity.getAttributes().create()),
			entity("goldenfish", GoldenfishEntity::new, GoldenfishEntity.getAttributes().create())
	};

	public static void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler((EntityType<SushifishEntity>) MHEntities.ENTITY_TYPES[0], SushifishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler((EntityType<GoldenfishEntity>) MHEntities.ENTITY_TYPES[1], GoldenfishRenderer::new);
	}

	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		entityTypeRegistryEvent.getRegistry().registerAll(MHEntities.ENTITY_TYPES);
	}

	private static <T extends LivingEntity>  EntityType<?> entity(String name, EntityType.IFactory<T> entityFactory, AttributeModifierMap attributes) {
		EntityType<?> entityType = EntityType.Builder.create(entityFactory, EntityClassification.WATER_CREATURE)
				.size(0.7F, 0.4F).trackingRange(4)
				.build(new ResourceLocation(MobHunter.MOD_ID, name).toString())
				.setRegistryName(name);
		GlobalEntityTypeAttributes.put((EntityType<T>) entityType, attributes);
		return entityType;
	}
}
