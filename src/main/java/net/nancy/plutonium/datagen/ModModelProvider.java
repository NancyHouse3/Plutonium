package net.nancy.plutonium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_NICCIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NICCIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NICCIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRATE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_GRAY_CONCRETE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NICCIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NICCIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.DUCT_TAPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUTFRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLYMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GASOLINE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_AXE, Models.GENERATED);
    }
}
