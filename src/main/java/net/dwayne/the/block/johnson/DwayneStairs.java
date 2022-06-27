package net.dwayne.the.block.johnson;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DwayneStairs extends StairsBlock {

  public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;
  public SoundEvent DWAYNE_SOUND_EVENT = null;

  Random rand;

  public DwayneStairs(BlockState baseBlockState, Settings settings, SoundEvent dwayne_sound_event) {
    super(baseBlockState,
        FabricBlockSettings.copyOf(Blocks.STONE).luminance(12).sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .hardness(1.5f).requiresTool());

    rand = new Random();

  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
      BlockHitResult hit) {
    return ActionResult.CONSUME;
  }

  @Override
  public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
    if (!world.isClient) {
      if (entity.getVelocity().x != 0) {
        world.playSound(null, pos, SoundEvents.BLOCK_MEDIUM_AMETHYST_BUD_PLACE, SoundCategory.BLOCKS, 1f, 1f);
      }
    }
    // Client Code
    if (world.isClient) {
      if (entity.getVelocity().x != 0) {
        for (int i = 0; i < 10; i++) {
          world.addParticle(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
              rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f));
          world.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
              rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f));
        }
      }
    }
  }
}
