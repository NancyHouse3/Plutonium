package net.nancy.plutonium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.block.custom.MutfruitCropBlock;
import net.nancy.plutonium.block.custom.SchurirCropBlock;
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

        BlockStateModelGenerator.BlockTexturePool gratePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRATE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool yellowPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.YELLOW_BLOCK);
        BlockStateModelGenerator.BlockTexturePool redPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_BLOCK);
        BlockStateModelGenerator.BlockTexturePool sandbagPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SANDBAG_BLOCK);
        BlockStateModelGenerator.BlockTexturePool rugPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUG_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_GRAY_CONCRETE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        gratePool.stairs(ModBlocks.GRATE_STAIRS);
        gratePool.slab(ModBlocks.GRATE_SLAB);

        redPool.button(ModBlocks.RED_BUTTON);

        sandbagPool.wall(ModBlocks.SANDBAGS);

        rugPool.pressurePlate(ModBlocks.RUG_PLATE);

        yellowPool.fence(ModBlocks.YELLOW_FENCE);
        yellowPool.fenceGate(ModBlocks.YELLOW_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.SECURITY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAN_HOLE_COVER);

        blockStateModelGenerator.registerCrop(ModBlocks.MUTFRUIT_CROP, MutfruitCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.SCHURIR_CROP, SchurirCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAHLIA, ModBlocks.POTTED_DAHLIA, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NICCIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NICCIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.DUCT_TAPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROUND_556, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUTFRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCHURIR_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLYMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GASOLINE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BATON, Models.HANDHELD);

        itemModelGenerator.register(ModItems.NICCIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NICCIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NICCIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NICCIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NICCIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GUARD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GUARD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GUARD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GUARD_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POWERED_ARMOR_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POWERED_ARMOR_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POWERED_ARMOR_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.POWERED_ARMOR_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMPIRE_RECRUIT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMPIRE_RECRUIT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMPIRE_RECRUIT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMPIRE_RECRUIT_BOOTS));
    }
}
