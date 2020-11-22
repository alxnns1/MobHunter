package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.item.MHSword
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraftforge.event.RegistryEvent
import java.util.function.Supplier

object MHSwords {

	fun register(event: RegistryEvent.Register<Item>) {
		val registry = event.registry
		registry.registerAll(
			sword("test_sword", 10, sharpness(1, 1, 1, 1, 1, 1, 1)),
			// Petrified
			sword("petrified_sword1", 4, sharpness(18, 8, 4)),
			sword("petrified_sword2", 6, sharpness(12, 10, 8)),
			sword("petrified_sword3", 7, sharpness(12, 8, 20)),
			sword("petrified_sword4", 8, sharpness(14, 6, 8, 12)),
			sword("petrified_sword5", 9, sharpness(14, 12, 8, 16)),
			sword("petrified_sword6", 12, sharpness(14, 6, 8, 32), 10),
			sword("petrified_sword7", 15, sharpness(8, 8, 18, 34, 2), 10),
			sword("petrified_sword8", 19, sharpness(16, 14, 8, 28, 4), 10),
			sword("petrified_sword9", 22, sharpness(10, 4, 20, 30, 6), 15),
			sword("petrified_sword10", 27, sharpness(14, 8, 10, 30, 14), 15),
			sword("petrified_sword11", 30, sharpness(12, 8, 10, 32, 10, 8), 20),
			// Hunters
			sword("hunters_knife1", 5, sharpness(12, 6, 12)),
			sword("hunters_knife2", 6, sharpness(8, 12, 16, 4)),
			sword("hunters_knife3", 8, sharpness(8, 8, 18, 6)),
			sword("hunters_knife4", 9, sharpness(4, 8, 20, 8)),
			sword("hunters_knife5", 10, sharpness(12, 6, 20, 12)),
			sword("hunters_knife6", 13, sharpness(18, 4, 18, 20)),
			sword("hunters_knife7", 16, sharpness(12, 8, 10, 30)),
			sword("hunters_knife8", 21, sharpness(16, 4, 6, 34)),
			sword("hunters_knife9", 24, sharpness(14, 12, 8, 32, 4)),
			sword("hunters_knife10", 31, sharpness(8, 12, 16, 24, 10)),
			sword("hunters_knife11", 34, sharpness(4, 8, 20, 26, 12)),
			// Bone
			sword("bone_kris1", 6, sharpness(16,8,6)),
			sword("bone_kris2", 8, sharpness(12,8,10)),
			sword("bone_kris3", 9, sharpness(4,10,16)),
			sword("bone_kris4", 11, sharpness(4,10,26)),
			sword("bone_kris5", 12, sharpness(10,6,30,4)),
			sword("bone_kris6", 15, sharpness(10,6,28,6)),
			sword("bone_kris7", 19, sharpness(10,6,26,8)),
			sword("bone_kris8", 22, sharpness(6,12,32,10)),
			sword("bone_kris9", 25, sharpness(14,12,36,6,2)),
			sword("bone_kris10", 31, sharpness(18,14,24,8,6)),
			sword("bone_kris11", 34, sharpness(16,16,22,6,10)),
		)
	}

	private fun sword(name: String, attackDamage: Int, sharpness: List<Int>, enchantability: Int = 5): Item {
		val item = MHSword(sharpness, MHSwordTier(sharpness.last(), enchantability) { MHItems.WHETSTONE }, attackDamage, -2.4F, props())
		return item.setRegistryName(name)
	}

	private fun props(): Item.Properties =
		Item.Properties().apply { group(MobHunter.GROUP_SWORDS) }

	private fun sharpness(red: Int, orange: Int = 0, yellow: Int = 0, green: Int = 0, blue: Int = 0, white: Int = 0, purple: Int = 0): List<Int> {
		return listOf(
			red * 4,
			(red + orange * 2) * 4,
			(red + orange * 2 + yellow * 3) * 4,
			(red + orange * 2 + yellow * 3 + green * 4) * 4,
			(red + orange * 2 + yellow * 3 + green * 4 + blue * 5) * 4,
			(red + orange * 2 + yellow * 3 + green * 4 + blue * 5 + white * 6) * 4,
			(red + orange * 2 + yellow * 3 + green * 4 + blue * 5 + white * 6 + purple * 7) * 4
		)
	}
}