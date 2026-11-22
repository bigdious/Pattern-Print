package com.bigdious.pp.data;

import com.bigdious.pp.init.PPItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

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
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_MATERIAL.get())
			.requires(Tags.Items.STRIPPED_LOGS)
			.requires(Items.COPPER_GRATE)
			.requires(Items.SCAFFOLDING)
			.requires(Items.INK_SAC)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_1.get())
			.pattern(" /#")
			.pattern("/B/")
			.pattern(" / ")
			.define('#', Ingredient.of(Items.PAPER))
			.define('/', Ingredient.of(Items.STICK))
			.define('B', Ingredient.of(PPItems.PATTERN_PRINT_MATERIAL.get()))
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_2.get())
			.requires(PPItems.PATTERN_PRINT_1.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_3.get())
			.requires(PPItems.PATTERN_PRINT_2.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_3.get())
			.requires(PPItems.PATTERN_PRINT_1.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer, "pattern_print_3_a");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_4.get())
			.requires(PPItems.PATTERN_PRINT_3.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_4.get())
			.requires(PPItems.PATTERN_PRINT_2.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer, "pattern_print_4_a");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_4.get())
			.requires(PPItems.PATTERN_PRINT_1.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer, "pattern_print_4_b");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_5.get())
			.requires(PPItems.PATTERN_PRINT_4.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_5.get())
			.requires(PPItems.PATTERN_PRINT_3.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer, "pattern_print_5_a");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_5.get())
			.requires(PPItems.PATTERN_PRINT_2.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer, "pattern_print_5_b");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, PPItems.PATTERN_PRINT_5.get())
			.requires(PPItems.PATTERN_PRINT_1.get())
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.requires(PPItems.PATTERN_PRINT_MATERIAL)
			.unlockedBy("has_item", has(Items.COPPER_INGOT))
			.save(consumer, "pattern_print_5_c");
	}

}
