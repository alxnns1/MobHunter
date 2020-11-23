package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.entity.fish.GoldenfishEntity
import com.alxnns1.mobhunter.entity.fish.SushifishEntity
import com.alxnns1.mobhunter.entity.fish.renderer.GoldenfishRenderer
import com.alxnns1.mobhunter.entity.fish.renderer.SushifishRenderer
import com.alxnns1.mobhunter.entity.herbivore.MosswineEntity
import com.alxnns1.mobhunter.entity.herbivore.renderer.MosswineRenderer
import com.alxnns1.mobhunter.entity.neopteran.HornetaurEntity
import com.alxnns1.mobhunter.entity.neopteran.renderer.HornetaurRenderer
import net.minecraft.entity.EntityClassification
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.MobEntity
import net.minecraft.entity.ai.attributes.Attribute
import net.minecraft.entity.ai.attributes.Attributes
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
	val MOSSWINE: EntityType<MosswineEntity> by objectHolder("mosswine")
	val HORNETAUR: EntityType<HornetaurEntity> by objectHolder("hornetaur")

	fun register(event: RegistryEvent.Register<EntityType<*>>) = event.registry.registerAll(
		fish("sushifish", ::SushifishEntity, 0.7F, 0.4F, Attributes.MAX_HEALTH to 3.0),
		fish("goldenfish", ::GoldenfishEntity, 0.7F, 0.4F, Attributes.MAX_HEALTH to 3.0),
		herbivore("mosswine", ::MosswineEntity, 1.4F, 1.4F,
			Attributes.MAX_HEALTH to 10.0, Attributes.MOVEMENT_SPEED to 0.25),
		neopteran("hornetaur", ::HornetaurEntity, 1f, 0.5f,
			Attributes.MAX_HEALTH to 5.0, Attributes.MOVEMENT_SPEED to 0.2, Attributes.ATTACK_DAMAGE to 2.0)
	)

	@OnlyIn(Dist.CLIENT)
	fun registerRenderers() {
		renderer(SUSHIFISH, ::SushifishRenderer)
		renderer(GOLDENFISH, ::GoldenfishRenderer)
		renderer(MOSSWINE, ::MosswineRenderer)
		renderer(HORNETAUR, ::HornetaurRenderer)
	}

	private inline fun <reified T : LivingEntity> entity(
		name: String,
		factory: EntityType.IFactory<T>,
		classification: EntityClassification,
		vararg attributes: Pair<Attribute, Double>,
		typeBuilder: EntityType.Builder<T>.() -> Unit = {}
	): EntityType<T> {
		val type = EntityType.Builder.create(factory, classification)
			.apply(typeBuilder)
			.build(ResourceLocation(MobHunter.MOD_ID, name).toString())
			.setRegistryName(name)
		@Suppress("UNCHECKED_CAST")
		GlobalEntityTypeAttributes.put(
			type as EntityType<T>,
			MobEntity.func_233666_p_()
				.apply { attributes.forEach { createMutableAttribute(it.first, it.second) } }
				.create()
		)
		return type
	}

	private inline fun <reified T : LivingEntity> fish(
		name: String,
		factory: EntityType.IFactory<T>,
		width: Float,
		height: Float,
		vararg attributes: Pair<Attribute, Double>
	): EntityType<T> = entity(name, factory, EntityClassification.WATER_CREATURE, *attributes) {
		size(width, height)
		trackingRange(4)
	}

	private inline fun <reified T : LivingEntity> herbivore(
		name: String,
		factory: EntityType.IFactory<T>,
		width: Float,
		height: Float,
		vararg attributes: Pair<Attribute, Double>
	): EntityType<T> = entity(name, factory, EntityClassification.CREATURE, *attributes) {
		size(width, height)
		trackingRange(4)
	}

	private inline fun <reified T : LivingEntity> neopteran(
		name: String,
		factory: EntityType.IFactory<T>,
		width: Float,
		height: Float,
		vararg attributes: Pair<Attribute, Double>
	): EntityType<T> = entity(name, factory, EntityClassification.CREATURE, *attributes) {
		size(width, height)
		trackingRange(4)
	}

	@OnlyIn(Dist.CLIENT)
	private fun <T : LivingEntity> renderer(type: EntityType<T>, renderFactory: IRenderFactory<T>) =
		RenderingRegistry.registerEntityRenderingHandler(type, renderFactory)
}
