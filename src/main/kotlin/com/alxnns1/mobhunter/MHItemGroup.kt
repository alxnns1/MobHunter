package com.alxnns1.mobhunter

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

class MHItemGroup(name: String, stackSupplier: () -> ItemStack) : ItemGroup("${MobHunter.MOD_ID}_$name") {
	private val stack by lazy(stackSupplier)

	override fun createIcon(): ItemStack = stack
}
