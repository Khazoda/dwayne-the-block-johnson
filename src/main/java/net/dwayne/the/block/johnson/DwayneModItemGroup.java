package net.dwayne.the.block.johnson;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import static net.dwayne.the.block.johnson.DwayneTheModJohnson.*;

public class DwayneModItemGroup {
  public static ItemGroup createItemGroup() {
    return FabricItemGroup.builder()
        .icon(() -> new ItemStack(DwayneTheModJohnson.DWAYNE_BLOCK))
        .name(Text.translatable("itemGroup.dwayne_the_block_johnson.itemGroup"))
        .entries((displayContext, collector) -> {
            collector.addItem(DWAYNE_ITEM);
            collector.addItem(DwayneTheModJohnson.getItem(DWAYNE_BLOCK));
            collector.addItem(DwayneTheModJohnson.getItem(DWAYNE_SLAB));
            collector.addItem(DwayneTheModJohnson.getItem(DWAYNE_WALL));
            collector.addItem(DwayneTheModJohnson.getItem(DWAYNE_STAIRS));
            collector.addItem(DwayneTheModJohnson.getItem(DWAYNE_FLOWER));
            collector.addItem(DwayneTheModJohnson.getItem(POTTED_DWAYNE));
        }).build();
  }
}
