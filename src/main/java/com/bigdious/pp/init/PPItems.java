package com.bigdious.pp.init;

import com.bigdious.pp.PP;
import com.bigdious.pp.items.PatternPrintComponent;
import com.bigdious.pp.items.PatternPrintItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class PPItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PP.MODID);
	public static <T extends Item> DeferredItem<T> register(String name, Function<Item.Properties, T> item, Supplier<Item.Properties> properties) {
		return ITEMS.register(name, () -> item.apply(properties.get()));
	}

	public static final DeferredItem<Item> PATTERN_PRINT_1 = register("pattern_print_1", PatternPrintItem::new, () -> new Item.Properties().component(PPDataComponents.PATTERN_PRINT_COMPONENT, PatternPrintComponent.EMPTY).component(PPDataComponents.PRINT_RANGE, 1).stacksTo(1));
	//this is ugly, but its smooth both for crafting and for the average player. Adding a new crafting type just for this is not worth the effort longterm
	public static final DeferredItem<Item> PATTERN_PRINT_2 = register("pattern_print_2", PatternPrintItem::new, () -> new Item.Properties().component(PPDataComponents.PATTERN_PRINT_COMPONENT, PatternPrintComponent.EMPTY).component(PPDataComponents.PRINT_RANGE, 2).stacksTo(1));
	public static final DeferredItem<Item> PATTERN_PRINT_3 = register("pattern_print_3", PatternPrintItem::new, () -> new Item.Properties().component(PPDataComponents.PATTERN_PRINT_COMPONENT, PatternPrintComponent.EMPTY).component(PPDataComponents.PRINT_RANGE, 3).stacksTo(1));
	public static final DeferredItem<Item> PATTERN_PRINT_4 = register("pattern_print_4", PatternPrintItem::new, () -> new Item.Properties().component(PPDataComponents.PATTERN_PRINT_COMPONENT, PatternPrintComponent.EMPTY).component(PPDataComponents.PRINT_RANGE, 4).stacksTo(1));
	public static final DeferredItem<Item> PATTERN_PRINT_5 = register("pattern_print_5", PatternPrintItem::new, () -> new Item.Properties().component(PPDataComponents.PATTERN_PRINT_COMPONENT, PatternPrintComponent.EMPTY).component(PPDataComponents.PRINT_RANGE, 5).stacksTo(1));

}