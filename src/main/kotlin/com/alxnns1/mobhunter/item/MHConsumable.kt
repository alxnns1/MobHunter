package com.alxnns1.mobhunter.item

import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.UseAction
import net.minecraft.potion.EffectInstance
import net.minecraft.stats.Stats
import net.minecraft.util.ActionResult
import net.minecraft.util.DrinkHelper
import net.minecraft.util.Hand
import net.minecraft.world.World

class MHConsumable(properties: Properties, private val colour: Int, potionEffects: () -> Array<EffectInstance>) : Item(properties), MHITintItem {
	private val potionEffects: Array<EffectInstance> by lazy(potionEffects)

	override fun onItemUseFinish(stack: ItemStack, worldIn: World, entityLiving: LivingEntity): ItemStack? {
		val playerEntity = if (entityLiving is PlayerEntity) entityLiving else null
		if (playerEntity is ServerPlayerEntity) {
			CriteriaTriggers.CONSUME_ITEM.trigger(playerEntity, stack)
		}
		if (!worldIn.isRemote) {
			for (effectInstance in potionEffects) {
				if (effectInstance.potion.isInstant) {
					effectInstance.potion.affectEntity(playerEntity, playerEntity, entityLiving, effectInstance.amplifier, 1.0)
				} else {
					entityLiving.addPotionEffect(EffectInstance(effectInstance))
				}
			}
		}
		if (playerEntity != null) {
			playerEntity.addStat(Stats.ITEM_USED[this])
			if (!playerEntity.abilities.isCreativeMode) {
				stack.shrink(1)
			}
		}
		if (playerEntity == null || !playerEntity.abilities.isCreativeMode) {
			if (stack.isEmpty) {
				return ItemStack(Items.GLASS_BOTTLE)
			}
			playerEntity?.inventory?.addItemStackToInventory(ItemStack(Items.GLASS_BOTTLE))
		}
		return stack
	}

	override fun getUseDuration(stack: ItemStack?) = 32

	override fun getUseAction(stack: ItemStack) = UseAction.DRINK

	override fun onItemRightClick(worldIn: World, playerIn: PlayerEntity, handIn: Hand): ActionResult<ItemStack> =
		DrinkHelper.startDrinking(worldIn, playerIn, handIn)

	override fun getColour() = colour
}