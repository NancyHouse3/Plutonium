package net.nancy.plutonium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nancy.plutonium.Plutonium;
import net.minecraft.item.ItemGroup;
import net.nancy.plutonium.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup URANIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Plutonium.MOD_ID, "uranium_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.uranium"))
                    .icon(() -> new ItemStack(ModItems.URANIUM_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RAW_URANIUM);
                        entries.add(ModItems.URANIUM_INGOT);
                        entries.add(ModBlocks.URANIUM_ORE);
                        entries.add(ModBlocks.URANIUM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.URANIUM_BLOCK);

                        entries.add(ModItems.RAW_NICCIUM);
                        entries.add(ModItems.NICCIUM_INGOT);
                        entries.add(ModBlocks.NICCIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_NICCIUM_ORE);
                        entries.add(ModBlocks.NICCIUM_BLOCK);

                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModBlocks.WEATHERED_GRAY_CONCRETE);
                        entries.add(ModBlocks.GRATE_BLOCK);

                        entries.add(ModItems.POLYMER);
                        entries.add(ModItems.DUCT_TAPE);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.FIRE_AXE);
                        entries.add(ModItems.MUTFRUIT);
                        entries.add(ModItems.GASOLINE);

                    }).build());

    public static void registerItemGroups() {
        Plutonium.LOGGER.info("Registering mod items for " + Plutonium.MOD_ID+"! :)");
    }
}
