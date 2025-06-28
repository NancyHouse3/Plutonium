package net.nancy.plutonium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.nancy.plutonium.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class PlutoniumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MUTFRUIT_CROP, RenderLayer.getCutout());
    }
}
