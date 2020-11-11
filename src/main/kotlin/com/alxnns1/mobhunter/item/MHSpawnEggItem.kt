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

// https://github.com/Cadiboo/Example-Mod/blob/1.15.2/src/main/java/io/github/cadiboo/examplemod/item/ModdedSpawnEggItem.java
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MHSpawnEggItem(
	private val entityTypeSupplier: () -> EntityType<*>,
	primaryColour: Int,
	secondaryColour: Int,
	props: Properties
) : SpawnEggItem(null, primaryColour, secondaryColour, props) {
	companion object {
		private val NEW_EGGS = mutableSetOf<MHSpawnEggItem>()

		fun initEggs() {
			withPrivateValue<MutableMap<EntityType<*>, SpawnEggItem>, SpawnEggItem>(null, "field_195987_b") { eggs ->
				val dispenseBehavior = object : DefaultDispenseItemBehavior() {
					override fun dispenseStack(source: IBlockSource, stack: ItemStack): ItemStack {
						val dir = source.blockState[DispenserBlock.FACING]
						val type = (stack.item as SpawnEggItem).getType(stack.tag)
						type.spawn(source.world, stack, null, source.blockPos.offset(dir), SpawnReason.DISPENSER, dir != Direction.UP, false)
						stack.shrink(1)
						return stack
					}
				}
				NEW_EGGS.forEach {
					eggs[it.getType(null)] = it
					DispenserBlock.registerDispenseBehavior(it, dispenseBehavior)
				}
				NEW_EGGS.clear()
			}
		}
	}

	init {
		NEW_EGGS += this
	}

	override fun getType(nbt: CompoundNBT?): EntityType<*> = entityTypeSupplier()
}
