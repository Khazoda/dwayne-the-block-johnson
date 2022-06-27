package net.dwayne.the.block.johnson;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public final class DwayneModClient implements ClientModInitializer {
        @Override
        @Environment(EnvType.CLIENT)
        public void onInitializeClient() {
                BlockRenderLayerMap.INSTANCE.putBlock(DwayneMod.DWAYNE_FLOWER, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(DwayneMod.POTTED_DWAYNE, RenderLayer.getCutout());

        }

}
