package net.nancy.plutonium;

import net.fabricmc.api.ModInitializer;

import net.nancy.plutonium.block.ModBlocks;
import net.nancy.plutonium.item.ModItemGroups;
import net.nancy.plutonium.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plutonium implements ModInitializer {
	public static final String MOD_ID = "plutonium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
	}
}