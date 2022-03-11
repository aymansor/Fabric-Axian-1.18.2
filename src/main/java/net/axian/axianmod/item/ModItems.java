package net.axian.axianmod.item;

import net.axian.axianmod.AxianMod;
import net.axian.axianmod.item.custom.DowsingRodItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
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
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE)));

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
