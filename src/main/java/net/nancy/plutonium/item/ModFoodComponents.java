package net.nancy.plutonium.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {

    public static final FoodComponent MUTFRUIT = new FoodComponent.Builder().hunger(4).saturationModifier(0.30f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 0.25f).build();
}
