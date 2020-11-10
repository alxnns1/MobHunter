package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.fish.GoldenfishEntity
import com.alxnns1.mobhunter.entity.fish.SushifishEntity
import com.alxnns1.mobhunter.entity.fish.renderer.GoldenfishRenderer
import com.alxnns1.mobhunter.entity.fish.renderer.SushifishRenderer
import net.minecraft.entity.EntityClassification
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.attributes.AttributeModifierMap
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes
import net.minecraft.util.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.client.registry.IRenderFactory
import net.minecraftforge.fml.client.registry.RenderingRegistry
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHEntities {
	val SUSHIFISH: EntityType<SushifishEntity> by objectHolder("sushifish")
	val GOLDENFISH: EntityType<GoldenfishEntity> by objectHolder("goldenfish")

	fun register(event: RegistryEvent.Register<EntityType<*>>): Unit = event.registry.registerAll(
		fish("sushifish", ::SushifishEntity, SushifishEntity.createAttributes()),
		fish("goldenfish", ::GoldenfishEntity, GoldenfishEntity.createAttributes())
	)

	@OnlyIn(Dist.CLIENT)
	fun registerRenderers() {
		renderer(SUSHIFISH, ::SushifishRenderer)
		renderer(GOLDENFISH, ::GoldenfishRenderer)
	}

	private inline fun <reified T : LivingEntity> entity(
		name: String,
		factory: EntityType.IFactory<T>,
		classification: EntityClassification,
		attributes: AttributeModifierMap,
		typeBuilder: EntityType.Builder<T>.() -> Unit = {}
	): EntityType<T> {
		val type = EntityType.Builder.create(factory, classification)
			.apply(typeBuilder)
			.build(ResourceLocation(MobHunter.MOD_ID, name).toString())
			.setRegistryName(name)
		@Suppress("UNCHECKED_CAST")
		GlobalEntityTypeAttributes.put(type as EntityType<T>, attributes)
		return type
	}

	private inline fun <reified T : LivingEntity> fish(
		name: String,
		factory: EntityType.IFactory<T>,
		attributes: AttributeModifierMap
	): EntityType<T> = entity(name, factory, EntityClassification.WATER_CREATURE, attributes) {
		size(0.7F, 0.4F)
		trackingRange(4)
	}

	@OnlyIn(Dist.CLIENT)
	private fun <T : LivingEntity> renderer(type: EntityType<T>, renderFactory: IRenderFactory<T>) =
		RenderingRegistry.registerEntityRenderingHandler(type, renderFactory)
}
