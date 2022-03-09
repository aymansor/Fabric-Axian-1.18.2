package net.axian.axianmod.block;

import net.axian.axianmod.AxianMod;
import net.axian.axianmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    // [4 - Mythril Block]
    // Register and create a new block with name 'mythril_block'. The item name that will be
    // displayed in-game is stored in a json file in resources/assets/axianmod/lang/en_us.json
    // The strength method determines how long it takes to break the block. This block will
    // require a pickaxe to be mined.
    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.MYTHRIL);


    // [5 - Mythril Ore]
    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);


    // [6 - Deepslate Mythril Ore]
    public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);


    // [7 - Netherrack Mythril Ore]
    public static final Block NETHERRACK_MYTHRIL_ORE = registerBlock("netherrack_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(0.6f).requiresTool()), ModItemGroup.MYTHRIL);


    // [8 - Raw Mythril Block]
    public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(7.5f).requiresTool()), ModItemGroup.MYTHRIL);




    // Methods //////////////////////////////////////////////////////////////////////////////////

    // This method registers a new block and calls another method to create the block item.
    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(AxianMod.MOD_ID, name), block);
    }


    // This method registers a new block item.
    private static void registerBlockItem(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(AxianMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }


    // This method will be called on the onInitialize method inside the class AxianMod.
    public static void registerModBlocks() {
        AxianMod.LOGGER.info("Registering ModBlocks for " + AxianMod.MOD_ID);
    }

}
