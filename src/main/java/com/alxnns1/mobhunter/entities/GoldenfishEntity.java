package com.alxnns1.mobhunter.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class GoldenfishEntity extends AbstractGroupFishEntity {
	public GoldenfishEntity(EntityType<?> type, World worldIn) {
		super((EntityType<? extends AbstractGroupFishEntity>) type, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 3.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED);
	}

	@Nonnull
	protected ItemStack getFishBucket() {
		return new ItemStack(Items.COD_BUCKET);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_COD_AMBIENT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_COD_DEATH;
	}

	protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_COD_HURT;
	}

	@Nonnull
	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}
}
