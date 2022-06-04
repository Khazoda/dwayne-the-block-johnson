package net.dwayne.the.block.johnson;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DwayneMod implements ModInitializer {

    public static SoundEvent DWAYNE_SOUND_EVENT = new SoundEvent(new Identifier("dwayne-the-block-johnson:dwayne"));
    public static final Block DWAYNE_BLOCK = new DwayneBlock(null, DWAYNE_SOUND_EVENT);
    public static final Block DWAYNE_SLAB = new SlabBlock(
            FabricBlockSettings.copyOf(Blocks.OBSIDIAN).luminance(12).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .hardness(1.5f).requiresTool());
    public static final Block DWAYNE_STAIRS = new DwayneStairs(DwayneMod.DWAYNE_BLOCK.getDefaultState(), null,
            DWAYNE_SOUND_EVENT);

    public static final Item DWAYNE_ITEM = new Item(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    // Block Items
    public static final BlockItem DWAYNE_BLOCK_ITEM = new BlockItem(DWAYNE_BLOCK,
            new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DWAYNE_SLAB_ITEM = new BlockItem(DWAYNE_SLAB,
            new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DWAYNE_STAIRS_ITEM = new BlockItem(DWAYNE_STAIRS,
            new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    @Override
    public void onInitialize() {
        // Items
        Registry.register(Registry.ITEM, new Identifier("dwayne-the-block-johnson", "dwayne_item"), DWAYNE_ITEM);
        // Block Items
        Registry.register(Registry.ITEM, new Identifier("dwayne-the-block-johnson", "dwayne_block"), DWAYNE_BLOCK_ITEM);
        Registry.register(Registry.ITEM, new Identifier("dwayne-the-block-johnson", "dwayne_stairs"),
                DWAYNE_STAIRS_ITEM);
        Registry.register(Registry.ITEM, new Identifier("dwayne-the-block-johnson", "dwayne_slab"),
                DWAYNE_SLAB_ITEM);
        // Blocks
        Registry.register(Registry.BLOCK, new Identifier("dwayne-the-block-johnson", "dwayne_block"), DWAYNE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("dwayne-the-block-johnson", "dwayne_stairs"), DWAYNE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("dwayne-the-block-johnson", "dwayne_slab"), DWAYNE_SLAB);

        // Sounds
        Registry.register(Registry.SOUND_EVENT, new Identifier("dwayne-the-block-johnson:dwayne"), DWAYNE_SOUND_EVENT);

    }

}
