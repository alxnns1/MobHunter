package com.alxnns1.mobhunter.gui

import com.alxnns1.mobhunter.booleanArrayReferenceHolder
import com.alxnns1.mobhunter.init.MHRecipes
import com.alxnns1.mobhunter.init.MHScreens
import com.alxnns1.mobhunter.recipe.MHIngredient
import com.alxnns1.mobhunter.recipe.WeaponCraftingRecipe
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.IInventory
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.container.Slot
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.math.BlockPos
import net.minecraftforge.fml.hooks.BasicEventHooks
import kotlin.math.max

class WeaponCraftingContainer(id: Int, playerInv: PlayerInventory, pos: BlockPos) : MHContainer(
	id,
	MHScreens.WEAPON_CRAFT,
	playerInv,
	pos,
	{
		object : Slot(it, 0, 14, 53) {
			override fun getSlotStackLimit(): Int = 1
		}
	}
) {
	companion object {
		const val BUTTON_ARROW_UP_ID = Byte.MAX_VALUE.toInt()
		const val BUTTON_ARROW_DOWN_ID = Byte.MAX_VALUE.toInt() - 1
	}

	private lateinit var recipes: List<WeaponCraftingRecipe>
	private val recipesValid: BooleanArray by booleanArrayReferenceHolder(5)
	private var listStart = 0

	private var slotStack: ItemStack
		get() = inventory.getStackInSlot(0)
		set(value) = inventory.setInventorySlotContents(0, value)

	init {
		invStartX = 48
		invStartY = 122
		inventory = SingleSlotInventory(this)

	}

	override fun onCraftMatrixChanged(inv: IInventory) {
		reloadRecipes()
		super.onCraftMatrixChanged(inv)
	}

	override fun enchantItem(player: PlayerEntity, buttonId: Int): Boolean = when (buttonId) {
		BUTTON_ARROW_UP_ID -> scrollUp()
		BUTTON_ARROW_DOWN_ID -> scrollDown()
		else -> craftItem(buttonId)
	}

	private fun scrollUp(): Boolean = if (listStart < recipes.size - 5) {
		listStart++
		refreshRecipes()
		true
	} else
		false

	private fun scrollDown(): Boolean = if (listStart > 0) {
		listStart--
		refreshRecipes()
		true
	} else
		false

	private fun craftItem(buttonId: Int): Boolean {
		if (world.isRemote)
			return false
		val index = buttonId + listStart
		if (index < 0 || index >= recipes.size)
			return false
		val recipe = recipes[index]
		val stack = slotStack
		if (!recipe.keyIngredient.test(stack) || hasIngredients(recipe))
			return false

		// Set output stack to have same damage as input
		val output = recipe.recipeOutput
		output.damage = stack.damage
		// Copy enchantments to output stack
		if (stack.isEnchanted)
			EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(stack), output)

		// Fire ItemCraftedEvent
		val ingredients = findIngredients(recipe)
		val craftInv = Inventory(*ingredients.flatMap { it.value }.toTypedArray())
		if (!stack.isEmpty)
			craftInv.addItem(stack)
		BasicEventHooks.firePlayerCraftingEvent(player, output, craftInv)

		// Put recipe output in key item slot
		slotStack = output

		// Reload recipes in list
		reloadRecipes()
		return true
	}

	override fun onContainerClosed(player: PlayerEntity) {
		super.onContainerClosed(player)
		if (world.isRemote)
			return
		val stack = inventory.removeStackFromSlot(0)
		if (!stack.isEmpty && !player.addItemStackToInventory(stack))
			player.dropItem(stack, false)
	}

	/**
	 * Gets all [WeaponCraftingRecipe]s which have a key item that's empty or matches the item in the slot
	 */
	private fun reloadRecipes() {
		val stack = slotStack
		recipes = world.recipeManager.recipes[MHRecipes.WEAPON_CRAFTING_TYPE]!!.values
			.map { it as WeaponCraftingRecipe }
			.filter { if (stack.isEmpty) playerHasKeyItemForRecipe(it) else it.keyIngredient.test(stack) }
			.sortedBy { it.recipeOutput.displayName.string }
		listStart = 0

		val size = recipes.size
		(0..4).forEach {
			if (size < it + 1)
				recipesValid[it] = false
			else {
				recipesValid[it] = hasIngredients(recipes[it])
			}
		}
	}

	private fun hasIngredients(recipe: WeaponCraftingRecipe): Boolean =
		findMissingIngredients(recipe).isEmpty()

	private fun findMissingIngredients(recipe: WeaponCraftingRecipe): Map<MHIngredient, Int> {
		val missing = recipe.additionalIngredients.associateWithTo(mutableMapOf()) { it.count }
		recipe.additionalIngredients.forEach { ingredient ->
			for (i in 0 until playerInv.sizeInventory) {
				val stack = playerInv.getStackInSlot(i)
				if (stack.isEmpty)
					continue
				if (ingredient.test(stack)) {
					var missingCount = missing.getValue(ingredient)
					if (missingCount <= 0)
						break
					missingCount = max(0, missingCount - stack.count)
					missing[ingredient] = missingCount
					if (missingCount <= 0)
						break
				}
			}
		}
		return missing.filter { it.value > 0 }
	}

	private fun findIngredients(recipe: WeaponCraftingRecipe): Map<MHIngredient, List<ItemStack>> {
		val stacks = recipe.additionalIngredients.associateWithTo(mutableMapOf()) { mutableListOf<ItemStack>() }
		recipe.additionalIngredients.forEach { ingredient ->
			for (i in 0 until playerInv.sizeInventory) {
				val stack = playerInv.getStackInSlot(i)
				if (stack.isEmpty)
					continue
				if (ingredient.test(stack)) {
					val list = stacks[ingredient]!!
					list += stack
					if (list.sumBy { it.count } >= ingredient.count)
						break
				}
			}
		}
		return stacks
	}

	private fun playerHasKeyItemForRecipe(recipe: WeaponCraftingRecipe): Boolean {
		val key = recipe.keyIngredient
		if (key == Ingredient.EMPTY)
			return true
		for (i in 0 until playerInv.sizeInventory) {
			if (key.test(playerInv.getStackInSlot(i)))
				return true
		}
		return false
	}

	/**
	 * Refreshes the [recipesValid] list
	 */
	private fun refreshRecipes() = (0..4).forEach {
		val recipeI = listStart + it
		if (recipes.size < recipeI + 1)
			recipesValid[it] = false
		else
			recipesValid[it] = hasIngredients(recipes[recipeI])
	}
}
