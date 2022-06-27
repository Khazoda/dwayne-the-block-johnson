package net.dwayne.the.block.johnson;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class DwayneFlower extends FlowerBlock {

    public DwayneFlower(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(StatusEffects.JUMP_BOOST, 7,
                FabricBlockSettings.copyOf(Blocks.CORNFLOWER));
        // TODO Auto-generated constructor stub
    }

}
