package com.alxnns1.mobhunter.item

import com.alxnns1.mobhunter.withPrivateValue
import net.minecraft.block.DispenserBlock
import net.minecraft.dispenser.DefaultDispenseItemBehavior
import net.minecraft.dispenser.IBlockSource
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.item.ItemStack
import net.minecraft.item.SpawnEggItem
import net.minecraft.nbt.CompoundNBT
import net.minecraft.util.Direction

/*
	This class exists due to limitations with SpawnEggItem where its constructor requires an EntityType instance.
	Unfortunately, items are registered before entity types, so we need to use a supplier instead.

	We also need to inject our eggs into SpawnEggItem.EGGS, however by the time we do, the list has already been used to
	register dispenser behaviours and egg colours, so we need to do those manually. Inserting into the list therefore is
	just in-case other mods use the list.

	Some of this logic was influenced by Cadiboo's example here:
	https://github.com/Cadiboo/Example-Mod/blob/1.15.2/src/main/java/io/github/cadiboo/examplemod/item/ModdedSpawnEggItem.java
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MHSpawnEggItem(
	private val entityTypeSupplier: () -> EntityType<*>,
	primaryColour: Int,
	secondaryColour: Int,
	props: Properties
) : SpawnEggItem(null, primaryColour, secondaryColour, props) {
	companion object {
		private val DISPENSE_BEHAVIOUR = object : DefaultDispenseItemBehavior() {
			override fun dispenseStack(source: IBlockSource, stack: ItemStack): ItemStack {
				val dir = source.blockState[DispenserBlock.FACING]
				val type = (stack.item as SpawnEggItem).getType(stack.tag)
				type.spawn(source.world, stack, null, source.blockPos.offset(dir), SpawnReason.DISPENSER, dir != Direction.UP, false)
				stack.shrink(1)
				return stack
			}
		}

		private val NEW_EGGS = mutableSetOf<MHSpawnEggItem>()

		fun getNewEggsArray(): Array<MHSpawnEggItem> = NEW_EGGS.toTypedArray()

		fun initEggs() =
			withPrivateValue<MutableMap<EntityType<*>, SpawnEggItem>, SpawnEggItem>(null, "field_195987_b") { eggs ->
				NEW_EGGS.forEach { eggs[it.getType(null)] = it }
				NEW_EGGS.clear()
			}
	}

	init {
		NEW_EGGS += this
		DispenserBlock.registerDispenseBehavior(this, DISPENSE_BEHAVIOUR)
	}

	override fun getType(nbt: CompoundNBT?): EntityType<*> = entityTypeSupplier()
}
