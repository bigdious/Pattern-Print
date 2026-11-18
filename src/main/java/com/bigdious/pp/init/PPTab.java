package com.bigdious.pp.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class PPTab {
	public static void addToTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			event.insertAfter(new ItemStack(Items.WARPED_FUNGUS_ON_A_STICK), PPItems.PATTERN_PRINT_5.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(new ItemStack(Items.WARPED_FUNGUS_ON_A_STICK), PPItems.PATTERN_PRINT_4.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(new ItemStack(Items.WARPED_FUNGUS_ON_A_STICK), PPItems.PATTERN_PRINT_3.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(new ItemStack(Items.WARPED_FUNGUS_ON_A_STICK), PPItems.PATTERN_PRINT_2.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			event.insertAfter(new ItemStack(Items.WARPED_FUNGUS_ON_A_STICK), PPItems.PATTERN_PRINT_1.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
		}
	}
}
