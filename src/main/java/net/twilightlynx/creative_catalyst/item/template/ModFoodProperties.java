package net.twilightlynx.creative_catalyst.item.template;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties HAMBURGER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.90f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED,
                    1000 , 2), 0.75f).build();

    public static final FoodProperties FRENCH_FIES = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.30f).build();

}