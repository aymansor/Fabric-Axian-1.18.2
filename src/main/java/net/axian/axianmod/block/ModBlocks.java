package net.axian.axianmod.block;

import net.axian.axianmod.AxianMod;
import net.axian.axianmod.block.custom.*;
import net.axian.axianmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {

    // [4 - Mythril Block]
    // Register and create a new block with name 'mythril_block'. The item name that will be
    // displayed in-game is stored in a json file in resources/assets/axianmod/lang/en_us.json
    // The strength method determines how long it takes to break the block. This block will
    // require a pickaxe to be mined.
    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.MYTHRIL,
            "tooltip.axianmod.mythril_block");


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


    // Custom Blocks ////////////////////////////////////////////////////////////////////////////
    // [Speedy Block]
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(2.5f).requiresTool()), ModItemGroup.MYTHRIL);

    // [Mythril Button]
    public static final Block MYTHRIL_BUTTON = registerBlock("mythril_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(4.0f).requiresTool().noCollision()), ModItemGroup.MYTHRIL);

    // [Mythril Pressure Plate]
    public static final Block MYTHRIL_PRESSURE_PLATE = registerBlock("mythril_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL)
                    .strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    // [Mythril Fence]
    public static final Block MYTHRIL_FENCE = registerBlock("mythril_fence",
            new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    // [Mythril Fence Gate]
    public static final Block MYTHRIL_FENCE_GATE = registerBlock("mythril_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    // [Mythril Wall]
    public static final Block MYTHRIL_WALL = registerBlock("mythril_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_SLAB = registerBlock("mythril_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_STAIRS = registerBlock("mythril_stairs",
            new ModStairsBlock(ModBlocks.MYTHRIL_BLOCK.getDefaultState(),
                    FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block KAUPEN_DOOR = registerBlock("kaupen_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4.0f).requiresTool().nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block KAUPEN_TRAPDOOR = registerBlock("kaupen_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4.0f).requiresTool().nonOpaque()), ModItemGroup.MYTHRIL);


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

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(AxianMod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(AxianMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world,
                                              List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }





    // This method will be called on the onInitialize method inside the class AxianMod.
    public static void registerModBlocks() {
        AxianMod.LOGGER.info("Registering ModBlocks for " + AxianMod.MOD_ID);
    }

}
