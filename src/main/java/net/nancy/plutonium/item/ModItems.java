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
import net.nancy.plutonium.item.custom.MetalDetectorItem;

public class ModItems {
    public static final Item POLYMER = registerItem("polymer", new Item(new FabricItemSettings()));
    public static final Item DUCT_TAPE = registerItem("duct_tape", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));
    public static final Item FIRE_AXE = registerItem("fire_axe", new AxeItem(ToolMaterials.IRON,5f,0.5f,new FabricItemSettings()));
    public static final Item MUTFRUIT = registerItem("Mutfruit", new Item(new FabricItemSettings().food(ModFoodComponents.MUTFRUIT)));

    public static final Item RAW_URANIUM = registerItem("raw_uranium", new Item(new FabricItemSettings()));
    public static final Item URANIUM_INGOT = registerItem("uranium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_NICCIUM = registerItem("raw_niccium", new Item(new FabricItemSettings()));
    public static final Item NICCIUM_INGOT = registerItem("niccium_ingot", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Plutonium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Plutonium.LOGGER.info("Register Mod Items for " + Plutonium.MOD_ID);
    }
}
