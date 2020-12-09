package com.alxnns1.mobhunter.init

import com.alxnns1.mobhunter.MobHunter
import com.alxnns1.mobhunter.gui.WeaponCraftingContainer
import com.alxnns1.mobhunter.gui.WeaponCraftingScreen
import net.minecraft.client.gui.IHasContainer
import net.minecraft.client.gui.ScreenManager
import net.minecraft.client.gui.screen.Screen
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.container.Container
import net.minecraft.inventory.container.ContainerType
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.ITextComponent
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import net.minecraftforge.common.extensions.IForgeContainerType
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.objectHolder

object MHScreens {
	val WEAPON_CRAFT: ContainerType<WeaponCraftingContainer> by objectHolder("weapon_craft")

	fun registerContainers(event: RegistryEvent.Register<ContainerType<*>>): Unit = event.registry.registerAll(
		container("weapon_craft", ::WeaponCraftingContainer)
	)

	@OnlyIn(Dist.CLIENT)
	fun registerScreens(event: FMLClientSetupEvent) {
		event.enqueueWork {
			screen(WEAPON_CRAFT, ::WeaponCraftingScreen)
		}
	}

	private fun <T : Container> container(
		name: String,
		factory: (id: Int, playerInv: PlayerInventory, pos: BlockPos) -> T
	): ContainerType<T> = IForgeContainerType.create { id, inv, data -> factory(id, inv, data.readBlockPos()) }
		.apply { setRegistryName(ResourceLocation(MobHunter.MOD_ID, name)) }

	@OnlyIn(Dist.CLIENT)
	private fun <C : Container, S> screen(
		type: ContainerType<C>,
		factory: (C, PlayerInventory, ITextComponent) -> S
	): Unit where S : Screen, S : IHasContainer<C> = ScreenManager.registerFactory(type, factory)
}
