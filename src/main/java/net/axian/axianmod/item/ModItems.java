package net.axian.axianmod.item;

import net.axian.axianmod.AxianMod;
import net.axian.axianmod.item.custom.DowsingRodItem;
import net.axian.axianmod.item.custom.ModAxeItem;
import net.axian.axianmod.item.custom.ModHoeItem;
import net.axian.axianmod.item.custom.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // [1 - Mythril Ingot]
    // Register and create a new item with name 'mythril_ingot'. The item name that will be
    // displayed in-game is stored in a json file in resources/assets/axianmod/lang/en_us.json
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));


    // [2 - Mythril nugget]
    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));


    // [3 - Raw Mythril]
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // Dowsing Rod Item //////////////////////////////////////////////////////////////////////////

    // [1 - Dowsing Rod]
    // Uses maxDamage method to make the item not stack.
    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(16)));

    // Fuel Items ////////////////////////////////////////////////////////////////////////////////

    // [Lilac Flower Bulb]
    public static final Item LILAC_FLOWER_BULB = registerItem("lilac_flower_bulb",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // Food Items ////////////////////////////////////////////////////////////////////////////////

    // [Grape Food]
    public static final Item GRAPE = registerItem("grape",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // Tool Items ////////////////////////////////////////////////////////////////////////////////

    // [Sword]
    public static final Item MYTHRIL_SWORD = registerItem("mythril_sword",
            new SwordItem(ModToolMaterials.MYTHRIL, 2, 4f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // [Axe]
    public static final Item MYTHRIL_AXE = registerItem("mythril_axe",
            new ModAxeItem(ModToolMaterials.MYTHRIL, 4, 2f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // [Hoe]
    public static final Item MYTHRIL_HOE = registerItem("mythril_hoe",
            new ModHoeItem(ModToolMaterials.MYTHRIL, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // [Shovel]
    public static final Item MYTHRIL_SHOVEL = registerItem("mythril_shovel",
            new ShovelItem(ModToolMaterials.MYTHRIL, 0, 2f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // [Pickaxe]
    public static final Item MYTHRIL_PICKAXE = registerItem("mythril_pickaxe",
            new ModPickaxeItem(ModToolMaterials.MYTHRIL, 2, 0f,
                    new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    // Methods ///////////////////////////////////////////////////////////////////////////////////

    // This method registers the item passed under the identifier MOD_ID and the item name passed.
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(AxianMod.MOD_ID, name), item);
    }

    // This method will be called on the onInitialize method inside the class AxianMod.
    public static void registerModItems() {
        AxianMod.LOGGER.info("Registering Mod Items for " + AxianMod.MOD_ID);
    }

}
