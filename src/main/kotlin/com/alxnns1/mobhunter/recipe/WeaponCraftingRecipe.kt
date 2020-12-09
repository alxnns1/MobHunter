package com.alxnns1.mobhunter.recipe

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.init.MHBlocks
import com.alxnns1.mobhunter.init.MHRecipes
import com.google.gson.JsonObject
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.*
import net.minecraft.network.PacketBuffer
import net.minecraft.util.JSONUtils
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World
import net.minecraftforge.registries.ForgeRegistryEntry

// https://github.com/Minecraft-Forge-Tutorials/Custom-Json-Recipes/blob/master/src/main/java/net/darkhax/customrecipeexample/ClickBlockRecipe.java
class WeaponCraftingRecipe(
	private val id: ResourceLocation,
	val keyIngredient: Ingredient,
	val additionalIngredients: NonNullList<MHIngredient>,
	private val output: ItemStack
) : IRecipe<IInventory> {
	override fun matches(inv: IInventory, worldIn: World): Boolean {
		TODO("Not yet implemented")
	}

	override fun getCraftingResult(inv: IInventory): ItemStack = recipeOutput

	override fun canFit(width: Int, height: Int): Boolean {
		TODO("Not yet implemented")
	}

	override fun getRecipeOutput(): ItemStack = output.copy()

	override fun getIcon(): ItemStack = ItemStack(MHBlocks.WEAPON_CRAFTING)

	override fun getId(): ResourceLocation = id

	override fun getSerializer(): IRecipeSerializer<*> = Serializer

	override fun getType(): IRecipeType<*> = MHRecipes.WEAPON_CRAFTING_TYPE

	object Serializer : ForgeRegistryEntry<IRecipeSerializer<*>>(), IRecipeSerializer<WeaponCraftingRecipe> {
		init {
			setRegistryName(MobHunter.MOD_ID, "weapon_crafting")
		}

		override fun read(recipeId: ResourceLocation, json: JsonObject): WeaponCraftingRecipe {
			val keyIngredient = if (JSONUtils.hasField(json, "key"))
				Ingredient.deserialize(JSONUtils.getJsonObject(json, "key"))
			else
				Ingredient.EMPTY
			val additionalIngredients = NonNullList.create<MHIngredient>().apply {
				JSONUtils.getJsonArray(json, "ingredients").forEach {
					if (it is JsonObject) {
						val ingredient = MHIngredient.Serializer.parse(it)
						if (!ingredient.hasNoMatchingItems())
							add(ingredient)
					}
				}
			}
			val resultElement = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"))
			return WeaponCraftingRecipe(recipeId, keyIngredient, additionalIngredients, resultElement)
		}

		override fun read(recipeId: ResourceLocation, buffer: PacketBuffer): WeaponCraftingRecipe? {
			val keyIngredient = Ingredient.read(buffer)
			val count = buffer.readVarInt()
			val additionalIngredients = NonNullList.create<MHIngredient>().apply {
				repeat(count) { add(MHIngredient.Serializer.parse(buffer)) }
			}
			val result = buffer.readItemStack()
			return WeaponCraftingRecipe(recipeId, keyIngredient, additionalIngredients, result)
		}

		override fun write(buffer: PacketBuffer, recipe: WeaponCraftingRecipe) {
			recipe.keyIngredient.write(buffer)
			buffer.writeVarInt(recipe.additionalIngredients.size)
			recipe.additionalIngredients.forEach { it.write(buffer) }
			buffer.writeItemStack(recipe.output)
		}
	}
}
