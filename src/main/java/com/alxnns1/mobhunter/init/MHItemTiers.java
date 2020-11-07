package com.alxnns1.mobhunter.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class MHItemTiers {

	public static IItemTier MACHALITE = new IItemTier() {
		@Override
		public int getMaxUses() {
			return 687;
		}

		@Override
		public float getEfficiency() {
			return 6.667F;
		}

		@Override
		public float getAttackDamage() {
			return 2.333F;
		}

		@Override
		public int getHarvestLevel() {
			return 2;
		}

		@Override
		public int getEnchantability() {
			return 15;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromStacks(new ItemStack(MHItems.ITEMS.get("machalite_ingot")));
		}
	};

	public static IItemTier DRAGONITE = new IItemTier() {
		@Override
		public int getMaxUses() {
			return 1124;
		}

		@Override
		public float getEfficiency() {
			return 7.333F;
		}

		@Override
		public float getAttackDamage() {
			return 2.667F;
		}

		@Override
		public int getHarvestLevel() {
			return 2;
		}

		@Override
		public int getEnchantability() {
			return 16;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromStacks(new ItemStack(MHItems.ITEMS.get("dragonite_ingot")));
		}
	};

	public static IItemTier CARBALITE = new IItemTier() {
		@Override
		public int getMaxUses() {
			return 1561;
		}

		@Override
		public float getEfficiency() {
			return 8F;
		}

		@Override
		public float getAttackDamage() {
			return 3F;
		}

		@Override
		public int getHarvestLevel() {
			return 3;
		}

		@Override
		public int getEnchantability() {
			return 17;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromStacks(new ItemStack(MHItems.ITEMS.get("carbalite_ingot")));
		}
	};

	public static IItemTier ELTALITE = new IItemTier() {
		@Override
		public int getMaxUses() {
			return 1998;
		}

		@Override
		public float getEfficiency() {
			return 9F;
		}

		@Override
		public float getAttackDamage() {
			return 4F;
		}

		@Override
		public int getHarvestLevel() {
			return 4;
		}

		@Override
		public int getEnchantability() {
			return 18;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromStacks(new ItemStack(MHItems.ITEMS.get("eltalite_ingot")));
		}
	};
}
