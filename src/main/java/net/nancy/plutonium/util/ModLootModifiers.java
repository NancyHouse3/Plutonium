package net.nancy.plutonium.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.client.gl.Uniform;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.item.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootModifiers {

    public static final Identifier BONUS_CHEST_ID =
            new Identifier("minecraft","chests/spawn_bonus_chest");
    public static final Identifier ZOMBIE_ID =
            new Identifier("minecraft","entities/zombie");
    public static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft","archaeology/desert_pyramid");
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(BONUS_CHEST_ID.equals(id)) {
                Item[] newChestItems = {
                        ModItems.BATON,
                        ModItems.GUARD_HELMET,
                        ModItems.GUARD_CHESTPLATE,
                        ModItems.GUARD_LEGGINGS,
                        ModItems.GUARD_BOOTS,
                        ModItems.EMPIRE_RECRUIT_LEGGINGS,
                        ModItems.EMPIRE_RECRUIT_CHESTPLATE,
                        ModItems.DUCT_TAPE,
                        ModItems.GASOLINE,
                        ModItems.MUTFRUIT
                };

                for (Item c : newChestItems) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1f))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(c))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    tableBuilder.pool(poolBuilder.build());
                }
            }
            if(ZOMBIE_ID.equals(id)) {

                Item[] newZombieItems = {
                        ModItems.BATON,
                        ModItems.GUARD_HELMET,
                        ModItems.DUCT_TAPE,
                        ModItems.GASOLINE,
                        ModItems.MUTFRUIT,
                        ModItems.FIRE_AXE
                };

                for (Item c : newZombieItems) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1f))
                            .conditionally(RandomChanceLootCondition.builder(0.06f))
                            .with(ItemEntry.builder(c))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    tableBuilder.pool(poolBuilder.build());
                }
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {

            if(SUSPICIOUS_SAND_ID.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.MUTFRUIT).build());
                entries.add(ItemEntry.builder(ModItems.ROUND_556).build());
                entries.add(ItemEntry.builder(ModItems.URANIUM_INGOT).build());
                entries.add(ItemEntry.builder(Items.IRON_INGOT).build());
                entries.add(ItemEntry.builder(Items.GOLD_INGOT).build());
                entries.add(ItemEntry.builder(ModItems.METAL_DETECTOR).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }
}
