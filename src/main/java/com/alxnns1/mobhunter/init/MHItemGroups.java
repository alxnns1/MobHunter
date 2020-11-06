package com.alxnns1.mobhunter.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static com.alxnns1.mobhunter.MobHunter.MOD_ID;

public class MHItemGroups {

	public static final ItemGroup MOB_HUNTER_BLOCKS_ITEM_GROUP = new MobHunterItemGroup("blocks", () -> new ItemStack(MHBlocks.BLOCKS.get("machalite_ore")));
	public static final ItemGroup MOB_HUNTER_ITEMS_ITEM_GROUP = new MobHunterItemGroup("items", () -> new ItemStack(MHItems.ITEM_GROUP_ICON));

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
