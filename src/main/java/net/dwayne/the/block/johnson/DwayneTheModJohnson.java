package net.dwayne.the.block.johnson;

import net.minecraft.block.AbstractBlock;
import net.minecraft.item.ItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class DwayneTheModJohnson implements ModInitializer {
  private static final String DWAYNE_THE_ID_JOHNSON = "dwayne_the_block_johnson";
  private static final Logger DWAYNE_THE_LOGGER_JOHNSON = LoggerFactory.getLogger(DWAYNE_THE_ID_JOHNSON);
  private static final ItemGroup DWAYNE_THE_ITEM_GROUP_JOHNSON = DwayneModItemGroup.createItemGroup();
  private static final SoundEvent DWAYNE_THE_SOUND_EVENT_JOHNSON = SoundEvent.createVariableRangeEvent(Identifier.of(DWAYNE_THE_ID_JOHNSON, "dwayne"));
  private static final AbstractBlock.Settings DWAYNE_THE_BLOCK_SETTINGS_JOHNSON = AbstractBlock.Settings.copy(Blocks.STONE)
          .luminance(b -> 12)
          .sounds(BlockSoundGroup.AMETHYST_BLOCK)
          .hardness(1.5f).toolRequired();
  private static final Map<Block, Item> DWAYNE_THE_MAP_JOHNSON = new HashMap<>();

  public static final Block DWAYNE_BLOCK = new DwayneBlock(DWAYNE_THE_BLOCK_SETTINGS_JOHNSON, DWAYNE_THE_SOUND_EVENT_JOHNSON);
  public static final Block DWAYNE_SLAB = new SlabBlock(DWAYNE_THE_BLOCK_SETTINGS_JOHNSON);
  public static final Block DWAYNE_WALL = new WallBlock(DWAYNE_THE_BLOCK_SETTINGS_JOHNSON);
  public static final Block DWAYNE_STAIRS = new DwayneStairs(DwayneTheModJohnson.DWAYNE_BLOCK.getDefaultState(), DWAYNE_THE_BLOCK_SETTINGS_JOHNSON);
  public static final Block DWAYNE_FLOWER = new FlowerBlock(StatusEffects.SLOWNESS, 8, AbstractBlock.Settings.copy(Blocks.POPPY).strength(0.0F).nonOpaque());
  public static final Block POTTED_DWAYNE = new FlowerPotBlock(DWAYNE_FLOWER, AbstractBlock.Settings.copy(Blocks.FLOWER_POT).strength(0.0F).nonOpaque());

  public static final Item DWAYNE_ITEM = new Item(new Item.Settings());

  @Override
  public void onInitialize() {
    // dwayne 'the item groups' johnson
    dwayneTheRegisterJohnson(Registries.ITEM_GROUP, DWAYNE_THE_ID_JOHNSON, DWAYNE_THE_ITEM_GROUP_JOHNSON);

    // dwayne 'the items' johnson
    dwayneTheRegisterJohnson(Registries.ITEM, "dwayne_item", DWAYNE_ITEM);

    // dwayne 'the blocks' johnson
    dwayneTheRegisterBlockJohnson("dwayne_block", DWAYNE_BLOCK);
    dwayneTheRegisterBlockJohnson("dwayne_slab", DWAYNE_SLAB);
    dwayneTheRegisterBlockJohnson("dwayne_wall", DWAYNE_WALL);
    dwayneTheRegisterBlockJohnson("dwayne_stairs", DWAYNE_STAIRS);
    dwayneTheRegisterBlockJohnson("dwayne_flower", DWAYNE_FLOWER);
    dwayneTheRegisterBlockJohnson("potted_dwayne", POTTED_DWAYNE);

    // dwayne 'the sounds' johnson
    dwayneTheRegisterJohnson(Registries.SOUND_EVENT, "dwayne", DWAYNE_THE_SOUND_EVENT_JOHNSON);

    // dwayne 'the message' johnson
    DWAYNE_THE_LOGGER_JOHNSON.info("Dwayne 'The Log' Johnson");
  }

  public static Item getItem(Block block) {
    return DWAYNE_THE_MAP_JOHNSON.get(block);
  }

  public static void dwayneTheRegisterBlockJohnson(String dwayneThePathJohnson, Block dwayneTheBlockJohnson) {
    var block = dwayneTheRegisterJohnson(Registries.BLOCK, dwayneThePathJohnson, dwayneTheBlockJohnson);
    var item = dwayneTheRegisterJohnson(Registries.ITEM, dwayneThePathJohnson, new BlockItem(dwayneTheBlockJohnson, new Item.Settings()));

    DWAYNE_THE_MAP_JOHNSON.put(block, item);
  }

  public static <T> T dwayneTheRegisterJohnson(Registry<T> dwayneTheRegistryJohnson, String dwayneThePathJohnson, T dwayneTheObjectJohnson) {
    return Registry.register(dwayneTheRegistryJohnson, dwayneTheIdentifierJohnson(dwayneThePathJohnson), dwayneTheObjectJohnson);
  }

  public static Identifier dwayneTheIdentifierJohnson(String dwayneThePathJohnson) {
    return Identifier.of(DWAYNE_THE_ID_JOHNSON, dwayneThePathJohnson);
  }
}
