package net.dwayne.the.block.johnson;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class DwayneBlock extends Block {

  public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;
  public SoundEvent DWAYNE_SOUND_EVENT = null;
  Random rand;

  public DwayneBlock(Settings settings, SoundEvent dwayne_sound_event) {
    super(FabricBlockSettings.copyOf(Blocks.STONE).luminance(12).sounds(BlockSoundGroup.AMETHYST_BLOCK)
        .hardness(1.5f).requiresTool());

    this.setDefaultState((BlockState) ((BlockState) ((BlockState) this.stateManager.getDefaultState())
        .with(Properties.HORIZONTAL_FACING, Direction.NORTH)).with(TRIGGERED, false));

    rand = new Random();
    DWAYNE_SOUND_EVENT = dwayne_sound_event;

  }

  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return (BlockState) this.getDefaultState().with(Properties.HORIZONTAL_FACING,
        ctx.getHorizontalPlayerFacing().getOpposite());
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                            BlockHitResult hit) {

    if(!player.getMainHandStack().isOf(DwayneMod.DWAYNE_ITEM)) return ActionResult.PASS;
    // Server Code
    if (!world.isClient) {
      world.playSound(null, pos, SoundEvents.BLOCK_MEDIUM_AMETHYST_BUD_PLACE, SoundCategory.BLOCKS, 1f, 1f);
    }
    // Client Code
    if (world.isClient) {
      player.addVelocity(0, 0.35, 0);
      for (int i = 0; i < 3; i++) {
        world.addParticle(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
            rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f));
        world.addParticle(ParticleTypes.GLOW, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
            rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f), rand.nextFloat(-0.15f, 0.15f));
      }
    }
    return ActionResult.SUCCESS;
  }

  @Override
  public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos,
                             boolean notify) {
    boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.up());
    boolean bl2 = state.get(TRIGGERED);
    if (bl && !bl2) {
      world.scheduleBlockTick(pos, this, 4);
      world.setBlockState(pos, (BlockState) state.with(TRIGGERED, true), Block.NO_REDRAW);
      world.playSound(null, pos, DWAYNE_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f);
    } else if (!bl && bl2) {
      world.setBlockState(pos, (BlockState) state.with(TRIGGERED, false), Block.NO_REDRAW);
    }
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
    stateManager.add(Properties.HORIZONTAL_FACING, TRIGGERED);
  }

}
