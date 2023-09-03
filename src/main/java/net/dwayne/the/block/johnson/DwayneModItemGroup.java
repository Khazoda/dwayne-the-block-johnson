package net.dwayne.the.block.johnson;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import static net.dwayne.the.block.johnson.DwayneMod.*;

public class DwayneModItemGroup {
  public static ItemGroup createItemGroup() {
    return FabricItemGroup.builder()
        .icon(() -> new ItemStack(DwayneMod.DWAYNE_BLOCK))
        .displayName(Text.translatable("itemGroup.dwayne-the-block-johnson.itemGroup"))
        .entries((displayContext, entries) -> {
          entries.add(DWAYNE_ITEM);
          entries.add(DWAYNE_BLOCK_ITEM);
          entries.add(DWAYNE_SLAB_ITEM);
          entries.add(DWAYNE_WALL_ITEM);
          entries.add(DWAYNE_STAIRS_ITEM);
          entries.add(DWAYNE_FLOWER_ITEM);
          entries.add(POTTED_DWAYNE_ITEM);
        }).build();
  }
}
