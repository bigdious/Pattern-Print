package com.bigdious.pp.data;

import com.bigdious.pp.init.PPItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class PPCraftingGenerator extends RecipeProvider {
	public PPCraftingGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
		super(packOutput, provider);
	}

	@Override
	protected void buildRecipes(RecipeOutput consumer) {
		//print recipes group
		//recrafts
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_1.get(), 1)
			.requires(PPItems.PATTERN_PRINT_1.get())
			.unlockedBy("has_item", has(PPItems.PATTERN_PRINT_1.get()))
			.save(consumer, "print_recraft_1");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_2.get(), 1)
			.requires(PPItems.PATTERN_PRINT_2.get())
			.unlockedBy("has_item", has(PPItems.PATTERN_PRINT_1.get()))
			.save(consumer, "print_recraft_2");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_3.get(), 1)
			.requires(PPItems.PATTERN_PRINT_3.get())
			.unlockedBy("has_item", has(PPItems.PATTERN_PRINT_1.get()))
			.save(consumer, "print_recraft_3");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_4.get(), 1)
			.requires(PPItems.PATTERN_PRINT_4.get())
			.unlockedBy("has_item", has(PPItems.PATTERN_PRINT_1.get()))
			.save(consumer, "print_recraft_4");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_5.get(), 1)
			.requires(PPItems.PATTERN_PRINT_5.get())
			.unlockedBy("has_item", has(PPItems.PATTERN_PRINT_1.get()))
			.save(consumer, "print_recraft_5");

		//pp
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_1.get())
			.requires(ItemTags.LOGS)
			.requires(Items.COPPER_BLOCK)
			.requires(Items.INK_SAC)
			.requires(Items.PAPER)
			.unlockedBy("has_item", has(Items.PAPER))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_2.get())
			.requires(PPItems.PATTERN_PRINT_1.get())
			.requires(Items.PAPER)
			.unlockedBy("has_item", has(Items.PAPER))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_3.get())
			.requires(PPItems.PATTERN_PRINT_2.get())
			.requires(Items.PAPER)
			.unlockedBy("has_item", has(Items.PAPER))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_4.get())
			.requires(PPItems.PATTERN_PRINT_3.get())
			.requires(Items.PAPER)
			.unlockedBy("has_item", has(Items.PAPER))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_5.get())
			.requires(PPItems.PATTERN_PRINT_4.get())
			.requires(Items.PAPER)
			.unlockedBy("has_item", has(Items.PAPER))
			.save(consumer);
	}

}
