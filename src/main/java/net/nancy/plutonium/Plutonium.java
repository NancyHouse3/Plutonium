package net.nancy.plutonium;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.item.ModItemGroups;
import net.nancy.plutonium.item.ModItems;
import net.nancy.plutonium.util.ModLootModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plutonium implements ModInitializer {
	public static final String MOD_ID = "plutonium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootModifiers.modifyLootTables();

		FuelRegistry.INSTANCE.add(ModItems.GASOLINE, 7200);
	}
}