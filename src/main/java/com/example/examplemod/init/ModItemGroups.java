package com.example.examplemod.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static com.example.examplemod.MobHunter.MOD_ID;

public class ModItemGroups {

	public static final ItemGroup MOB_HUNTER_BLOCKS_ITEM_GROUP = new MobHunterItemGroup("blocks", () -> new ItemStack(ModBlocks.BLOCKS[0]));
	public static final ItemGroup MOB_HUNTER_ITEMS_ITEM_GROUP = new MobHunterItemGroup("items", () -> new ItemStack(ModItems.ITEM_GROUP_ICON));

	public static final class MobHunterItemGroup extends ItemGroup {

		@Nonnull
		private final Supplier<ItemStack> iconSupplier;

		public MobHunterItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
			super(MOD_ID + "_" + name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		@Nonnull
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}
}
