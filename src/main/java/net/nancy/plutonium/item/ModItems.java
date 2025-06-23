package net.nancy.plutonium.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.Plutonium;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.item.custom.AssaultRifleItem;
import net.nancy.plutonium.item.custom.MetalDetectorItem;

public class ModItems {
    public static final Item POLYMER = registerItem("polymer", new Item(new FabricItemSettings()));
    public static final Item DUCT_TAPE = registerItem("duct_tape", new Item(new FabricItemSettings()));
    public static final Item ROUND_556 = registerItem("556_round", new Item(new FabricItemSettings()));
    public static final Item ASSAULT_RIFLE = registerItem("assault_rifle", new AssaultRifleItem(new FabricItemSettings().maxCount(1).maxDamage(512),3,1.5f,1.8f));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));
    public static final Item FIRE_AXE = registerItem("fire_axe", new AxeItem(ToolMaterials.IRON,5f,0.5f,new FabricItemSettings()));
    public static final Item BATON = registerItem("baton", new SwordItem(ToolMaterials.IRON,5,2.5f,new FabricItemSettings().maxDamage(128)));
    public static final Item MUTFRUIT = registerItem("mutfruit", new Item(new FabricItemSettings().food(ModFoodComponents.MUTFRUIT)));
    public static final Item GASOLINE = registerItem("gasoline", new Item(new FabricItemSettings()));
    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new FabricItemSettings()));
    public static final Item URANIUM_INGOT = registerItem("uranium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_NICCIUM = registerItem("raw_niccium", new Item(new FabricItemSettings()));
    public static final Item NICCIUM_INGOT = registerItem("niccium_ingot", new Item(new FabricItemSettings()));

    public static final Item NICCIUM_PICKAXE = registerItem(
            "niccium_pickaxe",
            new PickaxeItem(ModToolMaterial.NICCIUM,
                    4,
                    2f,
                    new FabricItemSettings()
            )
    );
    public static final Item NICCIUM_AXE = registerItem(
            "niccium_axe",
            new AxeItem(ModToolMaterial.NICCIUM,
                    4,
                    1.5f,
                    new FabricItemSettings()
            )
    );
    public static final Item NICCIUM_SHOVEL = registerItem(
            "niccium_shovel",
            new ShovelItem(ModToolMaterial.NICCIUM,
                    5,
                    1.5f,
                    new FabricItemSettings()
            )
    );
    public static final Item NICCIUM_SWORD = registerItem(
            "niccium_sword",
            new SwordItem(ModToolMaterial.NICCIUM,
                    7,
                    3f,
                    new FabricItemSettings()
            )
    );
    public static final Item NICCIUM_HOE = registerItem(
            "niccium_hoe",
            new HoeItem(ModToolMaterial.NICCIUM,
                    2,
                    1f,
                    new FabricItemSettings()
            )
    );
    public static final Item GUARD_HELMET = registerItem(
            "guard_helmet",
            new ArmorItem(ModArmorMaterials.GUARD,
            ArmorItem.Type.HELMET,
            new FabricItemSettings())
    );
    public static final Item GUARD_CHESTPLATE = registerItem(
            "guard_chestplate",
            new ArmorItem(ModArmorMaterials.GUARD,
            ArmorItem.Type.CHESTPLATE,
            new FabricItemSettings())
    );
    public static final Item GUARD_LEGGINGS = registerItem(
            "guard_leggings",
            new ArmorItem(ModArmorMaterials.GUARD,
            ArmorItem.Type.LEGGINGS,
            new FabricItemSettings())
    );
    public static final Item GUARD_BOOTS = registerItem(
            "guard_boots",
            new ArmorItem(ModArmorMaterials.GUARD,
            ArmorItem.Type.BOOTS,
            new FabricItemSettings())
    );
    public static final Item POWERED_ARMOR_HELMET = registerItem(
            "powered_armor_helmet",
            new ArmorItem(ModArmorMaterials.POWERED_ARMOR,
                    ArmorItem.Type.HELMET,
                    new FabricItemSettings())
    );
    public static final Item POWERED_ARMOR_CHESTPLATE = registerItem(
            "powered_armor_chestplate",
            new ArmorItem(ModArmorMaterials.POWERED_ARMOR,
                    ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings())
    );
    public static final Item POWERED_ARMOR_LEGGINGS = registerItem(
            "powered_armor_leggings",
            new ArmorItem(ModArmorMaterials.POWERED_ARMOR,
                    ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings())
    );
    public static final Item POWERED_ARMOR_BOOTS = registerItem(
            "powered_armor_boots",
            new ArmorItem(ModArmorMaterials.POWERED_ARMOR,
                    ArmorItem.Type.BOOTS,
                    new FabricItemSettings())
    );
    public static final Item EMPIRE_RECRUIT_HELMET = registerItem(
            "empire_recruit_helmet",
            new ArmorItem(ModArmorMaterials.EMPIRE_RECRUIT,
                    ArmorItem.Type.HELMET,
                    new FabricItemSettings())
    );
    public static final Item EMPIRE_RECRUIT_CHESTPLATE = registerItem(
            "empire_recruit_chestplate",
            new ArmorItem(ModArmorMaterials.EMPIRE_RECRUIT,
                    ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings())
    );
    public static final Item EMPIRE_RECRUIT_LEGGINGS = registerItem(
            "empire_recruit_leggings",
            new ArmorItem(ModArmorMaterials.EMPIRE_RECRUIT,
                    ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings())
    );
    public static final Item EMPIRE_RECRUIT_BOOTS = registerItem(
            "empire_recruit_boots",
            new ArmorItem(ModArmorMaterials.EMPIRE_RECRUIT,
                    ArmorItem.Type.BOOTS,
                    new FabricItemSettings())
    );


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Plutonium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Plutonium.LOGGER.info("Register Mod Items for " + Plutonium.MOD_ID);
    }
}
