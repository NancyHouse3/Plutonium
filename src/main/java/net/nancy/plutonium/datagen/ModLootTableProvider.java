package net.nancy.plutonium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        //Standard Block Drops
        addDrop(ModBlocks.GRATE_BLOCK);
        addDrop(ModBlocks.NICCIUM_BLOCK);
        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);
        addDrop(ModBlocks.WEATHERED_GRAY_CONCRETE);

        addDrop(ModBlocks.GRATE_STAIRS);
        addDrop(ModBlocks.RED_BUTTON);
        addDrop(ModBlocks.YELLOW_FENCE);
        addDrop(ModBlocks.YELLOW_GATE);
        addDrop(ModBlocks.RUG_PLATE);
        addDrop(ModBlocks.SANDBAGS);
        addDrop(ModBlocks.MAN_HOLE_COVER);

        addDrop(ModBlocks.SECURITY_DOOR, doorDrops(ModBlocks.SECURITY_DOOR));
        addDrop(ModBlocks.GRATE_SLAB, slabDrops(ModBlocks.GRATE_SLAB));

        //Ore Drops
        addDrop(ModBlocks.NICCIUM_ORE, oreDrops(ModBlocks.NICCIUM_ORE, ModItems.RAW_NICCIUM));
        addDrop(ModBlocks.DEEPSLATE_NICCIUM_ORE, clusterOreDrop(ModBlocks.DEEPSLATE_NICCIUM_ORE, ModItems.RAW_NICCIUM,1.0f,4.0f));

        addDrop(ModBlocks.URANIUM_ORE, oreDrops(ModBlocks.URANIUM_ORE, ModItems.RAW_URANIUM));
        addDrop(ModBlocks.URANIUM_DEEPSLATE_ORE, clusterOreDrop(ModBlocks.URANIUM_DEEPSLATE_ORE, ModItems.RAW_URANIUM,1.0f,3.0f));
    }

    public LootTable.Builder clusterOreDrop(Block drop, Item item,float min, float max) { // for generating multiples like Copper or Lapis or Clay
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder)
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction
                                                .builder(UniformLootNumberProvider
                                        .create(min, max))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
