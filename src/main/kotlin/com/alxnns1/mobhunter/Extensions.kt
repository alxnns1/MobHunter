package com.alxnns1.mobhunter

import com.alxnns1.mobhunter.entity.MHEntity
import net.minecraft.entity.MobEntity
import net.minecraft.inventory.container.Container
import net.minecraft.item.crafting.IRecipe
import net.minecraft.item.crafting.IRecipeType
import net.minecraft.item.crafting.RecipeManager
import net.minecraft.util.IntReferenceHolder
import net.minecraft.util.ResourceLocation
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun RecipeManager.getRecipes(type: IRecipeType<*>): Map<ResourceLocation, IRecipe<*>> =
	this.recipes.getOrElse(type, { emptyMap() }).toMap()

fun <T> T.getMHScale(): Float where T : MHEntity, T : MobEntity = this.dataManager[this.getScaleKey()]

fun Container.intReferenceHolder(): ReadWriteProperty<Container, Int> =
	IntReferenceHolderDelegate(this.trackInt(IntReferenceHolder.single()))

fun Container.intArrayReferenceHolder(size: Int): ReadWriteProperty<Container, IntArray> =
	IntArrayReferenceHolderDelegate(Array(size) { this.trackInt(IntReferenceHolder.single()) })

fun Container.booleanArrayReferenceHolder(size: Int): ReadWriteProperty<Container, BooleanArray> =
	BooleanArrayReferenceHolderDelegate(Array(size) { this.trackInt(IntReferenceHolder.single()) })

class IntReferenceHolderDelegate(private val intReferenceHolder: IntReferenceHolder) : ReadWriteProperty<Container, Int> {
	override fun getValue(thisRef: Container, property: KProperty<*>): Int = intReferenceHolder.get()
	override fun setValue(thisRef: Container, property: KProperty<*>, value: Int) = intReferenceHolder.set(value)
}

class IntArrayReferenceHolderDelegate(private val intReferenceHolders: Array<out IntReferenceHolder>) : ReadWriteProperty<Container, IntArray> {
	override fun setValue(thisRef: Container, property: KProperty<*>, value: IntArray) =
		value.forEachIndexed { i, v -> intReferenceHolders[i].set(v) }

	override fun getValue(thisRef: Container, property: KProperty<*>): IntArray =
		IntArray(intReferenceHolders.size) { intReferenceHolders[it].get() }
}

class BooleanArrayReferenceHolderDelegate(private val intReferenceHolders: Array<out IntReferenceHolder>) : ReadWriteProperty<Container, BooleanArray> {
	override fun setValue(thisRef: Container, property: KProperty<*>, value: BooleanArray) =
		value.forEachIndexed { i, v -> intReferenceHolders[i].set(if (v) 1 else 0) }

	override fun getValue(thisRef: Container, property: KProperty<*>): BooleanArray =
		BooleanArray(intReferenceHolders.size) { intReferenceHolders[it].get() == 1 }
}
