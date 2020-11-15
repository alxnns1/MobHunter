package com.alxnns1.mobhunter.item

import com.alxnns1.mobhunter.init.SharpnessLevel
import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import net.minecraft.entity.ai.attributes.Attribute
import net.minecraft.entity.ai.attributes.AttributeModifier
import net.minecraft.entity.ai.attributes.Attributes
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.IItemTier
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem

class MHSword(
	private val sharpness: IntArray,
	tier: IItemTier,
	private val attackDamageIn: Int,
	private val attackSpeedIn: Float,
	builderIn: Properties
) : SwordItem(tier, 0, 0f, builderIn) {

	override fun getRGBDurabilityForDisplay(stack: ItemStack): Int {
		val damage = stack.maxDamage - stack.damage
		val sharpnessLevel = sharpness.first { damage <= it }
		return SharpnessLevel.values()[sharpness.indexOf(sharpnessLevel)].colour
	}

	override fun getAttributeModifiers(slot: EquipmentSlotType, stack: ItemStack): Multimap<Attribute, AttributeModifier> {
		return if (slot == EquipmentSlotType.MAINHAND) {
			ImmutableMultimap.builder<Attribute, AttributeModifier>()
				.put(Attributes.ATTACK_DAMAGE, AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", attackDamageIn * getSharpnessAttackModifier(stack), AttributeModifier.Operation.ADDITION))
				.put(Attributes.ATTACK_SPEED, AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", attackSpeedIn.toDouble(), AttributeModifier.Operation.ADDITION))
				.build()
		} else {
			super.getAttributeModifiers(slot, stack)
		}
	}

	override fun showDurabilityBar(stack: ItemStack?) = true

	private fun getSharpnessAttackModifier(stack: ItemStack): Double {
		val damage = stack.maxDamage - stack.damage
		val sharpnessLevel = sharpness.first { damage <= it }
		return SharpnessLevel.values()[sharpness.indexOf(sharpnessLevel)].multiplier
	}
}