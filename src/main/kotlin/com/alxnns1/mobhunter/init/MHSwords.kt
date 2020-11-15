package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.item.MHSword
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.Items
import net.minecraftforge.event.RegistryEvent

object MHSwords {

	fun register(event: RegistryEvent.Register<Item>) {
		val registry = event.registry
		registry.registerAll(
			sword("test_sword", intArrayOf(2, 4, 6, 8, 10, 12, 14), 10, props(ItemGroup.COMBAT))
		)
	}

	private fun sword(name: String, sharpness: IntArray, attackDamage: Int, properties: Item.Properties): Item {
		val item = MHSword(sharpness, MHSwordTier(sharpness[sharpness.size-1], 1, Items.STICK), attackDamage, -2.4F, properties)
		return item.setRegistryName(name)
	}

	private fun props(group: ItemGroup? = null): Item.Properties =
		Item.Properties().apply { group?.let { group(it) } }
}