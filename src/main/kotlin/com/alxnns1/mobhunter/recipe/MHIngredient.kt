package com.alxnns1.mobhunter.recipe

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import net.minecraft.item.crafting.Ingredient
import net.minecraft.network.PacketBuffer
import net.minecraftforge.common.crafting.IIngredientSerializer
import java.util.stream.Stream

class MHIngredient(itemLists: Stream<out IItemList>, val count: Int) : Ingredient(itemLists) {
	companion object {
		val EMPTY = MHIngredient(Stream.empty(), 0)

		private const val COUNT = "count"
	}

	override fun getSerializer(): IIngredientSerializer<out Ingredient> = Serializer

	override fun serialize(): JsonElement = super.serialize().run {
		if (this is JsonObject) {
			this.apply {
				addProperty(COUNT, count)
			}
		} else {
			JsonObject().apply {
				add("items", this@run)
				addProperty(COUNT, count)
			}
		}
	}

	object Serializer : IIngredientSerializer<MHIngredient> {
		override fun parse(buffer: PacketBuffer): MHIngredient {
			val stream = Stream.generate { SingleItemList(buffer.readItemStack()) }.limit(buffer.readVarInt().toLong())
			val count = buffer.readVarInt()
			val ingredient = MHIngredient(stream, count)
			return if (ingredient.acceptedItems.isEmpty()) EMPTY else ingredient
		}

		override fun parse(json: JsonObject): MHIngredient =
			MHIngredient(Stream.of(deserializeItemList(json)), if (json.has(COUNT)) json.get(COUNT).asInt else 0)

		override fun write(buffer: PacketBuffer, ingredient: MHIngredient) {
			val items = ingredient.matchingStacks
			buffer.writeVarInt(items.size)
			items.forEach { buffer.writeItemStack(it) }
			buffer.writeVarInt(ingredient.count)
		}
	}
}
