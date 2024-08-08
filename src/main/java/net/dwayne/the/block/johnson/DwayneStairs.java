package net.dwayne.the.block.johnson;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DwayneStairs extends StairsBlock {
  Random rand;

  public DwayneStairs(BlockState baseBlockState, Settings settings) {
    super(baseBlockState, settings);
    rand = new Random();
  }

  @Override
  public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
    // Client Code
    if (world.isClient) {
      if (Math.sqrt(Math.pow(entity.getVelocity().x, 2) + Math.pow(entity.getVelocity().y, 2) + Math.pow(entity.getVelocity().z, 2)) >= 0.25) {
        world.addParticle(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
            rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f));
        world.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
            rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f));
      }
    }
  }
}
