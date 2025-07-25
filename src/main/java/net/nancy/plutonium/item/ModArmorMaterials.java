package net.nancy.plutonium.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.nancy.plutonium.Plutonium;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    GUARD(
            "guard",
            12,
            new int[] { 2, 5, 3 ,2},
            19,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
            0.0f,
            0.0f,
            () -> Ingredient.ofItems(ModItems.DUCT_TAPE,ModItems.POLYMER)
    ),
    EMPIRE_RECRUIT(
            "empire_recruit",
            8,
            new int[] { 2, 4, 3 ,2},
            19,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0f,
            0.0f,
            () -> Ingredient.ofItems(ModItems.DUCT_TAPE,Items.LEATHER)
    ),
    POWERED_ARMOR(
            "powered_armor",
            75,
            new int[] { 5, 10, 6 ,4},
            19,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
            1.0f,
            0.1f,
            () -> Ingredient.ofItems(ModItems.DUCT_TAPE, Items.IRON_INGOT)
    );

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmmounts;

    private final int enchantability;

    private final SoundEvent equipSound;

    private final float toughness;

    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11,16,15,13};

    ModArmorMaterials (
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
        return protectionAmmounts[type.ordinal()];
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
