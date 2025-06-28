package net.nancy.plutonium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.Plutonium;
import net.nancy.plutonium.block.custom.MutfruitCropBlock;
import net.nancy.plutonium.block.custom.SoundBlock;

public class ModBlocks {
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block URANIUM_DEEPSLATE_ORE = registerBlock("uranium_deepslate_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block NICCIUM_BLOCK = registerBlock("niccium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block NICCIUM_ORE = registerBlock("niccium_ore", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DEEPSLATE_NICCIUM_ORE = registerBlock("deepslate_niccium_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block WEATHERED_GRAY_CONCRETE = registerBlock("weathered_gray_concrete", new Block(FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE)));
    public static final Block RED_BLOCK = registerBlock("red_block", new Block(FabricBlockSettings.copyOf(Blocks.GLASS)));
    public static final Block YELLOW_BLOCK = registerBlock("yellow_block", new Block(FabricBlockSettings.copyOf(Blocks.GLASS)));
    public static final Block RUG_BLOCK = registerBlock("rug_block", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));
    public static final Block GRATE_BLOCK = registerBlock("grate_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block SANDBAG_BLOCK = registerBlock("sandbag_block", new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block GRATE_STAIRS = registerBlock("grate_stairs", new StairsBlock(ModBlocks.GRATE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block GRATE_SLAB = registerBlock("grate_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RED_BUTTON = registerBlock("red_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON,10,true));
    public static final Block RUG_PLATE = registerBlock("rug_plate", new PressurePlateBlock(
            PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK),
            BlockSetType.IRON
    ));
    public static final Block YELLOW_FENCE = registerBlock("yellow_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block YELLOW_GATE = registerBlock("yellow_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.OAK));
    public static final Block SANDBAGS = registerBlock("sand_bags", new WallBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
    public static final Block SECURITY_DOOR = registerBlock("security_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block MAN_HOLE_COVER = registerBlock("man_hole_cover", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block MUTFRUIT_CROP = Registry.register(Registries.BLOCK, new Identifier(Plutonium.MOD_ID, "mutfruit_crop"),
            new MutfruitCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Plutonium.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Plutonium.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Plutonium.LOGGER.info("Nancy's Plutonium mod is actively making sure we got the blocks!! >w<");
    }
}
