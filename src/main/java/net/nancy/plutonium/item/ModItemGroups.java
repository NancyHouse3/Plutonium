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

                        entries.add(ModBlocks.GRATE_STAIRS);
                        entries.add(ModBlocks.GRATE_SLAB);
                        entries.add(ModBlocks.RED_BUTTON);
                        entries.add(ModBlocks.RUG_PLATE);
                        entries.add(ModBlocks.YELLOW_FENCE);
                        entries.add(ModBlocks.YELLOW_GATE);
                        entries.add(ModBlocks.SANDBAGS);
                        entries.add(ModBlocks.SECURITY_DOOR);
                        entries.add(ModBlocks.MAN_HOLE_COVER);

                        entries.add(ModItems.POLYMER);
                        entries.add(ModItems.DUCT_TAPE);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.FIRE_AXE);
                        entries.add(ModItems.BATON);
                        entries.add(ModItems.MUTFRUIT);
                        entries.add(ModItems.MUTFRUIT_SEEDS);
                        entries.add(ModItems.SCHURIR_LEAF);
                        entries.add(ModItems.SCHURIR_SEEDS);
                        entries.add(ModBlocks.DAHLIA);
                        entries.add(ModItems.GASOLINE);
                        entries.add(ModItems.ASSAULT_RIFLE);

                        entries.add(ModItems.NICCIUM_PICKAXE);
                        entries.add(ModItems.NICCIUM_AXE);
                        entries.add(ModItems.NICCIUM_SHOVEL);
                        entries.add(ModItems.NICCIUM_SWORD);
                        entries.add(ModItems.NICCIUM_HOE);

                        entries.add(ModItems.GUARD_HELMET);
                        entries.add(ModItems.GUARD_CHESTPLATE);
                        entries.add(ModItems.GUARD_LEGGINGS);
                        entries.add(ModItems.GUARD_BOOTS);

                        entries.add(ModItems.POWERED_ARMOR_HELMET);
                        entries.add(ModItems.POWERED_ARMOR_CHESTPLATE);
                        entries.add(ModItems.POWERED_ARMOR_LEGGINGS);
                        entries.add(ModItems.POWERED_ARMOR_BOOTS);

                        entries.add(ModItems.EMPIRE_RECRUIT_HELMET);
                        entries.add(ModItems.EMPIRE_RECRUIT_CHESTPLATE);
                        entries.add(ModItems.EMPIRE_RECRUIT_LEGGINGS);
                        entries.add(ModItems.EMPIRE_RECRUIT_BOOTS);

                    }).build());

    public static void registerItemGroups() {
        Plutonium.LOGGER.info("Registering mod items for " + Plutonium.MOD_ID+"! :)");
    }
}
