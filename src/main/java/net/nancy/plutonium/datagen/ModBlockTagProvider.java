package net.nancy.plutonium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.NICCIUM_ORE)
                .add(ModBlocks.URANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_NICCIUM_ORE)
                .add(ModBlocks.URANIUM_DEEPSLATE_ORE)
                .add(ModBlocks.GRATE_BLOCK)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_NICCIUM_ORE)
                .add(ModBlocks.GRATE_BLOCK)
                .add(ModBlocks.NICCIUM_BLOCK)
                .add(ModBlocks.NICCIUM_ORE)
                .add(ModBlocks.URANIUM_BLOCK)
                .add(ModBlocks.URANIUM_DEEPSLATE_ORE)
                .add(ModBlocks.URANIUM_ORE)
                .add(ModBlocks.WEATHERED_GRAY_CONCRETE)
        ;
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.SOUND_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.URANIUM_ORE)
                .add(ModBlocks.WEATHERED_GRAY_CONCRETE)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.NICCIUM_ORE)
                .add(ModBlocks.URANIUM_DEEPSLATE_ORE)
                .add(ModBlocks.DEEPSLATE_NICCIUM_ORE)
                .add(ModBlocks.GRATE_BLOCK)
                .add(ModBlocks.GRATE_STAIRS)
                .add(ModBlocks.GRATE_SLAB)
                .add(ModBlocks.YELLOW_GATE)
                .add(ModBlocks.YELLOW_FENCE)
                .add(ModBlocks.URANIUM_BLOCK)
                .add(ModBlocks.SECURITY_DOOR)
        ;
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
        ;
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NICCIUM_BLOCK)
        ;
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.YELLOW_FENCE)
        ;
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.YELLOW_GATE)
        ;
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SANDBAGS)
        ;
    }
}
