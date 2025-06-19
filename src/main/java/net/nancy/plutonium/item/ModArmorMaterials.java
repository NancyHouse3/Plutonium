package net.nancy.plutonium.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.nancy.plutonium.Plutonium;

import java.util.function.Supplier;

public class ModArmorMaterials implements ArmorMaterial {

    //CHAIN("vault guard",20,new int[] { 3, 8, 6 ,3}, 19,SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2f, 0f, () -> Ingredient.ofItems())

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmmounts;

    private final int enchantability;

    private final SoundEvent equipSound;

    private final float toughness;

    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11,16,15,13};

    public ModArmorMaterials (
            String name,
            int durabilityMultiplier,
            int[] protectionAmmounts,
            int enchantability,
            SoundEvent equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmmounts = protectionAmmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Plutonium.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
