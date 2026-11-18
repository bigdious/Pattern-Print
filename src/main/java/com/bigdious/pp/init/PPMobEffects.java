package com.bigdious.pp.init;

import com.bigdious.pp.PP;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PPMobEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, PP.MODID);

	public static final DeferredHolder<MobEffect, MobEffect> BUILDERS_FRAZZLE = MOB_EFFECTS.register("builders_frazzle", () -> new BuildersFrazzleMobEffect(MobEffectCategory.HARMFUL, 0x990099)
		.addAttributeModifier(Attributes.ATTACK_DAMAGE, PP.prefix("builders_frazzle.weakness"), -0.50, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
		.addAttributeModifier(Attributes.ARMOR, PP.prefix("builders_frazzle.armor"), -0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
		.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, PP.prefix("builders_frazzle.toughness"), -0.50, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

}
