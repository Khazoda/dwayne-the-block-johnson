package net.dwayne.the.block.johnson;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class DwayneMod implements ModInitializer {


    public static final Item DWAYNE_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));


    public static SoundEvent DWAYNE_SOUND_EVENT = new SoundEvent(new Identifier("dwayne-the-block-johnson:dwayne"));
    public static final Block DWAYNE_BLOCK = new DwayneBlock(null,DWAYNE_SOUND_EVENT);

    @Override
    public void onInitialize() {
        // Items
        Registry.register(Registry.ITEM, new Identifier("dwayne-the-block-johnson","dwayne_item"), DWAYNE_ITEM);   
        // Block Items
        Registry.register(Registry.ITEM, new Identifier("dwayne-the-block-johnson","dwayne_block"), new BlockItem(DWAYNE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        // Blocks
        Registry.register(Registry.BLOCK, new Identifier("dwayne-the-block-johnson","dwayne_block"),DWAYNE_BLOCK);
        // Sounds
        Registry.register(Registry.SOUND_EVENT, new Identifier("dwayne-the-block-johnson:dwayne"), DWAYNE_SOUND_EVENT);

    }
    
    
}
