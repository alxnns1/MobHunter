package com.example.examplemod.init;

import com.example.examplemod.MobHunter;
import com.example.examplemod.entities.SushifishEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.util.ResourceLocation;

public class ModEntities {

	public static final EntityType<?>[] ENTITY_TYPES = new EntityType<?>[]{
			EntityType.Builder.create(SushifishEntity::new, EntityClassification.WATER_CREATURE)
					.size(0.7F, 0.4F).trackingRange(4)
					.build(new ResourceLocation(MobHunter.MOD_ID, "sushifish").toString())
					.setRegistryName("sushifish")
	};

//	private static void registerFish(EntityType.IFactory<AbstractGroupFishEntity> factory, float width, float height, int trackingRange, String name) {
//		EntityType<AbstractGroupFishEntity> sushifish = EntityType.Builder.create(factory, EntityClassification.WATER_CREATURE)
//				.size(0.7F, 0.4F).trackingRange(4)
//				.build(new ResourceLocation(MobHunter.MOD_ID, "sushifish").toString());
//		GlobalEntityTypeAttributes.put(sushifish, SushifishEntity.getAttributes().create());
//		return sushifish
//	}
}
