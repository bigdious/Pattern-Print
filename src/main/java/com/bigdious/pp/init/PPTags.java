package com.bigdious.pp.init;

import com.bigdious.pp.PP;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class PPTags {
	public static class Items {
		public static final TagKey<Item> ITEM_FRAMES = create("item_frames");
		private static TagKey<Item> create(String name) {
			return ItemTags.create(ResourceLocation.fromNamespaceAndPath(PP.MODID, name));
		}
	}

	public static class Blocks {
		public static final TagKey<Block> COPYRIGHTED = create("copyrighted");
		private static TagKey<Block> create(String name) {
			return BlockTags.create(ResourceLocation.fromNamespaceAndPath(PP.MODID, name));
		}
	}
}
