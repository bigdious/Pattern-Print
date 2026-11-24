package com.bigdious.pp.data;

import com.bigdious.pp.data.helper.DNLangProvider;
import com.bigdious.pp.init.PPItems;
import com.bigdious.pp.init.PPMobEffects;
import net.minecraft.data.PackOutput;

import java.util.HashMap;
import java.util.Map;


public class PPLangGenerator extends DNLangProvider {
	public static final Map<String, String> SUBTITLE_GENERATOR = new HashMap<>();

	public PPLangGenerator(PackOutput output) {
		super(output);
	}
	@Override
	protected void addTranslations() {

		this.addItem(PPItems.PATTERN_PRINT_MATERIAL, "Latticed Board");
		this.addItem(PPItems.PATTERN_PRINT_1, "Pattern Print 3□");
		this.addItem(PPItems.PATTERN_PRINT_2, "Pattern Print 5□");
		this.addItem(PPItems.PATTERN_PRINT_3, "Pattern Print 7□");
		this.addItem(PPItems.PATTERN_PRINT_4, "Pattern Print 9□");
		this.addItem(PPItems.PATTERN_PRINT_5, "Pattern Print 11□");

		this.add("item.pp.pattern_print_1.with_block", "Pattern Print 3□ (%s)");
		this.add("item.pp.pattern_print_2.with_block", "Pattern Print 5□ (%s)");
		this.add("item.pp.pattern_print_3.with_block", "Pattern Print 7□ (%s)");
		this.add("item.pp.pattern_print_4.with_block", "Pattern Print 9□ (%s)");
		this.add("item.pp.pattern_print_5.with_block", "Pattern Print 11□ (%s)");

		this.add("tooltip.pp.pattern_print", "Pattern saved with %s position(s)");

		this.add("tooltip.pp.pattern_print.hidden", "[Hold Shift for Usages]");
		this.add("tooltip.pp.pattern_print.start", "How to use:");
		this.add("tooltip.pp.pattern_print.1", "1. Hold item to see selection range");
		this.add("tooltip.pp.pattern_print.2", "2. Shift-rightclick a block to save it");
		this.add("tooltip.pp.pattern_print.3", "3. If any other blocks of the same type are present within the selection, their relative position will also be saved");
		this.add("tooltip.pp.pattern_print.4", "4. Once a pattern is saved, shift-rightclicking a different block will change block type but not pattern");
		this.add("tooltip.pp.pattern_print.5", "5. Holding the item now shows how the pattern will be placed");
		this.add("tooltip.pp.pattern_print.6", "6. Right click in air to rotate pattern clockwise");
		this.add("tooltip.pp.pattern_print.7", "7. Right click on a block to place the pattern");
		this.add("tooltip.pp.pattern_print.8", "8. Blocks will only be placed if they can be consumed from inventory and placement is not obstructed");
		this.add("tooltip.pp.pattern_print.9", "9. Continue using the item however you wish");
		this.add("tooltip.pp.pattern_print.10", "10. Put item into crafting grid at any time to reset saved pattern and block type");

		this.addEffect(PPMobEffects.BUILDERS_FRAZZLE, "Builder's Frazzle");
		//I have no clue why the subtitle generator is broken
		this.add("subtitles.pp.item.pattern_print.denied", "Block is copyrighted, cannot be printed");
		this.add("subtitles.pp.item.pattern_print.fail", "Pattern Print has no blocks to use");
		this.add("subtitles.pp.item.pattern_print.rotated", "Pattern rotated");

		SUBTITLE_GENERATOR.forEach(this::add);
	}
}
