package net.nancy.plutonium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.Plutonium;
import net.nancy.plutonium.block.custom.SoundBlock;

public class ModBlocks {
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block URANIUM_DEEPSLATE_ORE = registerBlock("uranium_deepslate_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block NICCIUM_BLOCK = registerBlock("niccium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block NICCIUM_ORE = registerBlock("niccium_ore", new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DEEPSLATE_NICCIUM_ORE = registerBlock("deepslate_niccium_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

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
