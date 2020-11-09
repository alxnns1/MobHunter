package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entities.fish.GoldenfishEntity;
import com.alxnns1.mobhunter.entities.fish.SushifishEntity;
import com.alxnns1.mobhunter.entities.fish.renderer.GoldenfishRenderer;
import com.alxnns1.mobhunter.entities.fish.renderer.SushifishRenderer;
import com.alxnns1.mobhunter.entities.neopterans.HornetaurEntity;
import com.alxnns1.mobhunter.entities.neopterans.renderer.HornetaurRenderer;
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
			fish("sushifish", SushifishEntity::new, SushifishEntity.getAttributes().create()),
			fish("goldenfish", GoldenfishEntity::new, GoldenfishEntity.getAttributes().create()),
			neopteran("hornetaur", HornetaurEntity::new, HornetaurEntity.getAttributes().create())
	};

	public static void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler((EntityType<SushifishEntity>) MHEntities.ENTITY_TYPES[0], SushifishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler((EntityType<GoldenfishEntity>) MHEntities.ENTITY_TYPES[1], GoldenfishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler((EntityType<HornetaurEntity>) MHEntities.ENTITY_TYPES[2], HornetaurRenderer::new);
	}

	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> entityTypeRegistryEvent) {
		entityTypeRegistryEvent.getRegistry().registerAll(MHEntities.ENTITY_TYPES);
	}

	private static <T extends LivingEntity>  EntityType<?> fish(String name, EntityType.IFactory<T> entityFactory, AttributeModifierMap attributes) {
		EntityType<?> entityType = EntityType.Builder.create(entityFactory, EntityClassification.WATER_CREATURE)
				.size(0.7F, 0.4F).trackingRange(4)
				.build(new ResourceLocation(MobHunter.MOD_ID, name).toString())
				.setRegistryName(name);
		GlobalEntityTypeAttributes.put((EntityType<T>) entityType, attributes);
		return entityType;
	}

	private static <T extends LivingEntity>  EntityType<?> neopteran(String name, EntityType.IFactory<T> entityFactory, AttributeModifierMap attributes) {
		EntityType<?> entityType = EntityType.Builder.create(entityFactory, EntityClassification.CREATURE)
				.size(1F, 1F).trackingRange(4)
				.build(new ResourceLocation(MobHunter.MOD_ID, name).toString())
				.setRegistryName(name);
		GlobalEntityTypeAttributes.put((EntityType<T>) entityType, attributes);
		return entityType;
	}
}
